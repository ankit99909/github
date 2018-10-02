package com.niit.chinesefoodBankend.dao;

import java.awt.List;
import java.util.Locale.Category;

public interface CategoryRepository {
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int categoryId);
	public List getAllCategory();
	public Category getCategoryById(int categoryId);
	
}
