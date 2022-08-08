package com.thelibrarian.core.controller;

import java.util.List;

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

import com.thelibrarian.data.entity.ReservationEntity;
import com.thelibrarian.data.repository.IBookDao;
import com.thelibrarian.data.service.ReservationServiceBBDD;


import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/reserve")
public class ReservationControllerBBDD {

    @Autowired
    ReservationServiceBBDD reservationService;

    @Autowired
    IBookDao bookDao;


    @GetMapping("/getAllReservation")
    public List<ReservationEntity> findAll() {

        return reservationService.findAll();
    }


    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<ReservationEntity> insert(@RequestBody ReservationEntity booking){

        return reservationService.createReserve(booking);
    }

    @PutMapping("/updateReserve/{id}")
    public ResponseEntity<ReservationEntity> Update(@RequestBody ReservationEntity reservation, @PathVariable Integer id) {
        ReservationEntity reservation1 = reservationService.Update(reservation, id);

        return ResponseEntity.ok().body(reservation1);
    }
    
}
