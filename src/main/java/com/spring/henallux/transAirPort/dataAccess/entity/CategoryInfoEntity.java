package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;

@Entity(name = "CATEGORY_INFO")
public class CategoryInfoEntity {

    @Id
    @Column(name = "categoryinfoid")
    private long id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "codecategory", referencedColumnName = "codecategory")
    @ManyToOne
    private CategoryEntity category;

    @JoinColumn(name = "codelanguage", referencedColumnName = "codelanguage")
    @ManyToOne
    private LanguageEntity language;
}
