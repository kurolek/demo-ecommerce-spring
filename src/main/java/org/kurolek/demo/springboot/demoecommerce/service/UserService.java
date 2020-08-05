package org.kurolek.demo.springboot.demoecommerce.service;

import org.kurolek.demo.springboot.demoecommerce.dao.RoleHibernateDAO;
import org.kurolek.demo.springboot.demoecommerce.dao.UserHibernateDAO;
import org.kurolek.demo.springboot.demoecommerce.entity.Address;
import org.kurolek.demo.springboot.demoecommerce.entity.Role;
import org.kurolek.demo.springboot.demoecommerce.entity.User;
import org.kurolek.demo.springboot.demoecommerce.model.ResponseModel;
import org.kurolek.demo.springboot.demoecommerce.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserHibernateDAO userDao;
    @Autowired
    private RoleHibernateDAO roleDao;

    public ResponseModel createUser(UserModel userModel) {
//        Role role = roleDao.findRoleByName("name");

//        Optional<Address> addressOptional =
//                addressDao.findById(producerModel.getAddress().getId());


        User user =
                User.builder()
                        .name(userModel.getName())
                        .password(userModel.getPassword())
                        .role(roleDao.findRoleByName("user"))
                        .build();
        userDao.save(user);
        return ResponseModel.builder()
                .status(ResponseModel.SUCCESS_STATUS)
                .message(String.format("%s user created", user.getName()))
                .build();
    }

    public ResponseModel upgradeToAdmin(Long id){
        Role role = roleDao.findRoleByName("admin");
        Optional<User> userOptional = userDao.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setRole(role);
            userDao.save(user);
            return ResponseModel.builder()
                    .status(ResponseModel.SUCCESS_STATUS)
                    .message(String.format("Admin %s created successfully", user.getName()))
                    .build();
        }else {
            return ResponseModel.builder()
                    .status(ResponseModel.FAIL_STATUS)
                    .message(String.format("User with id #%d not found", id))
                    .build();
        }
    }

}