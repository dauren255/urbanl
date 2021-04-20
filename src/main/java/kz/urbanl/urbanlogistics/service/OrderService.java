package kz.urbanl.urbanlogistics.service;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order) throws InternalException;

    List<Order> getAllOrders() throws InternalException;

    Order getOrderById(Long id) throws InternalException;

    Order updateOrder(Order order) throws InternalException;

    void deleteOrder(Order order) throws InternalException;
}
