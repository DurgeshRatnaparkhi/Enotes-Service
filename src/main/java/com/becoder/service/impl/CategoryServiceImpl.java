package com.becoder.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.becoder.entity.Category;
import com.becoder.repository.CategoryRepository;
import com.becoder.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	

//	@Override
//	public Boolean saveCategory(Category category) {
//		
		@Override
		public Boolean saveCategory(Category category) {

		    try {
		        category.setIsActive(true);
		        category.setIsDeleted(false);
		        category.setCreatedBy(1);
		        category.setCreatedon(new Date());

		        Category saved = categoryRepository.save(category);

		        return saved != null && saved.getId() != null;

		    } catch (Exception e) {
		        e.printStackTrace();
		        return false;
		    }
		}

//		category.setIsDeleted(false);
//		category.setCreatedBy(1);
//		category.setCreatedon(new Date());
//		
//		category.setIsActive(true);
//		category.setIsDeleted(false);
//		category.setCreatedBy(1);
//		category.setCreatedon(new Date());
//
//		Category savedCategory = categoryRepository.save(category);
//		
//		if(ObjectUtils.isEmpty(savedCategory)) {
//			
//			return false;
//			
//			
//		}
//		
//		return true;
//	}
//	

	@Override
	public List<Category> getAllcategory() {
		
		return categoryRepository.findAll();
	}
}
