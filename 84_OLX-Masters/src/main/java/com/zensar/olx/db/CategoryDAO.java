package com.zensar.olx.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olx.bean.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer>{
	

}
