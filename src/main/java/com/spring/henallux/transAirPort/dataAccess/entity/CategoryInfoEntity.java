package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;

@Entity(name = "CATEGORY_INFO")
public class CategoryInfoEntity {

    @Id
    @Column(name = "CategoryInfoId")
    private long id;

    @Column(name = "Name")
    private String name;

    @JoinColumn(name = "CodeCategory", referencedColumnName = "CodeCategory")
    @ManyToOne
    private CategoryEntity category;

    @JoinColumn(name = "CodeLanguage", referencedColumnName = "CodeLanguage")
    @ManyToOne
    private LanguageEntity language;
}
