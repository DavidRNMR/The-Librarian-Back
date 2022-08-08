package com.thelibrarian.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thelibrarian.data.entity.UsersEntity;
import com.thelibrarian.data.service.UserServiceBBDD;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservas")
public class UserControllerBBDD {

    @Autowired
    private @NonNull UserServiceBBDD userService;

    @GetMapping("/findOneUser/{id}")
    public UsersEntity findById(Integer id) {

        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public UsersEntity insert(@RequestBody @Valid UsersEntity usert){
        UsersEntity u = userService.insert(usert);
        
        System.out.println(u);
       
        return u;
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
