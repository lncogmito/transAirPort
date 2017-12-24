package com.spring.henallux.transAirPort.dataAccess.repository;

import com.spring.henallux.transAirPort.dataAccess.entity.LocalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LocalityRepository extends JpaRepository<LocalityEntity, Long> {
    public LocalityEntity findOneByNameAndPostalCode(String name, Integer postalCode);
}
