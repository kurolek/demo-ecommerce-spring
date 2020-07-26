package org.kurolek.demo.springboot.demoecommerce.controller;

import org.kurolek.demo.springboot.demoecommerce.model.CategoryModel;
import org.kurolek.demo.springboot.demoecommerce.model.ResponseModel;
import org.kurolek.demo.springboot.demoecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eCommerce")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping("/addCategory")
    public ResponseModel addCategory(@RequestBody CategoryModel categoryModel){
        return service.createCategory(categoryModel);
    }

    @GetMapping("/getAllCategories")
    public List<CategoryModel> getAllCategories() {
        return service.getAllCategories();
    }
}
