package com.thelibrarian.data.repository;



import com.thelibrarian.data.dto.BookingDto;
import org.springframework.http.ResponseEntity;

import com.thelibrarian.data.entity.ReservationEntity;



public interface IReserve {


   public ResponseEntity<BookingDto> createReserve(BookingDto booking);
    
}
