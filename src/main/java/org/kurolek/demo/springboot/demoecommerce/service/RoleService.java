package org.kurolek.demo.springboot.demoecommerce.service;

import org.kurolek.demo.springboot.demoecommerce.dao.RoleHibernateDAO;
import org.kurolek.demo.springboot.demoecommerce.entity.Category;
import org.kurolek.demo.springboot.demoecommerce.entity.Role;
import org.kurolek.demo.springboot.demoecommerce.model.CategoryModel;
import org.kurolek.demo.springboot.demoecommerce.model.ResponseModel;
import org.kurolek.demo.springboot.demoecommerce.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    RoleHibernateDAO dao;

    public ResponseModel createRole(RoleModel roleModel) {
        Role role = Role.builder().name(roleModel.name).build();
        dao.save(role);
        return ResponseModel.builder()
                .status(ResponseModel.SUCCESS_STATUS)
                .message(String.format("%s Role Created", role.getName()))
                .build();
    }

    public ResponseModel getAllRoles() {
        List<Role> roles = dao.findAll();
        List<RoleModel> roleModels =
                roles.stream()
                        .map((r) -> RoleModel.builder()
                                .id(r.getId())
                                .name(r.getName())
                                .build())
                        .collect(Collectors.toList());

        return ResponseModel.builder()
                .status(ResponseModel.SUCCESS_STATUS)
                .message(String.format("Role List Retrieved Successfully"))
                .data(roleModels)
                .build();
    }

}
