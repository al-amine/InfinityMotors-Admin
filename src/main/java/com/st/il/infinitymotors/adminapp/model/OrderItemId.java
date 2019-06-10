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
@Table(name = "tbl_orderItem")
public class OrderItemId {
	
	/**
	 * The ID number used to refer to this orderItem in the database.
	 */
	@Id
	@Column(name = "orderItemId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderItemId;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "carId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Car car;
	/**
	 * the Getters and Setters of the Class
	 */
	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	/**
	 * the Constructors of the Class
	 */

	public OrderItemId() {
		
	}

	public OrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public OrderItemId(Integer orderItemId, Order order, Car car) {
		this.orderItemId = orderItemId;
		this.order = order;
		this.car = car;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderItemId == null) ? 0 : orderItemId.hashCode());
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
		OrderItemId other = (OrderItemId) obj;
		if (orderItemId == null) {
			if (other.orderItemId != null)
				return false;
		} else if (!orderItemId.equals(other.orderItemId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderItemId [orderItemId=" + orderItemId + ", order=" + order + ", car=" + car + "]";
	}

	
}
