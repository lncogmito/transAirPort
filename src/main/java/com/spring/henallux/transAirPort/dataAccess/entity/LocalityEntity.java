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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Collection<AddressEntity> getAddressEntities() {
        return addressEntities;
    }

    public void setAddressEntities(Collection<AddressEntity> addressEntities) {
        this.addressEntities = addressEntities;
    }
}
