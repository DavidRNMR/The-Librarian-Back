package com.thelibrarian.core.controller;

<<<<<<< HEAD
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

=======
import com.lowagie.text.DocumentException;
import com.thelibrarian.data.entity.UsersEntity;
import com.thelibrarian.data.service.UserServiceBBDD;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.apache.catalina.User;
>>>>>>> 0a5e783 ([#27293] creando funcionalidad descargar en PDF)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.thelibrarian.data.entity.UsersEntity;
import com.thelibrarian.data.service.UserServiceBBDD;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
=======
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import com.lowagie.text.DocumentException;

>>>>>>> 0a5e783 ([#27293] creando funcionalidad descargar en PDF)

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



<<<<<<< HEAD
    @PutMapping("/{id}")
    public ResponseEntity<UsersEntity> update(@RequestBody @Valid UsersEntity evento, @PathVariable int id) {
        UsersEntity e = usuService.update(evento, id);
        if(e == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(e);
        }
    }
=======
>>>>>>> 0a5e783 ([#27293] creando funcionalidad descargar en PDF)

}
