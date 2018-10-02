package com.niit.chinesefoodBankend.dao;

import java.util.List;

public interface ProductRepository<Product> {
	
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int productId);
	public List<Product> getAllProduct();
	public Product getProductById(int productId);

}
