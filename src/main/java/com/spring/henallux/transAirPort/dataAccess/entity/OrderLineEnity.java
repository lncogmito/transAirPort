package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;

@Entity(name = "ORDER_LINE")
public class OrderLineEnity {

    @Id
    @Column(name = "OrderLineId")
    private long id;

    @Column(name = "Price")
    private double price;

    @Column(name = "Quantity")
    private int quantity;

    @JoinColumn(name = "OrderId", referencedColumnName = "OrderId")
    @ManyToOne
    private OrderEntity order;

    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne
    private ProductEntity product;
}
