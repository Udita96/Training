package com.visa.training;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.visa.training.domain.Account;
import com.visa.training.domain.Customer;
import com.visa.training.domain.SavingsAccount;
import com.visa.training.util.JpaUtil;

public class AssociationDemo {

	public static void main(String[] args) {
		//createNewAccountWithNewCustomer();
		//demoLazy();
		//createNewAccountWithExistingCustomer();
		demoOwningVsInverseSides();

	}
	
	private static void demoOwningVsInverseSides() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Customer c1 = em.find(Customer.class, 38);
		Customer c2 = em.find(Customer.class, 39);
		Customer c3 = em.find(Customer.class, 40);
		System.out.println("Customer with id "+c1.getId()+"has "+c1.getAccounts().size()+" accounts");
		System.out.println("Customer with id "+c2.getId()+"has "+c2.getAccounts().size()+" accounts");
		//c1.getAccounts().add(c2.getAccounts().get(0)); // Only list will get manipulated but no effect on DB
		//c2.getAccounts().get(0).setCustomer(c3);	//DB will be effected by this execution.
		Account toBeTransferred = c2.getAccounts().get(0);
		c2.getAccounts().remove(0);
		toBeTransferred.setCustomer(c1);
		
		tx.commit();
		em.close();
	}

	private static void createNewAccountWithExistingCustomer(){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		SavingsAccount sa = new SavingsAccount(19999);
		//Customer c = em.find(Customer.class, 39);
		Customer c = em.getReference(Customer.class, 39);	//doesn't go to DB and creates a Customer proxy in persistent state. Use this only when you are sure that a customer with the given id exist.
		sa.setCustomer(c);
		em.persist(sa);
		tx.commit();
		em.close();
	}
	
	private static void demoLazy(){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Account a  = em.find(Account.class, 33);
		System.out.println("Account with id "+a.getId()+" belongs to "+a.getCustomer().getFirstName());
		em.close();
	}

	private static void createNewAccountWithNewCustomer() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Customer c = new Customer("fn","mn","ln", new Date(System.currentTimeMillis()));
		SavingsAccount sa = new SavingsAccount(199999);
		sa.setCustomer(c);
		//em.persist(c);		//for saving account to be created it is mandatory to have an existing customer, ie, customer object should be in persistent state for saving accounts to go into persistent state.
		em.persist(sa);		//since cascade has been implemented therefore we don't need the above line to persist customer object.
		tx.commit();
		em.close();
	}

}
