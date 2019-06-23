package com.st.il.infinitymotors.adminapp.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.st.il.infinitymotors.adminapp.dao.CarDao;
import com.st.il.infinitymotors.adminapp.model.Car;
import com.st.il.infinitymotors.adminapp.model.CarSpecifications;

/**
 * Tests of administrator services.
 * @author Al Amine 
 * @author Henry Cho
 */

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AdminServiceTest {
	@Autowired
	CarDao carDao;
	@Autowired
	AdministratorService service;
	@Test
	public void createCar(){
		CarSpecifications specs = new CarSpecifications();
		specs.setEngine("V8");
		specs.setTransmission("automatic");
		specs.setColor("blue");
		specs.setHorsepower(800);
		specs.setWeightLBS(1800);
		specs.setHeightIN(95);
		specs.setLenghtIN(190);
		specs.setWidthIN(50);
		
		Car car = new Car();
		car.setSpecs(specs);
		car.setType("compact");
		car.setMake("Toyota");
		car.setModel("Camry");
		car.setYear(2018);
		car.setPrice(200000);
		car.setNumAvailable(4);
		car.setDiagonalView("httpCam1");
		car.setSideView("httpCam2");
		car.setInteriorView("httpCam3");
		
		Car car2 = service.addCar("compact", "Toyota", "Camry", 2018, 200000, "httpCam1", "httpCam2", "httpCam3", specs, 4);
		assertEquals(car, car2);
	}
	
	@Test
	public void findCar() {
		Car car = service.getCar(1);
		assertEquals(car.getModel(), "Civic");
	}
	
	@Test
	public void updateCar() {
		Car car = service.getCar(4);
		car.setModel("P2");
		service.updateCar(car);
		assertEquals(service.getCar(4).getModel(), "P2");
	}
	
	@Test
	public void deleteCar() {
		service.deleteCar(4);
		assertEquals(service.getCar(4), null);
	}
}
