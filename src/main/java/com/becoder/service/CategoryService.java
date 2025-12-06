package com.becoder.service;

	import java.util.List;
	import com.becoder.dto.CategoryDto;
    import com.becoder.dto.CategoryResponse;

	public interface CategoryService {

	 
	  public Boolean saveCategoryDto(CategoryDto categoryDto); //save Category
		
	   public  List<CategoryDto> getAllcategory();   //getAll Category

	   public List<CategoryResponse>getIsActive();     //IsActive id,name,description show

	   public CategoryDto getCategoryDtoById(Integer id);   //get Category Id
	  
	   public  Boolean deleteCategoryById(Integer id);        //delete category


	}



