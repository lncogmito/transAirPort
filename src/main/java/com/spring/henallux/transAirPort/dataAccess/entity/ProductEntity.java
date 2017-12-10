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

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getVat() {
        return vat;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public Collection<OrderLineEntity> getOrderLines() {
        return orderLines;
    }

    public Collection<ProductInfoEntity> getProductInfos() {
        return productInfos;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public void setOrderLines(Collection<OrderLineEntity> orderLines) {
        this.orderLines = orderLines;
    }

    public void setProductInfos(Collection<ProductInfoEntity> productInfos) {
        this.productInfos = productInfos;
    }
}
