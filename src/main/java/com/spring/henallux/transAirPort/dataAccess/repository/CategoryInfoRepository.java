package com.spring.henallux.transAirPort.dataAccess.repository;

import com.spring.henallux.transAirPort.dataAccess.entity.CategoryEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.CategoryInfoEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CategoryInfoRepository extends JpaRepository<CategoryInfoEntity, Long> {
    CategoryInfoEntity findByCategoryAndLanguage(CategoryEntity category, LanguageEntity language);
}