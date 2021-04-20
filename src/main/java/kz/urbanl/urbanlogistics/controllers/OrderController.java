package kz.urbanl.urbanlogistics.controllers;

import kz.urbanl.urbanlogistics.model.Order;
import kz.urbanl.urbanlogistics.model.Order;
import kz.urbanl.urbanlogistics.service.PhotoDetailsService;
import kz.urbanl.urbanlogistics.service.impl.OrderServiceImpl;
import kz.urbanl.urbanlogistics.utils.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/order")
public class OrderController extends CommonService {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private PhotoDetailsService photoDetailsService;

    @RequestMapping(name = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrders(){
        return builder(success(orderService.getAllOrders()));
    }

    @RequestMapping(name = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@RequestBody Order order){
        return builder(success(orderService.createOrder(order)));
    }

    @RequestMapping(name = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateOrder(@RequestBody Order order){
        return builder(success(orderService.updateOrder(order)));
    }

    @RequestMapping(name = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrder(@RequestBody Order order){
        orderService.deleteOrder(order);
        return builder(success("Successfully deleted"));
    }

    @RequestMapping(name = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrderById(@PathVariable Long id){
        return builder(success(orderService.getOrderById(id)));
    }
}
