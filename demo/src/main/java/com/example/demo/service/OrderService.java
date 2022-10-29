package com.example.demo.service;

import com.example.demo.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    void create(Order order);

    List<Order>  readAll();

    Order read(int id);
    boolean update(Order order, Integer id);

    boolean delete(Integer id);
}
