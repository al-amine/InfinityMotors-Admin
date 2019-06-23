package com.st.il.infinitymotors.adminapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.st.il.infinitymotors.adminapp.exception.AlreadyExistsException;
import com.st.il.infinitymotors.adminapp.exception.BadRequestException;
import com.st.il.infinitymotors.adminapp.exception.NotFoundException;
import com.st.il.infinitymotors.adminapp.model.Car;
import com.st.il.infinitymotors.adminapp.model.Order;
import com.st.il.infinitymotors.adminapp.model.OrderDTO;
import com.st.il.infinitymotors.adminapp.model.User;
import com.st.il.infinitymotors.adminapp.service.AdministratorService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdministratorService service;
	
	@GetMapping("/cars")
	public List<Car> getAllCars() {
		return service.getAllCars();
	}
	
	@GetMapping("/car/{carId}")
	public ResponseEntity<Car> getCar(@PathVariable int carId) throws NotFoundException{
		Car car = service.getCar(carId);
		if(car != null)
			return new ResponseEntity<>(car, HttpStatus.OK);
		else
			throw new NotFoundException("Car with id=" + carId + " not found");
	}
	
	@PostMapping("/car")
	public ResponseEntity<Car> addCar(@RequestBody Car car){
		service.addCar(car.getType(), car.getMake(), car.getModel(), car.getYear(), car.getPrice(),
				car.getDiagonalView(), car.getSideView(), car.getInteriorView(), car.getSpecs(), car.getNumAvailable());
		return new ResponseEntity<>(car, HttpStatus.OK); 
	}
	
	@PutMapping("/car/{carId}")
	public ResponseEntity<Car> updateCar(@PathVariable int carId, @RequestBody Car car)throws NotFoundException{
		if(service.updateCar(car))
			return new ResponseEntity<>(car, HttpStatus.OK);
		else
			throw new NotFoundException("Car with id=" + carId + " not found");
	}
	
	@DeleteMapping("/car/{carId}")
	public ResponseEntity<Car> deleteCar(@PathVariable int carId) throws NotFoundException{
		if(service.deleteCar(carId))
			return new ResponseEntity<>(HttpStatus.OK);
		else
			throw new NotFoundException("Car with id=" + carId + " not found");
	}
	
	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@GetMapping("/user/{username}")
	@ResponseStatus(HttpStatus.OK)
	public User getUserByUsername(@PathVariable String username) throws NotFoundException {
		User user = service.getUser(username);
		
		return user;
	}
	
	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User user) throws AlreadyExistsException, BadRequestException {
		user = service.addUser(user);
		return user;
	}
	
	@PutMapping("/user/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User updateUser(@PathVariable int id, @RequestBody User user) throws NotFoundException, BadRequestException {
		user = service.updateUser(id, user);
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable int id) throws NotFoundException {
		service.deleteUser(id);
	}
	
	@GetMapping("/order/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Order getOrder(@PathVariable Integer id) throws NotFoundException {
		Order order = service.getOrder(id);
		
		return order;
	}
	
	@GetMapping("/orders")
	@ResponseStatus(HttpStatus.OK)
	public List<Order> getAllOrders() {
		return service.getOrders();
	}
	
	@GetMapping("user/{userId}/orders")
	@ResponseStatus(HttpStatus.OK)
	public List<Order> getOrderByOrdername(@PathVariable Integer userId) throws NotFoundException {
		List<Order> orders = service.getOrdersByUser(userId);
		
		return orders;
	}
	
	@PostMapping("/order")
	@ResponseStatus(HttpStatus.CREATED)
	public Order addOrder(@RequestBody OrderDTO orderDTO) throws BadRequestException, AlreadyExistsException{
		Order order = service.addOrder(orderDTO);
		return order;
	}
}
