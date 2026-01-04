package com.becoder.controller;
import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
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
import com.becoder.service.CategoryService;

import com.becoder.util.CommonUtil;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
	
	
	private static final String categoryDto = null;
	@Autowired
	private CategoryService categoryService;
	private @Nullable Collection<? extends @Nullable Object> allCategory;
	
	
	@PostMapping("/ram")
	public ResponseEntity<?> insertCategory(@RequestBody CategoryDto categoryDto){
		
		Boolean saved = categoryService.saveCategoryDto(categoryDto);
		

		if (saved) {
			//return new ResponseEntity<>("saved success", HttpStatus.CREATED);
			return CommonUtil.createBuildResponseMessage("saved success", HttpStatus.CREATED);
//			return new ResponseEntity<>("saved success", HttpStatus.CREATED);
		} else {
			//return new ResponseEntity<>("not saved", HttpStatus.INTERNAL_SERVER_ERROR);
			return CommonUtil.createErrorResponseMessage("Category Not saved", HttpStatus.INTERNAL_SERVER_ERROR);
//			return new ResponseEntity<>("not saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/api")
	
	public ResponseEntity<?> getAllCategory() {

		List<CategoryDto> allCategory = categoryService.getAllCategory();
		
		if (CollectionUtils.isEmpty(allCategory)) 
		{
			return ResponseEntity.noContent().build();
			
		} 
		
		else
		{
			//return new ResponseEntity<>(allCategory, HttpStatus.OK);
			return CommonUtil.createBuildResponse(allCategory, HttpStatus.OK);
//			return new ResponseEntity<>(allCategory, HttpStatus.OK);
		}

	}
	
	@GetMapping("/active")
	public ResponseEntity<?> getIsActive(){		

	if (CollectionUtils.isEmpty(allCategory)) {
		return ResponseEntity.noContent().build();
	}
	else {
		//return new ResponseEntity<>(allCategory, HttpStatus.OK);
		return CommonUtil.createBuildResponse(allCategory, HttpStatus.OK);
//		return new ResponseEntity<>(allCategory, HttpStatus.OK);
	}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getCategoryDetailsById(@PathVariable Integer id) throws Exception{
		
		CategoryDto categoryDto = categoryService.getCategoryDtoById(id);
		if (ObjectUtils.isEmpty(categoryDto)) {
			//return new ResponseEntity<>("Internal Server Error", HttpStatus.NOT_FOUND);
			return CommonUtil.createErrorResponseMessage("Internal Server Error", HttpStatus.NOT_FOUND);
//			return new ResponseEntity<>("Internal Server Error", HttpStatus.NOT_FOUND);
		}
		//return new ResponseEntity<>(categoryDto, HttpStatus.OK);

		return CommonUtil.createBuildResponse(categoryDto, HttpStatus.OK);
//		return new ResponseEntity<>(categoryDto, HttpStatus.OK);
	}
	

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable Integer id) {
		Boolean deleted = categoryService.deleteCategoryById(id);
		if (deleted) {
			//return new ResponseEntity<>("Category deleted success", HttpStatus.OK);
			return CommonUtil.createBuildResponse("Category deleted success", HttpStatus.OK);
//			return new ResponseEntity<>("Category deleted success", HttpStatus.OK);
		}
		//return new ResponseEntity<>("Category Not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
		return CommonUtil.createErrorResponseMessage("Category Not deleted", HttpStatus.INTERNAL_SERVER_ERROR);

//		return new ResponseEntity<>("Category Not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
