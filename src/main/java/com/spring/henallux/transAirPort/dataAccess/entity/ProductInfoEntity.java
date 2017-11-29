package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;

@Entity(name = "PRODUCT_INFO")
public class ProductInfoEntity {

    @Id
    @Column(name = "ProductInfoId")
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne
    private ProductEntity product;

    @JoinColumn(name = "CodeLanguage", referencedColumnName = "CodeLanguage")
    @ManyToOne
    private LanguageEntity language;
}
