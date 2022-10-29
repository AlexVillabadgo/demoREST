package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.OrderService;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping(value = "/clients/{clientid}/orders")
    public ResponseEntity<?> create (@RequestBody Order order,
                                     @PathVariable(name = "clientid") int clientid){
        order.setClientId(clientid);
        orderService.create(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients/{clientid}/orders")
    public ResponseEntity<List<Order>> read (@PathVariable(name = "clientid") int clientid){
        final List<Order> orders = orderService.readAll();
        return orders != null &&  !orders.isEmpty()
                ? new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @GetMapping(value = "/clients/{clientid}/orders/{orderid}")
    public ResponseEntity<Order> read (@PathVariable(name = "clientid") int clientid,
                                       @PathVariable(name = "orderid") int orderid){
        final Order order = orderService.read(orderid);
        return order != null
                ? new ResponseEntity<>(order, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/clients/orders/{orderid}")
    public ResponseEntity<?> update(@RequestBody Order order,
                                    @PathVariable(name = "orderid") int orderid){
        final boolean updated = orderService.update(order, orderid);
        return order != null
                ? new ResponseEntity<>(order, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/clients/orders/{orderid}")
    public ResponseEntity<?> delete(@PathVariable(name = "orderid") int orderid) {
        final boolean deleted = orderService.delete(orderid);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


}
