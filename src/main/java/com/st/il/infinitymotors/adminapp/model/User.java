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
@Table(name = "tbl_user")
public class User {
	/**
	 * The ID number used to refer to this Inventory in the database.
	 */
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	/**
	 * the username of the user.
	 */
	@Column
	private String username;
	/**
	 * the password of the user.
	 */
	@Column
	private String password;
	/**
	 * the role of the user.
	 */
	@Column
	private String role;
	/**
	 * the full name of the user.
	 */
	@Column
	private String fullname;
	/**
	 * the address of the user.
	 */
	@Column
	private String address;
	/**
	 * the phone number of the user.
	 */
	@Column
	private String phone;
	/**
	 * The Getters and Setters for all the parameters.
	 */
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getFullname() {
		return fullname;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User() {

	}

	public User(int userId) {
		this.userId = userId;
	}

	public User(int userId, String username, String password, String role, String fullname, String address,
			String phone) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.fullname = fullname;
		this.address = address;
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
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
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", fullname=" + fullname + ", address=" + address + ", phone=" + phone + "]";
	}
	
	
}
