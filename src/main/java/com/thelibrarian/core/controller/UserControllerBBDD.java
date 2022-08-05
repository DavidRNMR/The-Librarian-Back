package com.thelibrarian.core.controller;

import com.thelibrarian.data.entity.BookEntity;
import com.thelibrarian.data.entity.UsersEntity;
import com.thelibrarian.data.service.UserServiceBBDD;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserControllerBBDD {

    @Autowired
    UserServiceBBDD userService;

    @GetMapping("/findOneUser/{id}")
    public UsersEntity findById(Integer id) {

        return userService.findById(id);
    }

    @PostMapping("/createUser")
    @ResponseStatus(code= HttpStatus.CREATED)
    public void insert (@RequestBody UsersEntity user){

         userService.insert(user);
    }

    @GetMapping("/getAllUsers")
    public List<UsersEntity> findAll() {
        return userService.findAll();
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UsersEntity> Update(@RequestBody UsersEntity user, @PathVariable Integer id) {
        UsersEntity user1 = userService.Update(user, id);

        return ResponseEntity.ok().body(user1);
    }


}
