package com.spring.henallux.transAirPort.dataAccess.repository;

import com.spring.henallux.transAirPort.dataAccess.entity.CategoryEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.ProductEntity;
import com.spring.henallux.transAirPort.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByCategory(CategoryEntity category);
}
