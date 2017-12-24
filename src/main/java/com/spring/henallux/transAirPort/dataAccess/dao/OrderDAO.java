package com.spring.henallux.transAirPort.dataAccess.dao;

import com.spring.henallux.transAirPort.dataAccess.entity.OrderEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.transAirPort.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.transAirPort.dataAccess.repository.OrderRepository;
import org.hibernate.Session;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;

@Service
@Transactional
public class OrderDAO {
    private OrderRepository orderRepository;
    private OrderLineRepository orderLineRepository;

    public OrderDAO(OrderRepository orderRepository, OrderLineRepository orderLineRepository){
        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
    }

    public boolean saveOrder(OrderEntity orderEntity){
        if(orderRepository.save(orderEntity) != null)
            return true;
        else
            return false;
    }
    public boolean saveOrderLine(OrderLineEntity orderLineEntity){
        if(orderLineRepository.save(orderLineEntity) != null)
            return true;
        else
            return false;
    }
}
