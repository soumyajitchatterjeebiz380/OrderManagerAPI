package com.example.Orders.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Orders.Entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    
}
