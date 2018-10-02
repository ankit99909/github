package com.niit.shoestylefrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoestyle.dao.CategoryRepository;
import com.niit.shoestyle.dao.ProductRepository;
import com.niit.shoestyle.model.Category;
import com.niit.shoestyle.model.Product;

@Controller

public class ProductController 
{

	@Autowired
	ProductRepository productRepository;
	@Autowired
	Product product;
	@Autowired
	CategoryRepository categoryRepository;

	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String productAdd(@ModelAttribute("productOBJ") Product product)
	{
		if(product.getProductId()==0)
		{
			productRepository.addProduct(product);
		}
		else
		{
			productRepository.updateProduct(product);
		}
		
		return "redirect:/product";
	}
	
	
	@RequestMapping("/deleteProduct/{id}")
	
		public String productDelete(@PathVariable("id") int productId)
		{
		productRepository.deleteProduct(productId);
			return "redirect:/product";
	}
	
	
	@RequestMapping("/editProduct/{id}")
	
	public String productUpdate(@PathVariable("id") int productId,Model model)
	{
		Product productData=productRepository.getProductById(productId);
		model.addAttribute("productOBJ",productData);
		List<Category> allCategories= categoryRepository.getAllCategory();
		model.addAttribute("categoryList",allCategories);
		List<Product> allProducts= productRepository.getAllProduct();
		model.addAttribute("productList",allProducts);
		return "Product";
}

	
}
