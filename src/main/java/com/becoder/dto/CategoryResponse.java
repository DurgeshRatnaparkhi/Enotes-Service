package com.becoder.dto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.becoder.entity.Category;

@Repository
public interface CategoryResponse extends JpaRepository<Category, Integer> {

    List<Category> findByIsActiveTrue();

    
    Optional<Category> findByIdAndIsDeletedFalse(Integer id);
}