package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;

@Entity(name = "ORDER")
public class OrderEntity {

    @Id
    @Column(name = "OrderId")
    private long id;

    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne
    private UserEntity user;

    @JoinColumn(name = "AddressId", referencedColumnName = "AddressId")
    @ManyToOne
    private AddressEntity deliveryAddress;

    //TODO: Collection de OrderLineEntity
}
