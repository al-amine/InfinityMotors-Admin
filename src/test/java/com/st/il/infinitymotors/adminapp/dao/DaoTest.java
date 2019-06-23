package com.st.il.infinitymotors.adminapp.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.st.il.infinitymotors.adminapp.model.Car;
import com.st.il.infinitymotors.adminapp.model.Order;
import com.st.il.infinitymotors.adminapp.model.OrderItem;
import com.st.il.infinitymotors.adminapp.model.User;
import com.st.il.infinitymotors.adminapp.service.XAdministratorService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DaoTest {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CarDao carDao;
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	/**
	 UserDao Test
	 **/
	
	private List<User> initUsers() {
		User u1 = new User(
				1,
				"user1",
				"password",
				"customer",
				"user1 user1",
				"fake address",
				"999-999-9999");
		
		User u2 = new User(
				2,
				"user2",
				"password",
				"customer",
				"user2 user2",
				"fake address",
				"999-999-9999");
		
		User u3 = new User(
				3,
				"user3",
				"password",
				"admin",
				"user3 user3",
				"fake address",
				"999-999-9999");
		
		userDao.save(u1);
		userDao.save(u2);
		userDao.save(u3);
		return userDao.findAll();
	}
	
	@Test
	public void findNonexistingUser() {
		assertThat(userDao.findById(99).isPresent())
			.isFalse();
	}
	
	@Test
	public void findExistingUser() {
		
		List<User> users = initUsers();
		
		Optional<User> found = 
				userDao.findById(users.get(0).getUserId());
		assertThat(found.isPresent())
			.isTrue();
		
		assertThat(found.get())
			.returns("user1", User::getUsername);
		
		assertThat(found.get())
			.returns("customer", User::getRole);
		
		assertThat(userDao.findByUsername("user2")).isNotEmpty();
	}
	
	@Test
	public void getAllUsers() {
		
		List<User> expected = initUsers();
		
		List<User> users = userDao.findAll();
		assertThat(users.size() == 3);
		
		assertThat(users)
			.containsExactlyInAnyOrderElementsOf(expected);
	
	}
	
	@Test
	public void addUser() {
		User u1 = new User(
				1,
				"addedUser",
				"password",
				"customer",
				"Added User",
				"fake address",
				"999-999-9999");
		User saved = userDao.save(u1);
		User found = userDao.findById(saved.getUserId()).get();
		assertThat(found).isEqualTo(saved);
		
	}
	
	@Test
	public void addAlreadyExistingUser() {
		User u1 = new User(
				1,
				"user1",
				"password",
				"customer",
				"user1 user1",
				"fake address",
				"999-999-9999");
		u1 = userDao.save(u1);
		User u2 = new User(
				u1.getUserId() + 1,
				"user1",
				"password",
				"customer",
				"user1 user1",
				"fake address",
				"999-999-9999"); 
		userDao.save(u2);
	}
	
	@Test
	public void updateUser() {
		User user = new User(
				1,
				"addedUser",
				"password",
				"customer",
				"Added User",
				"fake address",
				"999-999-9999");
		user = userDao.save(user);
		user.setUsername("updatedUser");
		user.setRole("admin");
		userDao.save(user);
		assertThat(userDao.getOne(user.getUserId()))
			.isEqualToComparingFieldByField(user);
	}
	
	@Test
	public void deleteUser() {
		List<User> users = initUsers();
		userDao.deleteById(users.get(0).getUserId());
		List<User> found = userDao.findAll();
		assertThat(found.size() == 2);
		assertThat(found).doesNotContain(users.get(0));
	}
	
	/**
	 OrderDao Tests
	 **/
	@Test
	public void getByUser() {
		List<User> users = initUsers();
		User u1 = users.get(0);
		User u2 = users.get(1);
		
		Order order1 = new Order(
				1,
				u1,
				100,
				LocalDate.now());
		order1 = orderDao.save(order1);
		Order order2 = new Order(
				2,
				u1,
				200,
				LocalDate.now());
		order2 = orderDao.save(order2);
		Order order3 = new Order(
				3,
				u2,
				300,
				LocalDate.now());
		order3 = orderDao.save(order3);
		
		List<Order> ordersByU1 = 
				orderDao.findAllByUser(u1.getUserId());
		List<Order> ordersByU2 = 
				orderDao.findAllByUser(u2.getUserId());
		
		assertThat(
				ordersByU1.size() == 2);
		assertThat(
				orderDao.findAllByUser(u2.getUserId()).size() == 1);
		assertThat(order1)
			.isEqualToComparingFieldByField(ordersByU1.get(0));
		assertThat(order2)
			.isEqualToComparingFieldByField(ordersByU1.get(1));
		assertThat(order3)
			.isEqualToComparingFieldByField(ordersByU2.get(0));
		
	}
	
	@Test
	public void getOrder() {
		List<User> users = initUsers();
		User user = users.get(0);
		
		Order order = new Order(1, user, 100, LocalDate.now());
		order = orderDao.save(order);
		
		Car car = new Car();
		car.setCarId(1);
		car = carDao.save(car);
		
		assertThat(carDao.getOne(car.getCarId()))
			.isEqualToComparingFieldByField(car);
		
		OrderItem item = new OrderItem(1, order, car);
		item = orderItemDao.save(item);
		
		assertThat(orderItemDao.count()).isEqualTo(1);
		
		assertThat(orderDao.getOne(order.getOrderId()))
			.isEqualToComparingFieldByField(order);
		
		order = orderDao.getOne(order.getOrderId());
		
		
	}
	
}
