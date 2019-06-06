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
@Table(name = "tbl_coupon")
public class Coupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer couponId;
	
	@Column(name="percentage")
	Integer percentage;

	public Coupon() {}
	
	public Coupon(Integer couponId, Integer percentage) {
		super();
		this.couponId = couponId;
		this.percentage = percentage;
	}

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
	
}
