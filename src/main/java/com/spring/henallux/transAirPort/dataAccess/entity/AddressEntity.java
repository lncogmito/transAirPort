package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id
    @Column(name = "addressid")
    private long id;

    @Column(name = "street")
    private String street;

    @Column(name = "housenumber")
    private String houseNumber;

    @Column(name = "boxnumber")
    private String boxNumber;

    @JoinColumn(name = "localityid", referencedColumnName = "localityid")
    @ManyToOne
    private LocalityEntity locality;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Collection<UserEntity> users;

    @OneToMany(mappedBy = "deliveryAddress", fetch = FetchType.LAZY)
    private Collection<OrderEntity> orders;
}
