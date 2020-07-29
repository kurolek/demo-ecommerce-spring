package org.kurolek.demo.springboot.demoecommerce.controller;

import org.kurolek.demo.springboot.demoecommerce.model.ProducerModel;
import org.kurolek.demo.springboot.demoecommerce.model.ResponseModel;
import org.kurolek.demo.springboot.demoecommerce.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eCommerce")
public class ProducerController {
    @Autowired
    private ProducerService service;

    @PostMapping("/addProducer")
    public ResponseModel addProducer(@RequestBody ProducerModel producerModel) {
        return service.addProducer(producerModel);
    }

    @GetMapping("/getProducerByName")
    public ResponseModel getProducerByName(@PathVariable String name) {
        return service.getProducerByName(name);
    }
}

