package com.thelibrarian.data.repository;



import org.springframework.http.ResponseEntity;
import com.thelibrarian.data.entity.ReservationEntity;


public interface IReserve {


   public ResponseEntity<ReservationEntity> createReserve(ReservationEntity booking);
    
}
