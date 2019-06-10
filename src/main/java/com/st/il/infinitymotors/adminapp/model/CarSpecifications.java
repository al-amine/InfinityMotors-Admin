package com.st.il.infinitymotors.adminapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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
	
	/**
	 * The ID number used to refer to this credit card in the database.
	 */
	@Id
	@Column(name = "carspecId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carspecId;
	
	@Column(name="engine")
	private String engine;
	
	@Column(name="transmission")
	private String transmission;
	
	@Column(name="color")
	private String color;
	
	@Column(name="horsepower")
	private int horsepower;
	
	@Column(name="weightLBS")
	private int weightLBS;
	
	@Column(name="heightIN")
	private int heightIN;
	
	@Column(name="lenghtIN")
	private int lenghtIN;
	
	@Column(name="widthIN")
	private int widthIN;
	
	/**
	 * The Getters and Setters for all the parameters.
	 */

	public Integer getCarspecId() {
		return carspecId;
	}

	public void setCarspecId(Integer carspecId) {
		this.carspecId = carspecId;
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

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public int getWeightLBS() {
		return weightLBS;
	}

	public void setWeightLBS(int weightLBS) {
		this.weightLBS = weightLBS;
	}

	public int getHeightIN() {
		return heightIN;
	}

	public void setHeightIN(int heightIN) {
		this.heightIN = heightIN;
	}

	public int getLenghtIN() {
		return lenghtIN;
	}

	public void setLenghtIN(int lenghtIN) {
		this.lenghtIN = lenghtIN;
	}

	public int getWidthIN() {
		return widthIN;
	}

	public void setWidthIN(int widthIN) {
		this.widthIN = widthIN;
	}

	public CarSpecifications() {
		
	}

	public CarSpecifications(Integer carspecId) {
		this.carspecId = carspecId;
	}

	public CarSpecifications(Integer carspecId, String engine, String transmission, String color, int horsepower,
			int weightLBS, int heightIN, int lenghtIN, int widthIN) {
		this.carspecId = carspecId;
		this.engine = engine;
		this.transmission = transmission;
		this.color = color;
		this.horsepower = horsepower;
		this.weightLBS = weightLBS;
		this.heightIN = heightIN;
		this.lenghtIN = lenghtIN;
		this.widthIN = widthIN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carspecId == null) ? 0 : carspecId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarSpecifications other = (CarSpecifications) obj;
		if (carspecId == null) {
			if (other.carspecId != null)
				return false;
		} else if (!carspecId.equals(other.carspecId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarSpecifications [carspecId=" + carspecId + ", engine=" + engine + ", transmission=" + transmission
				+ ", color=" + color + ", horsepower=" + horsepower + ", weightLBS=" + weightLBS + ", heightIN="
				+ heightIN + ", lenghtIN=" + lenghtIN + ", widthIN=" + widthIN + "]";
	}
	
	
	
}
