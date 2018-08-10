package com.visa.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.Product;
//import com.visa.training.util.JpaUtil;

@Component("mydao")
@Transactional	//as if annotating all the methods of the class with @Transactional
public class MySqlProductDAO implements ProductDAO {
	
	@Autowired
	EntityManager em;		//field-based Dependency Injection
	
	@Override
	public void delete(int id){
		//EntityTransaction tx = em.getTransaction();
		Product p = em.find(Product.class,id); //the object pointed by 'p' is in persistent state until the transaction has been committed. The tx.begin is assumed to be before the first line of the method and tx.commit is assumed to be after the last line of the method
		//tx.begin();
		em.remove(p);
		//tx.commit();
		
	}
	
	@Override
	public void changePrice(int id,float newPrice){
		
		//EntityTransaction tx = em.getTransaction();
		Product p = em.find(Product.class,id);
		//tx.begin();
		p.setPrice(newPrice);
		//tx.commit();
		
		
	}
	
	@Override
	public Product findOne(int id){
		
		Product p = em.find(Product.class, id);	//p is in persistent state	//treat .class as syntax for this. '.class' is literal form of Class.
		display(p);
		
		System.out.println(p);
		return p;
	}
	
	@Override
	public Product addNew(Product p){		//p in transient state
		
		//EntityTransaction tx = em.getTransaction();
		//tx.begin();
		
		em.persist(p);		//p in persistent state
		
		//tx.commit();
				//p is in detach state
		return p;			//the method returns an object in detached state
		
	}
	
	public void display(Product p){
		if(p==null){
			System.out.println("Empty Product Object");
			return;
		}
		System.out.println("Id : "+p.getId()+" Name : "+p.getName()+" Price : "+p.getPrice()+" QOH : "+p.getQoh());
	}
	
	@Override
	public List<Product> findAll(){
		
		List<Product> ll = em.createQuery("select p from Product p ").getResultList();
		
		return ll;
	}
	
	public List<Product> findByPriceGreaterThan(float p){
		
		javax.persistence.Query q = em.createQuery("select p from Product p where p.price >= ?1");
		q.setParameter(1, p);
		List<Product> ll = q.getResultList();
		
		return ll;
	}
	
	public void removeOutOfStockProducts(){
		//EntityManager em = JpaUtil.getEmf().createEntityManager();
		//EntityTransaction tx = em.getTransaction();
		//tx.begin();
		javax.persistence.Query q = em.createQuery("delete  from Product p where p.qoh = ?1");
		q.setParameter(1, 0);
		q.executeUpdate();
		//tx.commit();
		//em.close();
	}

}
