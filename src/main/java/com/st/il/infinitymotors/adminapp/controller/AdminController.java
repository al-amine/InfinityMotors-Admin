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
import org.springframework.web.bind.annotation.RestController;

import com.st.il.infinitymotors.adminapp.model.Car;
import com.st.il.infinitymotors.adminapp.service.AdministratorService;

import javassist.NotFoundException;

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
}
