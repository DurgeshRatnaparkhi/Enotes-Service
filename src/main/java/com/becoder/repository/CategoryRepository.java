package com.becoder.repository;
import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.becoder.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

	List<Category> findByIsActiveTrue();   //custom method

	Optional<Category> findByIdAndIsDeletedFalse(Integer id);
	
	List<Category> findByIsDeletedFalse();
	
	Boolean existsByName(String name);

  
}
