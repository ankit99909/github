package chinesefood.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sun.reflect.generics.repository.ClassRepository;



@Controller
public class CategoryController 
{
	@Autowired
	ClassRepository categoryRepository;
	@Autowired
	Category category;

	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public String categoryAdd(@ModelAttribute("cat") Category category)
	{
		if(category.getCategoryId()==0)
		{
		categoryRepository.addCategory(category);
		}
		else
		{
			categoryRepository.updateCategory(category);
		}
		
		return "redirect:/category";
	}
	
	
	@RequestMapping("/deleteCategory/{id}")
	
		public String categoryDelete(@PathVariable("id") int categoryId)
		{
			categoryRepository.deleteCategory(categoryId);
			return "redirect:/category";
	}
	
	
	@RequestMapping("/editCategory/{id}")
	
	public String categoryUpdate(@PathVariable("id") int categoryId,Model model)
	{
		Category categoryData=categoryRepository.getCategoryById(categoryId);
		model.addAttribute("cat",categoryData);
		List<com.niit.chinesefoodBankend.model.Category> allCategories= categoryRepository.getAllCategory();
		model.addAttribute("categoryList",allCategories);
		return "Category";
}
	
	
	
	
}
