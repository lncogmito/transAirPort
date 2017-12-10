package com.spring.henallux.transAirPort.dataAccess.dao;

import com.spring.henallux.transAirPort.dataAccess.entity.CategoryEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.LanguageEntity;
import com.spring.henallux.transAirPort.dataAccess.repository.CategoryInfoRepository;
import com.spring.henallux.transAirPort.dataAccess.repository.CategoryRepository;
import com.spring.henallux.transAirPort.dataAccess.repository.LanguageRepository;
import com.spring.henallux.transAirPort.dataAccess.util.ProviderConverter;
import com.spring.henallux.transAirPort.model.Category;
import com.spring.henallux.transAirPort.model.CategoryInfo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryDAO {

    private static ProviderConverter providerConverter = new ProviderConverter();
    private CategoryRepository categoryRepository;


    public CategoryDAO(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> findEntityByCategoryParentIsNull(){
        return categoryRepository.findByCategoryParentIsNull();
    }

    public Category findModelByCode(long code){
        return providerConverter.categoryEntityToCategoryModel(categoryRepository.findByCode(code));
    }
    public CategoryEntity findEntityByCode(long code){
        return categoryRepository.findByCode(code);
    }
}
