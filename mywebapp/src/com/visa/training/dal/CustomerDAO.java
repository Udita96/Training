package com.visa.training.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import com.visa.training.domain.Customer;
import com.visa.training.domain.Product;
import com.visa.training.util.JpaUtil;

public class CustomerDAO {
	
	public Customer addNew(Customer c){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
		return c;
	}
	
	public Customer findOne(int id){
		EntityManager em =  JpaUtil.getEmf().createEntityManager();
		Customer c = em.find(Customer.class, id);	//p is in persistent state	//treat .class as syntax for this. '.class' is literal form of Class.
		em.close();
		return c;
	}
	
	public void delete(int id){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Customer c = em.find(Customer.class,id); //use find & not the user-defined findOne() as the it returns an object in detached state.
		tx.begin();
		em.remove(c);
		tx.commit();
		em.close();
	}

}
