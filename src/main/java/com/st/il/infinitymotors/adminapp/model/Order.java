package com.st.il.infinitymotors.adminapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_order")
public class Order {
	/**
	 * The ID number used to refer to this Inventory in the database.
	 */
	@Id
	@Column(name = "orderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	/**
	 * The Owner of the credit card.
	 */
	@ManyToOne
	@JoinColumn(name = "userId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User client;
	/**
	 * The first Car in this Order
	 */
	@OneToOne
	@JoinColumn(name = "carId1")
	private Car car1;
	/**
	 * The second Car in this Order
	 */
	@OneToOne
	@JoinColumn(name = "carId2")
	private Car car2;
	/**
	 * the total price of the order.
	 */
	@Column
	private int totalPrice;
	/**
	 * the purchase date of the order.
	 */
	@Column
	private String purchaseDate;
	
	/**
	 * The Getters and Setters for all the parameters.
	 */
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public User getClient() {
		return client;
	}
	
	public void setClient(User client) {
		this.client = client;
	}
	
	public Car getCar1() {
		return car1;
	}
	
	public void setCar1(Car car1) {
		this.car1 = car1;
	}
	
	public Car getCar2() {
		return car2;
	}
	
	public void setCar2(Car car2) {
		this.car2 = car2;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Order() {
	}

	public Order(int orderId) {
		this.orderId = orderId;
	}

	public Order(int orderId, User client, Car car1, Car car2, int totalPrice, String purchaseDate) {
		this.orderId = orderId;
		this.client = client;
		this.car1 = car1;
		this.car2 = car2;
		this.totalPrice = totalPrice;
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
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
		Order other = (Order) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", client=" + client + ", car1=" + car1 + ", car2=" + car2
				+ ", totalPrice=" + totalPrice + ", purchaseDate=" + purchaseDate + "]";
	}

}
