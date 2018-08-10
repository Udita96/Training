package com.visa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.visa.training.dal.MySqlProductDAO;
import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

@Component("service")
public class ProductService {
	ProductDAO dao;// = new MySqlProductDAO();
	
@Autowired
	public void setDao(ProductDAO dao) {		//setter based dependency injection
		this.dao = dao;
		System.out.println("[From within service. Got object of DAO]");
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public void changePrice(int id, float newPrice) {
		dao.changePrice(id, newPrice);
	}

	public Product findOne(int id) {
		return dao.findOne(id);
	}

	public Product addNew(Product p) {
		if(p.getPrice()*p.getQoh()>=10000){
			return dao.addNew(p);
		}
		else{
			throw new InsufficientValueException("The value (price*qty) must at least be 10000");
		}
	}

	public List<Product> findAll() {
		return dao.findAll();
	}
	

}
