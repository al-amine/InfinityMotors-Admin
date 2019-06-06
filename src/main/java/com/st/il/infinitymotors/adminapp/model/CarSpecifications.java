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
@Table(name = "tbl_carspecs")
public class CarSpecifications {
	
	@Id
	Integer carId;
	
	@Column(name="engine")
	String engine;
	
	@Column(name="transmission")
	String transmission;
	
	@Column(name="color")
	String color;
	
	@Column(name="horsepower")
	String horsepower;
	
	@Column(name="weightLBS")
	String weightLBS;

	public CarSpecifications() {}
	
	public CarSpecifications(int carId, String engine, String transmission, String color, String horsepower,
			String weightLBS) {
		super();
		this.carId = carId;
		this.engine = engine;
		this.transmission = transmission;
		this.color = color;
		this.horsepower = horsepower;
		this.weightLBS = weightLBS;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(String horsepower) {
		this.horsepower = horsepower;
	}

	public String getWeightLBS() {
		return weightLBS;
	}

	public void setWeightLBS(String weightLBS) {
		this.weightLBS = weightLBS;
	}
	
	
}
