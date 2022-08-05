package com.thelibrarian.core.controller;

import com.thelibrarian.data.entity.ReservationEntity;
import com.thelibrarian.data.repository.IBookDao;
import com.thelibrarian.data.service.ReservationServiceBBDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void createReserve(ReservationEntity booking){



          reservationService.createReserve(booking);

    }
    
}
