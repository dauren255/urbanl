package kz.urbanl.urbanlogistics.controllers;

import kz.urbanl.urbanlogistics.model.Order;
import kz.urbanl.urbanlogistics.service.PhotoDetailsService;
import kz.urbanl.urbanlogistics.service.impl.OrderServiceImpl;
import kz.urbanl.urbanlogistics.utils.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController extends CommonService {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private PhotoDetailsService photoDetailsService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrders(){
        return builder(success(orderService.getAllOrders()));
    }

    @RequestMapping(value = "/allByCompany", method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrdersByCompany(@RequestParam Long id){
        return builder(success(orderService.getAllOrdersByCompany(id)));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@RequestBody Order order){
        return builder(success(orderService.createOrder(order)));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateOrder(@RequestBody Order order){
        return builder(success(orderService.updateOrder(order)));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrder(@RequestBody Order order){
        orderService.deleteOrder(order);
        return builder(success("Successfully deleted"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrderById(@PathVariable Long id){
        return builder(success(orderService.getOrderById(id)));
    }

//    @RequestMapping(value = "/{id}/allPhotos", method = RequestMethod.GET)
//    public ResponseEntity<?> getAllPhotos(@PathVariable Long id){
//        Order order = orderService.getOrderById(id);
//        return builder(success(order.getPhotos()));
//    }
}
