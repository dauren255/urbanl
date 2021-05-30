package kz.urbanl.urbanlogistics.service.impl;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.Order;
import kz.urbanl.urbanlogistics.model.Status;
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
    private MoverRepo moverRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public Order createOrder(Order order) throws InternalException {
        order.setUser(userRepo.findById(order.getUser().getId()).get());
        return orderRepo.saveAndFlush(order);
    }

    @Override
    public List<Order> getAllOrders() throws InternalException {
        return orderRepo.findAllByStatus(Status.ACTIVE);
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
    public List<Order> getAllOrdersByCompany(String username) {
        User user = userRepo.findByUsernameIgnoreCase(username);
        return orderRepo.findAllByCompanyAndStatus(user.getCompany(), Status.IN_WORK);
    }

    @Override
    public List<Order> getAllOrdersByCompanyInactive(String username) {
        User user = userRepo.findByUsernameIgnoreCase(username);
        return orderRepo.findAllByCompanyAndStatus(user.getCompany(), Status.INACTIVE);
    }

    @Override
    public Order setWorked(Long id, String username, Long moverId) {
        Order order = orderRepo.findById(id).get();
        order.setCompany(userRepo.findByUsernameIgnoreCase(username).getCompany());
        order.setMover(moverRepo.findById(moverId).get());
        order.setStatus(Status.IN_WORK);
        return orderRepo.saveAndFlush(order);
    }

    @Override
    public Order finish(Long id) {
        Order order = orderRepo.findById(id).get();
        order.setStatus(Status.INACTIVE);
        return orderRepo.saveAndFlush(order);
    }
}
