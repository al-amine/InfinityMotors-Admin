package com.st.il.infinitymotors.adminapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "tbl_inventory")
public class Inventory {
	/**
	 * The ID number used to refer to this Inventory in the database.
	 */
	@Id
	@Column(name = "inventoryId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryId;
	/**
	 * The Car in this inventory.
	 */
	@OneToOne
	@JoinColumn(name = "carId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Car car;
	/**
	 * the existing Number of that Car.
	 */
	@Column
	private int numAvailabe;
	
	/**
	 * The Getters and Setters for all the parameters.
	 */
	
	public int getInventoryId() {
		return inventoryId;
	}
	
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	
	public Car getCar() {
		return car;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}
	
	public int getNumAvailabe() {
		return numAvailabe;
	}
	
	public void setNumAvailabe(int numAvailabe) {
		this.numAvailabe = numAvailabe;
	}
	
	public Inventory() {
		
	}

	public Inventory(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Inventory(int inventoryId, Car car, int numAvailabe) {
		this.inventoryId = inventoryId;
		this.car = car;
		this.numAvailabe = numAvailabe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + inventoryId;
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
		Inventory other = (Inventory) obj;
		if (inventoryId != other.inventoryId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", car=" + car + ", numAvailabe=" + numAvailabe + "]";
	}
	
	
}
