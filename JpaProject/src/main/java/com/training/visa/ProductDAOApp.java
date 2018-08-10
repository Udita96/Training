package com.training.visa;

import java.util.List;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

public class ProductDAOApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p = new Product("Oppo",5000.98f,0);
		ProductDAO pd = new ProductDAO();
		Product ans = pd.addNew(p);
		//pd.display(ans);
		/*ans = pd.findOne(8);
		pd.display(ans);
		pd.delete(8);
		ans = pd.findOne(8);
		pd.display(ans);*/
		List<Product> pro = pd.findAll();
		System.out.println("Finding All Products : ");
		pro.forEach(System.out::println);
		System.out.println("Price greater than 500 : ");
		pro = pd.findByPriceGreaterThan(5000);
		pro.forEach(System.out::println);
		pd.removeOutOfStockProducts();
		pd.findAll();
		

	}

}
