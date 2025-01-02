package com.yt.graphql.services;

import com.yt.graphql.entities.Order;
import com.yt.graphql.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }

    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order getOrder(int orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(()-> new RuntimeException("Resource Not Found"));
        return order;
    }

    public boolean deleteOrder(int orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(()-> new RuntimeException("Resource Not Found"));
        orderRepo.delete(order);
        return true;
    }
}
