package com.spring.henallux.transAirPort.dataAccess.repository;

import com.spring.henallux.transAirPort.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
