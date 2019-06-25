package com.st.il.infinitymotors.adminapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * An order.
 *
 * @author Tonny Huang
 * @author Vien Yeung
 * @author Al Amine
 * @author Henry Cho
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
	 * the total price of the order.
	 */
	@Column
	private int totalPrice;
	/**
	 * the purchase date of the order.
	 */
	@Column
	private LocalDate purchaseDate;
	
	@JsonManagedReference
	@OneToMany(mappedBy="order",
			fetch = FetchType.EAGER)
	private List<OrderItem> orderItems = new ArrayList();
	
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
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	public void addOrderItem(OrderItem order) {
		this.orderItems.add(order);
	}

	public Order() {
	}

	public Order(int orderId) {
		this.orderId = orderId;
	}

	public Order(int orderId, User client, int totalPrice, LocalDate purchaseDate) {
		this.orderId = orderId;
		this.client = client;
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
		return "Order [orderId=" + orderId + ", client=" + client + ", car1=" + 
				", totalPrice=" + totalPrice + ", purchaseDate=" + purchaseDate + "]";
	}

}
