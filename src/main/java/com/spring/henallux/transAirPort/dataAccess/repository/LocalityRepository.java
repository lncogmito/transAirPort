package com.spring.henallux.transAirPort.dataAccess.repository;

import com.spring.henallux.transAirPort.dataAccess.entity.LocalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityRepository extends JpaRepository<LocalityEntity, Long> {
}
