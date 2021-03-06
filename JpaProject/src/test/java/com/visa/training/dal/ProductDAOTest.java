package com.visa.training.dal;

import static org.junit.Assert.*;

import org.junit.Test;

import com.visa.training.domain.Product;

public class ProductDAOTest {

	@Test
	public void addNewInsertsARowAndReturnsProductWithId() {
		ProductDAO dao = new ProductDAO();
		Product p = new Product("iPhoneX",99999,100);
		dao.addNew(p);
		System.out.println("Added Product : "+p);
		assertTrue(p.getId()>0);
		Product fromDB = dao.findOne(p.getId());
		System.out.println("From DB : "+fromDB);
		assertNotNull(fromDB);
	}

}
