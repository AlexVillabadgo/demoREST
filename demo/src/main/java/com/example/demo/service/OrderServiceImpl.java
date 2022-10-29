package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;


    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void create(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> readAll() {
        return orderRepository.findAll();
    }
    @Override
    public Order read(int id) {
        return (Order) orderRepository.findById(id).get();
    }

    @Override
    public boolean update(Order order, Integer id) {
        if(orderRepository.existsById(id)){
            order.setId(id);
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
        }
        return false;
    }
}
