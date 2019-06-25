package com.st.il.infinitymotors.adminapp.model;

import java.util.List;

public class OrderDTO {
	
	private Integer userId;
	
	private String purchaseDate;
	
	private List<Integer> orderItems;

	public OrderDTO() {}
	
	public OrderDTO(Integer userId, String purchaseDate, List<Integer> orderItems) {
		super();
		this.userId = userId;
		this.purchaseDate = purchaseDate;
		this.orderItems = orderItems;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public List<Integer> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Integer> orderItems) {
		this.orderItems = orderItems;
	}

}
