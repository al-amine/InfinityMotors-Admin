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
@Table(name = "tbl_cart")
public class Cart {
	/**
	 * The ID number used to refer to this cart in the database.
	 */
	@Id
	@Column(name = "cartId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	/**
	 * The Owner of the cart.
	 */
	@OneToOne
	@JoinColumn(name = "userId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User owner;
	/**
	 * The first car option in this cart.
	 */
	@ManyToOne
	@JoinColumn(name = "carId1")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Car car1;
	/**
	 * The second car option in this cart.
	 */
	@ManyToOne
	@JoinColumn(name = "carId2")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Car car2;
	
	/**
	 * The Getters and Setters for all the parameters.
	 */
	
	public int getCartId() {
		return cartId;
	}
	
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
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

	public Cart() {
		
	}

	public Cart(int cartId) {
		this.cartId = cartId;
	}

	public Cart(int cartId, User owner, Car car1, Car car2) {
		this.cartId = cartId;
		this.owner = owner;
		this.car1 = car1;
		this.car2 = car2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
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
		Cart other = (Cart) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", owner=" + owner + ", car1=" + car1 + ", car2=" + car2 + "]";
	}
	
}
