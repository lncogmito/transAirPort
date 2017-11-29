package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "LANGUAGE")
public class LanguageEntity {

    @Id
    @Column(name = "CodeLanguage")
    private long code;

    @Column(name = "Name")
    private String name;

    //TODO Collection de CategoryInfoEntity

    //TODO Collection de ProductInfoEntity
}
