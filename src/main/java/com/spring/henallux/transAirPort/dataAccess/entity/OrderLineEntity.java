package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;

@Entity(name = "ORDER_LINE")
public class OrderLineEntity {

    @Id
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
}
