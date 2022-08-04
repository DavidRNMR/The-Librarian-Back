package com.thelibrarian.data.repository;

import com.thelibrarian.data.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReserve extends JpaRepository <ReservationEntity,Integer> {

}
