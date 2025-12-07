package com.becoder.controller;
//import org.springframework.util.ObjectUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.ObjectUtils;
import com.becoder.dto.CategoryDto;
import com.becoder.dto.CategoryResponse;
import com.becoder.service.CategoryService;
@RestController
@RequestMapping("/category")
public class CategoryController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/ram")
	public ResponseEntity<?> insertCategory(@RequestBody CategoryDto categoryDto){
		
		Boolean saved = categoryService.saveCategoryDto(categoryDto);
		
		if(saved)
		{
			return new ResponseEntity<>("Saved successfully", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("Not saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/api")
	public ResponseEntity<?> getAllCategory(){
		
		List<CategoryDto> allCategories = categoryService.getAllcategory();
		 
		if(CollectionUtils.isEmpty(allCategories)) {
			
			return ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity<>(allCategories, HttpStatus.OK);
	}
	
	
	@GetMapping("/active")
	public ResponseEntity<?> getIsActive(){
		
		List<CategoryResponse> allCategories = categoryService.getIsActive();
		 
		if(CollectionUtils.isEmpty(allCategories)) {
			
			return ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity<>(allCategories, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getCategoryDetailsById(@PathVariable Integer id){
		
		CategoryDto categoryById = categoryService.getCategoryDtoById(id);
		
		if (ObjectUtils.isEmpty(categoryById)) {
			
			 return new ResponseEntity<>("Category not found with id=" + id,HttpStatus.NOT_FOUND);
		 }      
		return new ResponseEntity<>(categoryById,HttpStatus.OK);
	}
	

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteCategoryById(@PathVariable Integer id){
		
		Boolean deleteCategory = categoryService.deleteCategoryById(id);
		
		if(deleteCategory) {
			
			return new ResponseEntity<>("category deleted success", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("category not deleted",HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
}
