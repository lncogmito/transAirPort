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
}
