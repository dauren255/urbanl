package kz.urbanl.urbanlogistics.controllers;

import kz.urbanl.urbanlogistics.model.Mover;
import kz.urbanl.urbanlogistics.model.Status;
import kz.urbanl.urbanlogistics.service.impl.MoverServiceImpl;
import kz.urbanl.urbanlogistics.service.impl.UserServiceImpl;
import kz.urbanl.urbanlogistics.utils.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/mover")
public class MoverController extends CommonService {

    @Autowired
    MoverServiceImpl moverService;

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/{id}/addMover", method = RequestMethod.POST)
    public ResponseEntity<?> addMoverToCompany(@PathVariable Long id, @RequestBody Mover mover){
        moverService.addMoverToCompany(id, mover);
        return builder(success("Successfully added"));
    }

        @RequestMapping(value = "/allMoverByCompany", method = RequestMethod.GET)
    public ResponseEntity<?> findAllMoverByCompany(@RequestParam String username){
        return builder(success(moverService.getAllMovers(username)));
    }

    @RequestMapping(value = "/createMover", method = RequestMethod.POST)
    public ResponseEntity<?> createMover(@RequestBody Mover mover, @RequestParam String username){
        if(userService.loadUserByUsername(username) != null){
            return builder(errorWithDescription(Status.ALREADY_HAVE, "Account already have"));
        }
        return builder(success(moverService.createMover(mover, username)));
    }
}
