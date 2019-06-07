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
@Table(name = "tbl_creditcard")
public class CreditCard {
	/**
	 * The ID number used to refer to this credit card in the database.
	 */
	@Id
	@Column(name = "creditCardNum")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int creditCardNum;
	/**
	 * The Owner of the credit card.
	 */
	@ManyToOne
	@JoinColumn(name = "userId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User owner;
	/**
	 * The CSV of the card.
	 */
	@Column
	private int csv;
	/**
	 * The Expiration Date of the card.
	 */
	@Column
	private String expirationDate;
	
	/**
	 * The Getters and Setters for all the parameters.
	 */
	
	public int getCreditCardNum() {
		return creditCardNum;
	}
	
	public void setCreditCardNum(int creditCardNum) {
		this.creditCardNum = creditCardNum;
	}
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public int getCsv() {
		return csv;
	}
	
	public void setCsv(int csv) {
		this.csv = csv;
	}
	
	public String getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	/**
	 * Constructors.
	 */
	public CreditCard() {

	}

	public CreditCard(int creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	public CreditCard(int creditCardNum, int csv, String expirationDate) {
		this.creditCardNum = creditCardNum;
		this.csv = csv;
		this.expirationDate = expirationDate;
	}
	
	public CreditCard(int creditCardNum, User owner, int csv, String expirationDate) {
		super();
		this.creditCardNum = creditCardNum;
		this.owner = owner;
		this.csv = csv;
		this.expirationDate = expirationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + creditCardNum;
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
		CreditCard other = (CreditCard) obj;
		if (creditCardNum != other.creditCardNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreditCard [creditCardNum=" + creditCardNum + ", owner=" + owner + ", csv=" + csv + ", expirationDate="
				+ expirationDate + "]";
	}
	

	
}
