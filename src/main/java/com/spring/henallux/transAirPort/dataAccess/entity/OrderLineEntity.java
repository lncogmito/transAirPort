package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;

@Entity(name = "ORDER_LINE")
public class OrderLineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderlineid")
    private long id;

    @Column(name = "linenumber")
    private int lineNumber;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    @JoinColumn(name = "orderid", referencedColumnName = "orderid")
    @ManyToOne
    private OrderEntity order;

    @JoinColumn(name = "productid", referencedColumnName = "productid")
    @ManyToOne
    private ProductEntity product;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
