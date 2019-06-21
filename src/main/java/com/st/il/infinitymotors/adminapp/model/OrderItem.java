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
 * An item in OrderItem.
 *
 * @author Tonny Huang
 * @author Vien Yeung
 * @author Al Amine
 * @author Henry Cho
 */
@Entity
@Table(name = "tbl_orderitem")
public class OrderItem {
	
	/**
	 * The ID number used to refer to this orderitem in the database.
	 */
	@Id
	@Column(name = "orderitemId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderitemId;
	
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
		return orderitemId;
	}

	public void setOrderItemId(Integer orderitemId) {
		this.orderitemId = orderitemId;
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

	public OrderItem() {
		
	}

	public OrderItem(Integer orderitemId) {
		this.orderitemId = orderitemId;
	}

	public OrderItem(Integer orderitemId, Order order, Car car) {
		this.orderitemId = orderitemId;
		this.order = order;
		this.car = car;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderitemId == null) ? 0 : orderitemId.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (orderitemId == null) {
			if (other.orderitemId != null)
				return false;
		} else if (!orderitemId.equals(other.orderitemId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderitemId [orderitemId=" + orderitemId + ", order=" + order + ", car=" + car + "]";
	}

	
}
