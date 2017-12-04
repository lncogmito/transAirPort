package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity(name = "LANGUAGE")
public class LanguageEntity {

    @Id
    @Column(name = "codelanguage")
    private long code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "language")
    private Collection<CategoryInfoEntity> categoryInfos;

    @OneToMany(mappedBy = "language")
    private Collection<ProductInfoEntity> productInfos;
}
