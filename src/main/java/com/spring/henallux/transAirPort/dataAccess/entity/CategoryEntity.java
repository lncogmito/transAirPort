package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "CATEGORY")
public class CategoryEntity {

    @Id
    @Column(name = "CodeCategory")
    private long code;

    @JoinColumn(name = "CodeCategoryParent", referencedColumnName = "CodeCategory")
    @ManyToOne
    private CategoryEntity categoryParent;

    @OneToMany(mappedBy = "categoryParent", fetch = FetchType.LAZY)
    private Collection<CategoryEntity> childCategories;

    //TODO Collection de ProductEntity

    //TODO Collection de CategoryInfoEntity
}
