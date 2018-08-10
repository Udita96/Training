package com.visa.training.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.training.domain.Product;
import com.visa.training.domain.User;

@Controller
public class ProductAdditionController {
	
	@RequestMapping(value="/addproduct",method=RequestMethod.GET)
	public String displayLoginForm(Map<String,Object> model){
		Product product = new Product();
		//user.setName("");
		//user.setPassword("");
		model.put("product", product);
		return "addproduct";
	}
	
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public String handleFormSubmission(@ModelAttribute("product")Product product){
		if(product.getPrice()>0){
			return "addproductsuccess";
		}
		else{
			return "addproductfailed";
		}
		//return null;
	}

}
