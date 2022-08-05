package com.thelibrarian.data.repository;



import org.springframework.http.ResponseEntity;
import com.thelibrarian.data.dto.BookingDto;



public interface IReserve {


   public ResponseEntity<BookingDto> createReserve(BookingDto booking);
    
}
