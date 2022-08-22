package com.thelibrarian.core.controller;


import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.thelibrarian.data.entity.UsersEntity;
import com.thelibrarian.data.service.UserServiceBBDD;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
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
    public UsersEntity insert(@RequestBody UsersEntity user) throws NoSuchAlgorithmException {
        return usuService.insert(user);


    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersEntity> update(@RequestBody @Valid UsersEntity evento, @PathVariable int id) {

        UsersEntity e = usuService.update(evento, id);
        if (e == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(e);
        }
    }

    //ChangePassword
    @PutMapping("/changePassword")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<UsersEntity> update(@RequestParam String email, @RequestParam String password, @RequestParam String newPassword) throws NoSuchAlgorithmException {


        UsersEntity userPasswordChanged = usuService.updatePassword(email, password, newPassword);


        if (usuService == null) {

            return ResponseEntity.notFound().build();
        } else {

            return ResponseEntity.ok().body(userPasswordChanged);
        }
    }


}
