package com.spring.henallux.transAirPort.dataAccess.dao;

import com.spring.henallux.transAirPort.dataAccess.entity.CategoryEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.LanguageEntity;
import com.spring.henallux.transAirPort.dataAccess.repository.CategoryInfoRepository;
import com.spring.henallux.transAirPort.dataAccess.util.ProviderConverter;
import com.spring.henallux.transAirPort.model.Category;
import com.spring.henallux.transAirPort.model.CategoryInfo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryInfoDAO {
    private static ProviderConverter providerConverter = new ProviderConverter();
    private CategoryInfoRepository categoryInfoRepository;
    private LanguageDAO languageDAO;
    private CategoryDAO categoryDAO;

    public CategoryInfoDAO(CategoryInfoRepository categoryInfoRepository,LanguageDAO languageDAO,CategoryDAO categoryDAO){
        this.categoryInfoRepository = categoryInfoRepository;
        this.languageDAO = languageDAO;
        this.categoryDAO = categoryDAO;
    }

    public CategoryInfo findModelByCategoryAndLanguage(CategoryEntity categoryEntity, LanguageEntity languageEntity){
        return providerConverter.categoryInfoEntityToCategoryInfoModel(categoryInfoRepository.findByCategoryAndLanguage(categoryEntity,languageEntity));
    }
    public CategoryInfo findModelByCategoryCodeAndLanguageName(long categoryCode, String languageName){
        CategoryEntity categoryEntity = categoryDAO.findEntityByCode(categoryCode);
        LanguageEntity languageEntity = languageDAO.findEntityByName(languageName);
        return providerConverter.categoryInfoEntityToCategoryInfoModel(categoryInfoRepository.findByCategoryAndLanguage(categoryEntity,languageEntity));
    }

    public ArrayList<CategoryInfo> findModelListByCodeCategoryParentIsNull(String languageName){
        ArrayList<CategoryInfo> categories = new ArrayList<CategoryInfo>();
        List<CategoryEntity> categoryEntities = categoryDAO.findEntityByCategoryParentIsNull();
        LanguageEntity languageEntity = languageDAO.findEntityByName(languageName);
        for(CategoryEntity categoryEntity:categoryEntities){
            categories.add(findModelByCategoryAndLanguage(categoryEntity,languageEntity));
        }
        return categories;
    }
    public ArrayList<CategoryInfo> findModelChildListByCategoryCodeAndLanguageName(long categoryCode, String languageName){
        ArrayList<CategoryInfo> childCategories = new ArrayList<>();
        CategoryEntity categoryEntity = categoryDAO.findEntityByCode(categoryCode);
        for(CategoryEntity childCategory:categoryEntity.getChildCategories()){
            childCategories.add(findModelByCategoryCodeAndLanguageName(childCategory.getCode(),languageName));
        }
        return childCategories;
    }

    public ArrayList<CategoryInfo> findModelMotherList(String languageName){
        ArrayList<CategoryInfo> categoryInfoMotherList = new ArrayList<>();
        List<CategoryEntity> motherCategoriesEntities = categoryDAO.findEntityByCategoryParentIsNull();
        for(CategoryEntity categoryEntity:motherCategoriesEntities){
            categoryInfoMotherList.add(findModelByCategoryCodeAndLanguageName(categoryEntity.getCode(),languageName));
        }
        return categoryInfoMotherList;
    }

    /*public ArrayList<CategoryInfo> findModelCompleteChildListByCategoryCodeAndLanguageName(long categoryCode, String languageName){
        ArrayList<CategoryInfo> completeChildCategories = new ArrayList<>();

        ArrayList<CategoryInfo> childCategories = findModelChildListByCategoryCodeAndLanguageName(categoryCode, languageName);
        for(CategoryInfo categoryInfo:childCategories){
            completeChildCategories.add(categoryInfo);

        }

    }*/

}
