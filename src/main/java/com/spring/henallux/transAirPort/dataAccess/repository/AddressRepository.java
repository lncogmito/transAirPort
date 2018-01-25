package com.spring.henallux.transAirPort.dataAccess.repository;

import com.spring.henallux.transAirPort.dataAccess.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    public AddressEntity findOneByStreetAndHouseNumber(String street, String houseNumber);
    public AddressEntity findOneByStreetAndHouseNumberAndBoxNumber(String street, String houseNumber, String boxNumber);
}
