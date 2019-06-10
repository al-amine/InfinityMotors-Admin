package com.st.il.infinitymotors.adminapp.service;

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
 * 
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
	
	public Car addCar(String type, String make, String model,int year,int price ,String vinNumber,String engine,
			String transmission,String color,int horsepower,int weightLBS,int heightIN,int lenghtIN,int widthIN
			,String diagonalview,String sideview,String interiorview) {
		
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
        car.setVinNumber(vinNumber);
        car.setSpecs(carspec);
        car.setDiagonalview(diagonalview);
        car.setSideview(sideview);
        car.setInteriorview(interiorview);
        
        carDao.save(car);
        
		System.out.println("Car created Successfully with all Specifications Details");
        return car;

	}
	
	
	
}
