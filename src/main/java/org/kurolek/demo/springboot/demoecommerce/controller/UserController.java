package org.kurolek.demo.springboot.demoecommerce.controller;


import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.kurolek.demo.springboot.demoecommerce.model.AddressModel;
import org.kurolek.demo.springboot.demoecommerce.model.ResponseModel;
import org.kurolek.demo.springboot.demoecommerce.model.UserModel;
import org.kurolek.demo.springboot.demoecommerce.service.ProducerService;
import org.kurolek.demo.springboot.demoecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eCommerce")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/createNewUser")
    public ResponseModel createNewUser(@RequestBody UserModel userModel){
        return service.createUser(userModel);
    }

    @PutMapping("/upgradeUser/{id}")
    public ResponseModel upgradeUser(@PathVariable Long id){
        return service.upgradeToAdmin(id);
    }

//    private     public ResponseModel createNewAddress(@RequestBody AddressModel address) {
//        return service.setAddress(address);
//    }

}
