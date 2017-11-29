package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "PRODUCT")
public class ProductEntity {

    @Id
    @Column(name = "ProductId")
    private long id;

    @Column(name = "Price")
    private double price;

    @Column(name = "VAT")
    private double vat;

    @JoinColumn(name = "CodeCategory", referencedColumnName = "CodeCategory")
    @ManyToOne
    private CategoryEntity category;

    @OneToMany(mappedBy = "product")
    private Collection<OrderLineEntity> orderLines;

    @OneToMany(mappedBy = "product")
    private Collection<ProductInfoEntity> productInfos;
}
