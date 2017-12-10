package com.spring.henallux.transAirPort.dataAccess.repository;

import com.spring.henallux.transAirPort.dataAccess.entity.LanguageEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.ProductEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.ProductInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfoEntity, Long> {
    ProductInfoEntity findByProductAndLanguage(ProductEntity product,LanguageEntity language);
}
