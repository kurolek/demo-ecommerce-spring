package org.kurolek.demo.springboot.demoecommerce.controller;

import org.kurolek.demo.springboot.demoecommerce.model.AddressModel;
import org.kurolek.demo.springboot.demoecommerce.model.ResponseModel;
import org.kurolek.demo.springboot.demoecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eCommerce")
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping("/createAddress")
    public ResponseModel createNewAddress(@RequestBody AddressModel address) {
        return service.setAddress(address);
    }

    @GetMapping("/getAddressesByCountry/{country}")
    public ResponseModel getAddress(@PathVariable String country) {
        return service.getAddressesByCountry(country);
    }
}
