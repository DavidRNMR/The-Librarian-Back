package com.thelibrarian.core.controller;


import java.security.NoSuchAlgorithmException;

import java.util.List;

import javax.validation.Valid;

import com.thelibrarian.data.entity.UsersEntity;
import com.thelibrarian.data.service.UserServiceBBDD;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
// @CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserControllerBBDD {

    @Autowired
    private @NonNull UserServiceBBDD usuService;

    @GetMapping
    public List<UsersEntity> findAll() {
        return usuService.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UsersEntity insert(@RequestBody UsersEntity user) throws NoSuchAlgorithmException{
        return usuService.insert(user);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersEntity> update(@RequestBody @Valid UsersEntity evento, @PathVariable int id) {
        UsersEntity e = usuService.update(evento, id);
        if(e == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(e);
        }
    }



}
