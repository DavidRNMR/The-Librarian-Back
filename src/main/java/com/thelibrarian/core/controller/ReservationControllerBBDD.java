package com.thelibrarian.core.controller;

import com.thelibrarian.data.dto.BookingDto;
import com.thelibrarian.data.entity.ReservationEntity;
import com.thelibrarian.data.entity.UsersEntity;
import com.thelibrarian.data.repository.IBookDao;
import com.thelibrarian.data.service.ReservationServiceBBDD;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationControllerBBDD {

    @Autowired
    ReservationServiceBBDD reservationService;

    @Autowired
    IBookDao bookDao;


    @GetMapping("/getAllReservation")
    public List<ReservationEntity> findAll() {

        return reservationService.findAll();
    }


    @PostMapping("/createReserve")
    public void createReserve(BookingDto booking){

          reservationService.createReserve(booking);
    }

    @PutMapping("/updateReserve/{id}")
    public ResponseEntity<ReservationEntity> Update(@RequestBody ReservationEntity reservation, @PathVariable Integer id) {
        ReservationEntity reservation1 = reservationService.Update(reservation, id);

        return ResponseEntity.ok().body(reservation1);
    }
    
}
