package com.spring.henallux.transAirPort.dataAccess.dao;

import com.spring.henallux.transAirPort.dataAccess.entity.CategoryEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.LanguageEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.ProductEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.ProductInfoEntity;
import com.spring.henallux.transAirPort.dataAccess.repository.ProductInfoRepository;
import com.spring.henallux.transAirPort.dataAccess.util.ProviderConverter;
import com.spring.henallux.transAirPort.model.Product;
import com.spring.henallux.transAirPort.model.ProductInfo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductInfoDAO {
    private static ProviderConverter providerConverter = new ProviderConverter();
    private ProductInfoRepository productInfoRepository;
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    private LanguageDAO languageDAO;

    public ProductInfoDAO(ProductInfoRepository productInfoRepository,ProductDAO productDAO,CategoryDAO categoryDAO,LanguageDAO languageDAO){
        this.productInfoRepository = productInfoRepository;
        this.productDAO = productDAO;
        this.categoryDAO = categoryDAO;
        this.languageDAO = languageDAO;
    }

    public ProductInfo findModelByProductIdAndLanguageName(long productId,String languageName){
        ProductEntity productEntity = productDAO.findEntityById(productId);
        LanguageEntity languageEntity = languageDAO.findEntityByName(languageName);

        return findModelByProductAndLanguage(productEntity,languageEntity);
    }


    public ProductInfo findModelByProductAndLanguage(ProductEntity productEntity, LanguageEntity languageEntity){
        ProductInfoEntity productInfoEntity = productInfoRepository.findByProductAndLanguage(productEntity,languageEntity);
        return providerConverter.productInfoEntityToProductInfoModel(productInfoEntity);
    }

    public ArrayList<ProductInfo> findModelListByCategoryAndLanguage(long codeCategory, String languageName){
        ArrayList<ProductInfo> products = new ArrayList<>();
        CategoryEntity categoryEntity = categoryDAO.findEntityByCode(codeCategory);
        LanguageEntity languageEntity = languageDAO.findEntityByName(languageName);
        List<ProductEntity> productEntities = productDAO.findEntityByCategory(categoryEntity);
        for(ProductEntity productEntity:productEntities){
            products.add(findModelByProductAndLanguage(productEntity,languageEntity));
        }
        return products;
    }


}
