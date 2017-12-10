package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;

@Entity(name = "PRODUCT_INFO")
public class ProductInfoEntity {

    @Id
    @Column(name = "productinfoid")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "productid", referencedColumnName = "productid")
    @ManyToOne
    private ProductEntity product;

    @JoinColumn(name = "codelanguage", referencedColumnName = "codelanguage")
    @ManyToOne
    private LanguageEntity language;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}
