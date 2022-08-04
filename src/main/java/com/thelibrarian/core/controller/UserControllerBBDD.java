package com.thelibrarian.core.controller;

import com.thelibrarian.data.entity.UsersEntity;
import com.thelibrarian.data.service.UserServiceBBDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserControllerBBDD {

    @Autowired
    UserServiceBBDD userService;

    @GetMapping("/findOne/{id}")
    public UsersEntity findById(Integer id) {

        return userService.findById(id);
    }

    public List<UsersEntity> findAll() {

        return userService.findAll();
    }
}
