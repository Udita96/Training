package com.visa.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.Query;

import com.visa.training.domain.Product;
import com.visa.training.util.JpaUtil;

public class ProductDAO {
	
	public void delete(int id){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Product p = em.find(Product.class,id); //use find & not the user-defined findOne() as the it returns an object in detached state.
		tx.begin();
		em.remove(p);
		tx.commit();
		em.close();
	}
	
	public void changePrice(int id,float newPrice){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Product p = em.find(Product.class,id);
		tx.begin();
		p.setPrice(newPrice);
		tx.commit();
		em.close();
		
	}
	
	public Product findOne(int id){
		EntityManager em =  JpaUtil.getEmf().createEntityManager();
		Product p = em.find(Product.class, id);	//p is in persistent state	//treat .class as syntax for this. '.class' is literal form of Class.
		display(p);
		em.close();
		System.out.println(p);
		return p;
	}
	
	public Product addNew(Product p){		//p in transient state
		EntityManagerFactory emf = JpaUtil.getEmf();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(p);		//p in persistent state
		
		tx.commit();
		em.close();			//p is in detach state
		return p;			//the method returns an object in detached state
		
	}
	
	public void display(Product p){
		if(p==null){
			System.out.println("Empty Product Object");
			return;
		}
		System.out.println("Id : "+p.getId()+" Name : "+p.getName()+" Price : "+p.getPrice()+" QOH : "+p.getQoh());
	}
	
	public List<Product> findAll(){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		List<Product> ll = em.createQuery("select p from Product p ").getResultList();
		em.close();
		return ll;
	}
	
	public List<Product> findByPriceGreaterThan(float p){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		javax.persistence.Query q = em.createQuery("select p from Product p where p.price >= ?1");
		q.setParameter(1, p);
		List<Product> ll = q.getResultList();
		em.close();
		return ll;
	}
	
	public void removeOutOfStockProducts(){
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		javax.persistence.Query q = em.createQuery("delete  from Product p where p.qoh = ?1");
		q.setParameter(1, 0);
		q.executeUpdate();
		tx.commit();
		em.close();
	}

}
