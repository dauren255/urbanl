package kz.urbanl.urbanlogistics.controllers;

import kz.urbanl.urbanlogistics.model.Order;
import kz.urbanl.urbanlogistics.model.User;
import kz.urbanl.urbanlogistics.model.UserRole;
import kz.urbanl.urbanlogistics.service.PhotoDetailsService;
import kz.urbanl.urbanlogistics.service.UserService;
import kz.urbanl.urbanlogistics.service.impl.OrderServiceImpl;
import kz.urbanl.urbanlogistics.service.impl.UserServiceImpl;
import kz.urbanl.urbanlogistics.utils.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController extends CommonService {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PhotoDetailsService photoDetailsService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrders() {
        return builder(success(orderService.getAllOrders()));
    }

    @RequestMapping(value = "/allByCompany", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrdersByCompany(@RequestParam String username) {
        return builder(success(orderService.getAllOrdersByCompany(username)));
    }

    @RequestMapping(value = "/allByCompanyInactive", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrdersByCompanyInactive(@RequestParam String username) {
        return builder(success(orderService.getAllOrdersByCompanyInactive(username)));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        return builder(success(orderService.createOrder(order)));
    }

    @RequestMapping(value = "/setWorked", method = RequestMethod.POST)
    public ResponseEntity<?> setWorked(
            @RequestParam Long id,
            @RequestParam String username,
            @RequestParam Long moverId) {
        User user = userService.getUserByUsername(username);
        Order order = orderService.getOrderById(id);
        if (user.userContainCompanyAdmin() && order.getCompany() == user.getCompany()) {
            return builder(success(orderService.setWorked(id, username, moverId)));
        }
        return builder(order, HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/finishByMover", method = RequestMethod.POST)
    public ResponseEntity<?> finishByMover(
            @RequestParam Long id,
            @RequestParam String username,
            @RequestParam Long moverId) {
        User user = userService.getUserByUsername(username);
        Order order = orderService.getOrderById(id);
        if (user.userContainCompanyAdmin() && order.getCompany() == user.getCompany()) {
            return builder(success(orderService.finishByMover(id)));
        }
        return builder(order, HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/finishByManager", method = RequestMethod.POST)
    public ResponseEntity<?> finishByManager(
            @RequestParam Long id,
            @RequestParam String username,
            @RequestParam Long moverId) {
        User user = userService.getUserByUsername(username);
        Order order = orderService.getOrderById(id);
        if (user.userContainCompanyAdmin() && order.getCompany() == user.getCompany()) {
            return builder(success(orderService.finishByManager(id)));
        }
        return builder(order, HttpStatus.UNAUTHORIZED);
    }

//    @RequestMapping(value = "/update", method = RequestMethod.PUT)
//    public ResponseEntity<?> updateOrder(@RequestBody Order order) {
//        return builder(success(orderService.updateOrder(order)));
//    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrder(@RequestBody Order order) {
        orderService.deleteOrder(order);
        return builder(success("Successfully deleted"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        return builder(success(orderService.getOrderById(id)));
    }

//    @RequestMapping(value = "/{id}/allPhotos", method = RequestMethod.GET)
//    public ResponseEntity<?> getAllPhotos(@PathVariable Long id){
//        Order order = orderService.getOrderById(id);
//        return builder(success(order.getPhotos()));
//    }
}
