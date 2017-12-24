package com.spring.henallux.transAirPort.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(String boxNumber) {
        this.boxNumber = boxNumber;
    }

    public LocalityEntity getLocality() {
        return locality;
    }

    public void setLocality(LocalityEntity locality) {
        this.locality = locality;
    }

    public Collection<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserEntity> users) {
        this.users = users;
    }

    public Collection<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Collection<OrderEntity> orders) {
        this.orders = orders;
    }
}
