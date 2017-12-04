package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "PRODUCT")
public class ProductEntity {

    @Id
    @Column(name = "productid")
    private long id;

    @Column(name = "price")
    private double price;

    @Column(name = "VAT")
    private double vat;

    @JoinColumn(name = "codecategory", referencedColumnName = "codecategory")
    @ManyToOne
    private CategoryEntity category;

    @OneToMany(mappedBy = "product")
    private Collection<OrderLineEntity> orderLines;

    @OneToMany(mappedBy = "product")
    private Collection<ProductInfoEntity> productInfos;
}
