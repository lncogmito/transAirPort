package com.spring.henallux.transAirPort.dataAccess.dao;

import com.spring.henallux.transAirPort.dataAccess.entity.CategoryEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.ProductEntity;
import com.spring.henallux.transAirPort.dataAccess.repository.ProductRepository;
import com.spring.henallux.transAirPort.dataAccess.util.ProviderConverter;
import com.spring.henallux.transAirPort.model.Product;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductDAO {
    private static ProviderConverter providerConverter = new ProviderConverter();
    private ProductRepository productRepository;

    public ProductDAO(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductEntity> findEntityByCategory(CategoryEntity categoryEntity){
        return productRepository.findByCategory(categoryEntity);
    }
}
