package com.spring.henallux.transAirPort.dataAccess.util;

import com.spring.henallux.transAirPort.dataAccess.entity.*;
import com.spring.henallux.transAirPort.model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {
    private Mapper mapper = new DozerBeanMapper();

    public AddressEntity addressModelToAddressEntity(Address address){
        return mapper.map(address, AddressEntity.class);
    }
    public Address addressEntityToAddressModel(AddressEntity addressEntity){
        return mapper.map(addressEntity, Address.class);
    }

    public CategoryEntity categoryModelToCategoryEntity(Category category){
        return mapper.map(category, CategoryEntity.class);
    }
    public Category categoryModelToCategoryEntity(CategoryEntity categoryEntity){
        return mapper.map(categoryEntity, Category.class);
    }

    public CategoryInfoEntity categoryInfoModelToCategoryInfoEntity(CategoryInfo categoryInfo){
        return mapper.map(categoryInfo, CategoryInfoEntity.class);
    }
    public CategoryInfo categoryInfoEntityToCategoryInfoModel(CategoryInfoEntity categoryInfoEntity){
        return mapper.map(categoryInfoEntity, CategoryInfo.class);
    }

    public LanguageEntity languageModelToLanguageEntity(Language language){
        return mapper.map(language, LanguageEntity.class);
    }
    public Language languageEntityToLanguageModel(LanguageEntity languageEntity){
        return mapper.map(languageEntity, Language.class);
    }

    public LocalityEntity localityModelToLocalityEntity(Locality locality){
        return mapper.map(locality, LocalityEntity.class);
    }
    public Locality localityEntityToLocalityModel(LocalityEntity localityEntity){
        return mapper.map(localityEntity, Locality.class);
    }

    public OrderEntity orderModelToOrderEntity(Order order){
        return mapper.map(order, OrderEntity.class);
    }
    public Order orderEntityToOrderModel(OrderEntity orderEntity){
        return mapper.map(orderEntity, Order.class);
    }

    public OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLine){
        return mapper.map(orderLine, OrderLineEntity.class);
    }
    public OrderLine orderLineEntityToOrderLineModel(OrderLineEntity orderLineEntity){
        return mapper.map(orderLineEntity, OrderLine.class);
    }

    public ProductEntity productModelToProductEntity(Product product){
        return mapper.map(product, ProductEntity.class);
    }
    public Product productEntityToProductModel(ProductEntity productEntity){
        return mapper.map(productEntity, Product.class);
    }

    public ProductInfoEntity productInfoModelToProductInfoEntity(ProductInfo productInfo){
        return mapper.map(productInfo, ProductInfoEntity.class);
    }
    public ProductInfo productInfoEntityToProductInfoModel(ProductInfoEntity productInfoEntity){
        return mapper.map(productInfoEntity, ProductInfo.class);
    }

    public UserEntity userModeltoUserEntity(User user){
        return mapper.map(user,UserEntity.class);
    }
    public User userEntitytoUserModel(UserEntity userEntity){
        return mapper.map(userEntity, User.class);
    }
}
