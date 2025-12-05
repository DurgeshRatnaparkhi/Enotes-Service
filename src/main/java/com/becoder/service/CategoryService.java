package com.becoder.service;

	import java.util.List;
	import com.becoder.dto.CategoryDto;
    import com.becoder.dto.CategoryResponse;



	public interface CategoryService {

	  public   Boolean saveCategoryDto(CategoryDto categoryDto);

	   public  List<CategoryDto> getAllcategory();

	   public List<CategoryResponse>getIsActive();
	


	}



