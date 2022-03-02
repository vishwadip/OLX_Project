package com.zensar.olx.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olx.bean.Category;
import com.zensar.olx.service.CategoryService;



@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/advertise/addCategory")
	public Category addCategory(@RequestBody Category category)
	{
		return this.categoryService.addCategory(category);
	}
	
	@GetMapping("/advertise/category")
	public java.util.List<Category> getAllCategories(){
		return this.categoryService.getAllCategories();
	}
	
	@GetMapping("/advertise/getCategory/{id}")
	public Category getCategory(@PathVariable(name="id") int id)
	{
		return this.categoryService.findCategory(id);
	}
	
	
}
