package kz.urbanl.urbanlogistics.service.impl;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.Order;
import kz.urbanl.urbanlogistics.model.User;
import kz.urbanl.urbanlogistics.repository.*;
import kz.urbanl.urbanlogistics.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CompanyRepo companyRepo;
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
        updateOrder.setArrivalPlace(order.getArrivalPlace());
        updateOrder.setDestinationPlace(order.getDestinationPlace());
//        updateOrder.setMover(moverRepo.findById(order.getMover().getId()).get());
        updateOrder.setStatus(order.getStatus());
        updateOrder.setRating(order.getRating());
        updateOrder.setEndDate(order.getEndDate());
//        updateOrder.setPhotos(order.getPhotos());
        return orderRepo.saveAndFlush(updateOrder);
    }

    @Override
    public void deleteOrder(Order order) throws InternalException {
        Order deletedOrder = orderRepo.findById(order.getId()).get();
        orderRepo.delete(deletedOrder);
    }

    @Override
    public List<Order> getAllOrdersByCompany(Long id) {
        return orderRepo.findAllByCompany(companyRepo.findById(id).get());
    }
}
