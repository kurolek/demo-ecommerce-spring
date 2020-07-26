package org.kurolek.demo.springboot.demoecommerce.service;

import org.kurolek.demo.springboot.demoecommerce.dao.CategoryDAO;
import org.kurolek.demo.springboot.demoecommerce.entity.Category;
import org.kurolek.demo.springboot.demoecommerce.model.CategoryModel;
import org.kurolek.demo.springboot.demoecommerce.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryDAO dao;


    public ResponseModel createCategory(CategoryModel categoryModel){
        Category category =
                Category.builder()
                        .name(categoryModel.getName())
                        .build();
        dao.save(category);
        return ResponseModel.builder()
                .status("succes")
                .message("Category added")
                .build();
    }

    public List<CategoryModel> getAllCategories(){
        List<Category> categories = dao.findAll();
        return categories.stream().map(c ->
                CategoryModel.builder()
                    .id(c.getId())
                    .name(c.getName())
                    .build()
        ).collect(Collectors.toList());
    }

}
