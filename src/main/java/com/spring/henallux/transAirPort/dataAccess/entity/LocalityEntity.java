package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "LOCALITY")
public class LocalityEntity {

    @Id
    @Column(name = "localityid")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "postalcode")
    private int postalCode;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "locality", fetch = FetchType.LAZY)
    private Collection<AddressEntity> addressEntities;
}
