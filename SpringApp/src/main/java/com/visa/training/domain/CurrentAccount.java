package com.visa.training.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends Account{
	@Column(name="OD_Limit")
	float odLimit;

	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(float balance, float odLimit) {
		super(balance);
		this.odLimit = odLimit;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CurrentAccount [odLimit=" + odLimit + ", id=" + id + ", balance=" + balance + "]";
	}

	public float getOdLimit() {
		return odLimit;
	}

	public void setOdLimit(float odLimit) {
		this.odLimit = odLimit;
	}
	
	

}
