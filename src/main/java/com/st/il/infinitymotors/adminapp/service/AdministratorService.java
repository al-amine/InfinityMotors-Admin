package com.st.il.infinitymotors.adminapp.service;

import java.time.LocalDate;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.il.infinitymotors.adminapp.dao.CarDao;
import com.st.il.infinitymotors.adminapp.dao.CarSpecificationsDao;
import com.st.il.infinitymotors.adminapp.dao.OrderDao;
import com.st.il.infinitymotors.adminapp.dao.OrderItemDao;
import com.st.il.infinitymotors.adminapp.dao.UserDao;
import com.st.il.infinitymotors.adminapp.exception.AlreadyExistsException;
import com.st.il.infinitymotors.adminapp.exception.BadRequestException;
import com.st.il.infinitymotors.adminapp.exception.NotFoundException;
//import com.st.il.infinitymotors.adminapp.dao.CartDao;
//import com.st.il.infinitymotors.adminapp.dao.CouponDao;
//import com.st.il.infinitymotors.adminapp.dao.CreditCardDao;
//import com.st.il.infinitymotors.adminapp.dao.InventoryDao;
//import com.st.il.infinitymotors.adminapp.dao.OrderDao;
//import com.st.il.infinitymotors.adminapp.dao.UserDao;
import com.st.il.infinitymotors.adminapp.model.Car;
import com.st.il.infinitymotors.adminapp.model.CarSpecifications;
import com.st.il.infinitymotors.adminapp.model.Order;
import com.st.il.infinitymotors.adminapp.model.OrderDTO;
import com.st.il.infinitymotors.adminapp.model.OrderItem;
import com.st.il.infinitymotors.adminapp.model.User;




/**
 * @author Tonny Huang
 * @author Vien Yeung
 * @author Al Amine
 * @author Henry Cho
 */

@Service
public class AdministratorService {

	
	@Autowired
	private CarDao carDao;
	
	@Autowired
	private CarSpecificationsDao carSpecificationsDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	
	
	/* Car services */
	
	public Car addCar(String type, String make, String model, int year, int price, String engine,
			String transmission,String color,int horsepower,int weightLBS,int heightIN,int lenghtIN,int widthIN,
			String diagonalView, String sideView, String interiorView, int numAvailable) {
		
		Car car = new Car();
        CarSpecifications carspec = new CarSpecifications();
        carspec.setEngine(engine);
        carspec.setTransmission(transmission);
        carspec.setColor(color);
        carspec.setHorsepower(horsepower);
        carspec.setWeightLBS(weightLBS);
        carspec.setHeightIN(heightIN);
        carspec.setLenghtIN(lenghtIN);
        carspec.setWidthIN(widthIN);
        
        carSpecificationsDao.save(carspec);
        
        car.setType(type);
        car.setMake(make);
        car.setModel(model);
        car.setYear(year);
        car.setPrice(price);
        car.setSpecs(carspec);
        car.setDiagonalView(diagonalView);
        car.setSideView(sideView);
        car.setInteriorView(interiorView);
        car.setNumAvailable(numAvailable);
        
        carDao.save(car);
        
        return car;
	}
	public Car addCar(String type, String make, String model, int year, int price, String diagonalView, String sideView, String interiorView, 
			CarSpecifications carspec, int numAvailable) {
		carSpecificationsDao.save(carspec);
		Car car = new Car();
		car.setType(type);
        car.setMake(make);
        car.setModel(model);
        car.setYear(year);
        car.setPrice(price);
        car.setSpecs(carspec);
        car.setDiagonalView(diagonalView);
        car.setSideView(sideView);
        car.setInteriorView(interiorView);
        car.setNumAvailable(numAvailable);
        carDao.save(car);
        return car;
	}
	
	public boolean updateCar(Car car) {
		Optional<Car> test = carDao.findById(car.getCarId());
		if(!test.isPresent())
			return false;
		else {
			carSpecificationsDao.saveAndFlush(car.getSpecs());
			carDao.saveAndFlush(car);
			return true;
		}
	}
	
	public List<Car> getAllCars(){
		return carDao.findAll();
	}
	
	public Car getCar(int carId) {
		Optional<Car> car = carDao.findById(carId);
		if(car.isPresent())
			return car.get();
		else
			return null;
	}
	
