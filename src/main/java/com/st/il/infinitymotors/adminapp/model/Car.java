package com.st.il.infinitymotors.adminapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * A car in a the database.
 *
 * @author Tonny Huang
 * @author Vien Yeung
 * @author Al Amine
 */
@Entity
@Table(name = "tbl_car")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carId;
	
	@Column(name="type")
	private String type;
	
	@Column(name="make")
	private String make;
	
	@Column(name="model")
	private String model;
	
	@Column(name="year")
	private Integer year;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="vinnumber")
	private String vinNumber;
	
	private CarSpecifications specs;

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public CarSpecifications getSpecs() {
		return specs;
	}

	public void setSpecs(CarSpecifications specs) {
		this.specs = specs;
	}

	public Car() {}
	
	public Car(Integer carId, String type, String make, String model, Integer year, Integer price, String vinNumber,
			CarSpecifications specs) {
		super();
		this.carId = carId;
		this.type = type;
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.vinNumber = vinNumber;
		this.specs = specs;
	}
	
	

}
