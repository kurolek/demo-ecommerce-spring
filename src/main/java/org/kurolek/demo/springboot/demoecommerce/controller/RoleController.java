package org.kurolek.demo.springboot.demoecommerce.controller;

import org.kurolek.demo.springboot.demoecommerce.model.CategoryModel;
import org.kurolek.demo.springboot.demoecommerce.model.ResponseModel;
import org.kurolek.demo.springboot.demoecommerce.model.RoleModel;
import org.kurolek.demo.springboot.demoecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eCommerce")
public class RoleController {

    @Autowired
    private RoleService service;

    @PostMapping("/createRole")
    public ResponseModel createRole(@RequestBody RoleModel roleModel){
        return service.createRole(roleModel);
    }

    @GetMapping("/getAllRoles")
    public ResponseModel getAllRoles(){
        return service.getAllRoles();
    }
}