	public boolean deleteCar(int carId) {
		Optional<Car> car = carDao.findById(carId);
		if(car.isPresent()) {
			carDao.delete(car.get());
			return true;
		}
		else
			return false;
	}
	
	//adds a number to numAvailable for a car
	//to decrease, use negative numbers
	public boolean addNumAvailable(int carId, int addNum) {
		Optional<Car> car = carDao.findById(carId);
		if(car.isPresent()) {
			Car temp = car.get();
			temp.setNumAvailable(temp.getNumAvailable()+addNum);
			carDao.saveAndFlush(temp);
			return true;
		}
		else
			return false;
	}
	
	/**********************************
	 Order Services 
	 **********************************/
	
	public Order getOrder(Integer orderId) throws NotFoundException {
		Order out = null;
		try {
			out = orderDao.findById(orderId).get();
		} catch(NoSuchElementException e) {
			throw new NotFoundException("Order with id=" + orderId +  "not found");
		}
		return out;
	}
	
	public List<Order> getOrders(){
		List<Order> out = orderDao.findAll();
		for(int i = 0; i < out.size(); i++ ) {
			 out.get(i).setOrderItems(orderItemDao.findAllByOrder(out.get(i).getOrderId()));
		}
		return out;
	}
	
	public List<Order> getOrdersByUser(Integer userId){
		return orderDao.findAllByUser(userId);
	}
	
	//TODO: AlreadyExistExceptions should be replaced with new exceptions
	@Transactional
	public Order addOrder(OrderDTO orderDTO) throws BadRequestException, AlreadyExistsException {
		Order order = new Order();
		try {
			order.setClient(userDao.findById(orderDTO.getUserId()).get());
			order.setPurchaseDate(LocalDate.parse(orderDTO.getPurchaseDate()));
		} catch(NoSuchElementException e) {
			throw new AlreadyExistsException("User does not exit.");
		} catch(DateTimeParseException d) {
			throw new BadRequestException("Date is malformed. Please use this format: YYYY-MM-DD");
		}
		order.setTotalPrice(0);
		order = orderDao.save(order);
		
		for(int id: orderDTO.getOrderItems()) {
			OrderItem item = new OrderItem();
			item.setOrder(order);
			try {
				Car found = carDao.findById(id).get();
				order.setTotalPrice(order.getTotalPrice() + found.getPrice());
				found.setNumAvailable(found.getNumAvailable() - 1);
				found = carDao.save(found);
				if(found.getNumAvailable() < 0)
					throw new AlreadyExistsException("A car you ar attempting to order has ran out.");
				item.setCar(found);
			} catch(NoSuchElementException e) {
				throw new AlreadyExistsException("A car you are attempting to order does not exist.");
			}
			order.addOrderItem(orderItemDao.save(item));
		}
		return order;
	}
	
	/**********************************
	 User Services  
	 **********************************/
	public User getUser(Integer userId) throws NotFoundException {
		User out = null;
		try {
			out = userDao.findById(userId).get();
		} catch(NoSuchElementException e) {
			throw new NotFoundException("User with id=" + userId + " not found");
		}
		return out;
	}
	
	public User getUser(String username) throws NotFoundException {
		User out = null;
		try {
			out = userDao.findByUsername(username).get();
		} catch(NoSuchElementException e) {
			throw new NotFoundException("User with username=" + username + " not found");
		}
		return out;
	}
	
	public List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	public User addUser(User user) throws AlreadyExistsException, BadRequestException {
		if(userDao.findByUsername(user.getUsername()).isPresent())
			throw new AlreadyExistsException("User with id=" + user.getUserId() + " not found");
		if(user.getRole() != "customer" && user.getRole() != "admin")
			throw new BadRequestException("Please enter a valid role: customer | admin");
		user = userDao.save(user);
		return user;
	}
	
	public User updateUser(Integer userId, User user) throws NotFoundException, BadRequestException {
		if(!userDao.findById(userId).isPresent())
			throw new NotFoundException("Update failed. User with id=" + user.getUserId() + " not found");
		if(user.getRole() != "customer" && user.getRole() != "admin")
			throw new BadRequestException("Please enter a valid role: customer | admin");
		return userDao.save(user);
	}
	
	public void deleteUser(Integer userId) throws NotFoundException {
		if(!userDao.findById(userId).isPresent())
			throw new NotFoundException("Delete failed. User with id=" + userId + " not found");
		userDao.deleteById(userId);
	}
}
