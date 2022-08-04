package com.thelibrarian.core.controller;

import com.thelibrarian.data.entity.ReservationEntity;
import com.thelibrarian.data.service.ReservationServiceBBDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationControllerBBDD {

    @Autowired
    ReservationServiceBBDD reservationService;

    @GetMapping("/getAllReservation")
    public List<ReservationEntity> findAll() {

        return reservationService.findAll();
    }
}
