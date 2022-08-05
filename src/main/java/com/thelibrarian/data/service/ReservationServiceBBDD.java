package com.thelibrarian.data.service;

import com.thelibrarian.data.entity.ReservationEntity;
import com.thelibrarian.data.repository.IReserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceBBDD {

    @Autowired
    IReserve reserve;

    public List<ReservationEntity> findAll() {

        return reserve.findAll();
    }

}
