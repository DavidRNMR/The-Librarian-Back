package com.thelibrarian.data.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
<<<<<<< HEAD
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
=======
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
>>>>>>> 0a5e783 ([#27293] creando funcionalidad descargar en PDF)

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null
    private Integer id;
    @NotNull(message = "El nombre es obligatorio")
    private String nombre;
    @NotNull
    @Email
    private String correo;
    @NotEmpty
    private String password;


    @JsonBackReference
    @OneToMany(targetEntity = ReservationEntity.class, mappedBy = "id_usuario", orphanRemoval = false, fetch = FetchType.LAZY)
	private List<ReservationEntity> reservation;
}
