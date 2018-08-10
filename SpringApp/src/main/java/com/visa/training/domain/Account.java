package com.visa.training.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="acct_type",discriminatorType=DiscriminatorType.STRING)
public abstract class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	float balance;
	@ManyToOne(cascade={CascadeType.PERSIST},fetch=FetchType.LAZY)	//Whenever persist is applied on Account then if persist is applicable on Customer then that persist option will happen automatically
	@JoinColumn(name="cust_id")
	Customer customer;
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(float balance){
		this.balance = balance;
	}
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	

}
