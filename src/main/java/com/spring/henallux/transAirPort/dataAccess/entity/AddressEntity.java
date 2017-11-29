package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "ADDRESS")
public class AddressEntity {

    @Id
    @Column(name = "AddressId")
    private long id;

    @Column(name = "Street")
    private String street;

    @Column(name = "HouseNumber")
    private String houseNumber;

    @Column(name = "BoxNumber")
    private String boxNumber;

    @JoinColumn(name = "LocalityId", referencedColumnName = "LocalityId")
    @ManyToOne
    private LocalityEntity locality;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Collection<UserEntity> users;

    @OneToMany(mappedBy = "deliveryAddress", fetch = FetchType.LAZY)
    private Collection<OrderEntity> orders;
}
