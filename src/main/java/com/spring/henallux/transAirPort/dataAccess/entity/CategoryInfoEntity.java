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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}