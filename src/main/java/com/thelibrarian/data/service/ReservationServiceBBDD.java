package com.thelibrarian.data.service;

import com.thelibrarian.data.entity.ReservationEntity;
import com.thelibrarian.data.repository.IReserve;
import com.thelibrarian.data.repository.IReserveJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceBBDD implements IReserve {

    @Autowired
    IReserveJpa reserve;

    @Autowired
    UserServiceBBDD userService;

    public List<ReservationEntity> findAll() {

        return reserve.findAll();
    }

    @Override
    public ResponseEntity<ReservationEntity> createReserve(ReservationEntity booking) {

        

        List<ReservationEntity> reserveListOfUser = userService.findById(booking.getId_usuario()).getReservation();

        int count = 0;


        if(reserveListOfUser!= null){

            for (ReservationEntity reservationEntity : reserveListOfUser) {
    
            //    System.out.println("Id usuario" + reservationEntity.getId_usuario());
            //    System.out.println("Id libro" + reservationEntity.getId_book());



                if (reservationEntity.getIs_reservado()) {

                    count++;
    
                    if (count == 3) {
                        break;
                    }
    
                }
    
            }
    
    
            if(count<3){
                // System.out.println("Reserva completa OK " + booking.toString());
                reserve.save(booking);
                return ResponseEntity.ok().body(booking);
            }else{
    
                // System.out.println("Reserva del count <3 Falla");
                return ResponseEntity.notFound().build();
            }
    

        }else{
            
            // System.out.println("Reserva  Falla");
            return ResponseEntity.notFound().build();
        }


          

      

    }
    

}
