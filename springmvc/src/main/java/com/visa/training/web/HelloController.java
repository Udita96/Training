package com.visa.training.web;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)	
	public ModelAndView handleHello(){
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("todaysDate",new Date());
		data.put("greeting", "Welcome to SpringMVC");
		String viewName = "helloview";
		return new ModelAndView(viewName,data);
	}

}
