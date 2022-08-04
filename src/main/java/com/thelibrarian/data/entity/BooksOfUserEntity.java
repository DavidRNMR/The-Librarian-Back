package com.thelibrarian.data.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="USER_BOOKS")
@NoArgsConstructor
@AllArgsConstructor
public class BooksOfUserEntity {


    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private Long id;

    private Date acquisitionDate;



  
    
}
