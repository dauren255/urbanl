package kz.urbanl.urbanlogistics.controllers;

import kz.urbanl.urbanlogistics.config.SecurityConfig;
import kz.urbanl.urbanlogistics.model.CardData;
import kz.urbanl.urbanlogistics.model.User;
import kz.urbanl.urbanlogistics.service.impl.UserServiceImpl;
import kz.urbanl.urbanlogistics.utils.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends CommonService {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
    public ResponseEntity<?> authenticate(@RequestParam String username, @RequestParam String password){
        return builder(success(userService.authenticate(username, password)));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user){
        return builder(success(userService.createUser(user)));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody User user){
        return builder(success(userService.updateUser(user)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        return builder(success(userService.getUserById(id)));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> findAllUsers(){
        return builder(success(userService.getAllUsers()));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody User user){
        userService.deleteUser(user);
        return builder(success("Successfully deleted"));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> addCardDataUser(@RequestParam Long userId, @RequestBody CardData cardData){
        return builder(success(userService.addCardData(userId, cardData)));
    }
}
