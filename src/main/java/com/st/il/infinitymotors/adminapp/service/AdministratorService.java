package com.st.il.infinitymotors.adminapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.st.il.infinitymotors.adminapp.dao.CarDao;
import com.st.il.infinitymotors.adminapp.dao.CarSpecificationsDao;
//import com.st.il.infinitymotors.adminapp.dao.CartDao;
//import com.st.il.infinitymotors.adminapp.dao.CouponDao;
//import com.st.il.infinitymotors.adminapp.dao.CreditCardDao;
//import com.st.il.infinitymotors.adminapp.dao.InventoryDao;
//import com.st.il.infinitymotors.adminapp.dao.OrderDao;
//import com.st.il.infinitymotors.adminapp.dao.UserDao;
import com.st.il.infinitymotors.adminapp.model.Car;
import com.st.il.infinitymotors.adminapp.model.CarSpecifications;




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
//	@Autowired
//	private CartDao cartDao;
//	@Autowired
//	private CouponDao couponDao;
//	@Autowired
//	private CreditCardDao creditCardDao;
//	@Autowired
//	private InventoryDao inventoryDao;
//	@Autowired
//	private OrderDao orderDao;
//	@Autowired
//	private UserDao userDao;
	
	
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
		if(test.isEmpty())
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
}
