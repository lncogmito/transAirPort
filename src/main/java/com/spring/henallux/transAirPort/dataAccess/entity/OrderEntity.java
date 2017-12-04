package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "ORDER")
public class OrderEntity {

    @Id
    @Column(name = "orderid")
    private long id;

    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private UserEntity user;

    @JoinColumn(name = "addressid", referencedColumnName = "addressid")
    @ManyToOne
    private AddressEntity deliveryAddress;

    @OneToMany(mappedBy = "order")
    private Collection<OrderLineEntity> orderLines;
}
