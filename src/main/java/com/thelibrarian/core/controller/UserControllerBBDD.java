package com.thelibrarian.core.controller;


import java.security.NoSuchAlgorithmException;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.thelibrarian.data.dto.UserDto;
import com.thelibrarian.data.entity.UsersEntity;
import com.thelibrarian.data.service.UserServiceBBDD;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public List<UserDto> findAll() {

        return usuService.findAll().stream().map(post -> modelMapper.map(post, UserDto.class))
                .collect(Collectors.toList());
    }


    @PostMapping
   // @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<UserDto> insert(@RequestBody UserDto user) throws NoSuchAlgorithmException{

        // convert DTO to entity
        UsersEntity postRequest = modelMapper.map(user, UsersEntity.class);

        UsersEntity usersEntity = usuService.insert(postRequest);

        // convert entity to DTO
        UserDto postResponse = modelMapper.map(postRequest, UserDto.class);

        return new ResponseEntity<UserDto>(postResponse, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update( @PathVariable int id, @RequestBody @Valid UserDto userDto) {

        // convert DTO to Entity
        UsersEntity postRequest = modelMapper.map(userDto, UsersEntity.class);

        UsersEntity usersEntity = usuService.update(postRequest, id);

        // entity to DTO
        UserDto postResponse = modelMapper.map(usersEntity, UserDto.class);

        return ResponseEntity.ok().body(postResponse);

    }

}
