package kz.urbanl.urbanlogistics.service.impl;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.Order;
import kz.urbanl.urbanlogistics.model.User;
import kz.urbanl.urbanlogistics.repository.LocationRepo;
import kz.urbanl.urbanlogistics.repository.OrderRepo;
import kz.urbanl.urbanlogistics.repository.UserRepo;
import kz.urbanl.urbanlogistics.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private UserRepo userRepo;
    @Override
    public Order createOrder(Order order) throws InternalException {
        order.setUser(userRepo.findById(order.getUser().getId()).get());
        return orderRepo.saveAndFlush(order);
    }

    @Override
    public List<Order> getAllOrders() throws InternalException {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrderById(Long id) throws InternalException {
        return orderRepo.findById(id).get();
    }

    @Override
    public Order updateOrder(Order order) throws InternalException {
        Order updateOrder = orderRepo.findById(order.getId()).get();
        return orderRepo.saveAndFlush(updateOrder);
    }

    @Override
    public void deleteOrder(Order order) throws InternalException {
        orderRepo.delete(order);
    }
}
