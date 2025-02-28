package com.seed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.seed.dao.ProductRepository;
import com.seed.entity.Product;

@Controller
public class ProductController {

	@Autowired
	ProductRepository repo;
	
	@RequestMapping("/")
	public String entryPointMethod() {
		System.out.println("entrypoint method invoked...");
		return "homepage.jsp";
		
	}
	
	@RequestMapping("/getallproducts")
	public ModelAndView getAllProducts() {
		ModelAndView mav = new ModelAndView();
		List<Product> lst = repo.findAll();
		mav.addObject("prodList", lst);
		mav.setViewName("displayproducts.jsp");
		return mav; 
	}
}
