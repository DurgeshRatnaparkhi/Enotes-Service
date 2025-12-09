package com.becoder.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.becoder.dto.CategoryDto;
import com.becoder.dto.CategoryResponse;
import com.becoder.entity.Category;
import com.becoder.exception.ResourceNotFoundexception;
import com.becoder.repository.CategoryRepository;
import com.becoder.service.CategoryService;
import com.becoder.validation.UtilValidation;

import jakarta.validation.Validation;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper Mapper;
    
    @Autowired
    private UtilValidation validation;
    

    @Override
    public Boolean saveCategoryDto(CategoryDto categoryDto) {
    	
    	//validation checking
    	
    	validation.categoryValidation(categoryDto);
    	
    	
    	
    	Category category = Mapper.map(categoryDto, Category.class);
    	

    	if(ObjectUtils.isEmpty(category.getId())) {
    		
    		category.setIsDeleted(false);
    		category.setCreatedBy(1);
    		category.setCreatedon(new Date());
    		
    		
    		
    	}else{
    		
    		updatecategory(category);
			
		}
    	
    	Category savecategory = categoryRepository.save(category);
    	

//    	if(ObjectUtils.isEmpty(savecategory)) {
//    		
//    		return false;
//    		
//    	}
    		
    	return savecategory != null;
    	
    }    	

     private void updatecategory(Category category) {
		
    	 Optional<Category>findByid= categoryRepository.findById(category.getId());
    	 
    	 if(findByid.isPresent()) {
    		 
    		 Category category2 = findByid.get();
    		 category.setCreatedBy(category2.getCreatedBy());
    		 category.setCreatedon(category2.getCreatedon());
    		 category.setIsDeleted(category2.getIsDeleted());
    		 
    		 category.setUpdatedBy(1);
    		 category.setUpdatedon(new Date());
    	 }
		
	}



    @Override
    public List<CategoryDto> getAllcategory() {
    
        List<Category> categories = categoryRepository.findByIsDeletedFalse();

       
        List<CategoryDto> categoryDtolist = categories.stream().map(cat -> Mapper.map(cat, CategoryDto.class)).toList();
        
		return categoryDtolist;
    }
    
    

	@Override
	public List<CategoryResponse> getIsActive() {
	
		
		 List<Category> categories = categoryRepository.findByIsActiveTrue();
		 
		 List<CategoryResponse> list = categories.stream().map(cat-> Mapper.map(cat, CategoryResponse.class)).toList();
		
		return list;
	}
	
	

	@Override
	public CategoryDto getCategoryDtoById(Integer id) throws Exception {
		
		Category category = categoryRepository.findByIdAndIsDeletedFalse(id)
				.orElseThrow(()->new ResourceNotFoundexception("Category not found with id=" + id));

		if (!ObjectUtils.isEmpty(category)) {
			
			category.getName().toUpperCase();
			
			return Mapper.map(category,CategoryDto.class);
		}
			
		return null;
	}

	
	
	@Override
	public Boolean deleteCategoryById(Integer id) {
		
	    if(categoryRepository.existsById(id)) {
	    	
	        categoryRepository.deleteById(id);  // ✔ permanently deletes
	        
	        return true;
	    }
	    return false;
	}

}





