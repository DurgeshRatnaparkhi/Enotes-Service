package com.becoder.service.impl;

import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.becoder.dto.CategoryDto;
import com.becoder.dto.CategoryResponse;
import com.becoder.entity.Category;
import com.becoder.repository.CategoryRepository;
import com.becoder.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper Mapper;

    @Override
    public Boolean saveCategoryDto(CategoryDto categoryDto) {
    	
        try
        {
            Category category = Mapper.map(categoryDto, Category.class);

            category.setIsActive(true);
            category.setIsDeleted(false);
            category.setCreatedBy(1);
            category.setCreatedon(new Date());

            Category saved = categoryRepository.save(category);

            return saved != null && saved.getId() != null;

        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
            
            return false;
        }
    }

    @Override
    public List<CategoryDto> getAllcategory() {
    	
        List<Category> categories = categoryRepository.findAll();

       
        List<CategoryDto> categoryDtolist = categories.stream().map(cat -> Mapper.map(cat, CategoryDto.class)).toList();
        
		return categoryDtolist;
    }


	@Override
	public List<CategoryResponse> getIsActive() {
	
		
		 List<Category> categories = categoryRepository.findByIsActiveTrue();
		 
		 List<CategoryResponse> catrgorylist = categories.stream().map(cat-> Mapper.map(cat, CategoryResponse.class)).toList();
		
		return catrgorylist;
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


