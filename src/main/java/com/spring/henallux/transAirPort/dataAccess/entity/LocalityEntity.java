package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "LOCALITY")
public class LocalityEntity {

    @Id
    @Column(name = "LocalityId")
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "PostalCode")
    private int postalCode;

    @OneToMany(mappedBy = "locality", fetch = FetchType.LAZY)
    private Collection<AddressEntity> addressEntities;
}
