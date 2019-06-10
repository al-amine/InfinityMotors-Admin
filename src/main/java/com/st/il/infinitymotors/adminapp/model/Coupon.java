package com.st.il.infinitymotors.adminapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * A coupon in a the database.
 *
 * @author Tonny Huang
 * @author Vien Yeung
 * @author Al Amine
 */
@Entity
@Table(name = "tbl_coupon")
public class Coupon {
	
	/**
	 * The ID number used to refer to this credit card in the database.
	 */
	@Id
	@Column(name = "couponId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer couponId;
	
	@Column(name="percentage")
	private Integer percentage;
	
	/**
	 * The Getters and Setters for all the parameters.
	 */

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public Coupon() {
		
	}

	public Coupon(Integer couponId) {
		this.couponId = couponId;
	}

	public Coupon(Integer couponId, Integer percentage) {
		this.couponId = couponId;
		this.percentage = percentage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couponId == null) ? 0 : couponId.hashCode());
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
		Coupon other = (Coupon) obj;
		if (couponId == null) {
			if (other.couponId != null)
				return false;
		} else if (!couponId.equals(other.couponId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", percentage=" + percentage + "]";
	}
	
}
