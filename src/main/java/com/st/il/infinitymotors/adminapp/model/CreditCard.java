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
 * A creditcard the database.
 *
 * @author Tonny Huang
 * @author Vien Yeung
 * @author Al Amine
 * @author Henry cho
 */
@Entity
@Table(name = "tbl_creditcard")
public class CreditCard {
	/**
	 * The ID number used to refer to this credit card in the database.
	 */
	@Id
	@Column(name = "creditcardNum")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int creditcardNum;
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
		return creditcardNum;
	}
	
	public void setCreditCardNum(int creditcardNum) {
		this.creditcardNum = creditcardNum;
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

	public CreditCard(int creditcardNum) {
		this.creditcardNum = creditcardNum;
	}

	public CreditCard(int creditcardNum, int csv, String expirationDate) {
		this.creditcardNum = creditcardNum;
		this.csv = csv;
		this.expirationDate = expirationDate;
	}
	
	public CreditCard(int creditcardNum, User owner, int csv, String expirationDate) {
		super();
		this.creditcardNum = creditcardNum;
		this.owner = owner;
		this.csv = csv;
		this.expirationDate = expirationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + creditcardNum;
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
		if (creditcardNum != other.creditcardNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreditCard [creditcardNum=" + creditcardNum + ", owner=" + owner + ", csv=" + csv + ", expirationDate="
				+ expirationDate + "]";
	}
}
