package com.thelibrarian.data.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thelibrarian.data.entity.UsersEntity;
import com.thelibrarian.data.repository.IUser;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceBBDD {

    @Autowired
    private @NonNull IUser usuRepo;
    

    public List<UsersEntity> findAll() {
        return usuRepo.findAll();
    }

    public UsersEntity insert(UsersEntity u) throws NoSuchAlgorithmException {
        u.setPassword(encodePassword(u.getPassword()));
        return usuRepo.save(u);
    }

    public UsersEntity login(String correo, String password) throws NoSuchAlgorithmException {
        return usuRepo.findByCorreoAndPassword(correo, encodePassword(password));
    }

    public UsersEntity update(UsersEntity e, int id) {
        if(usuRepo.existsById(id)) {
            e.setId(id);
            return usuRepo.save(e);
        }
        return null; // No existe
    }

    public UsersEntity updatePassword( String email, String password, String newPassword) throws NoSuchAlgorithmException {

        System.out.println("Holaaaaaaaaaa"+ email);
        System.out.println("Hola password" + password);
        System.out.println("Codificado" + encodePassword(password));

        //Problema
        UsersEntity userNewPassword = usuRepo.findByCorreoAndPassword(email,encodePassword(password));
        userNewPassword = usuRepo.getReferenceById(userNewPassword.getId());

        System.out.println("Nombre" + userNewPassword.getNombre());

        System.out.println("ID"+userNewPassword.getId());


        if(userNewPassword.getId()!=null) {

            System.out.println("No es null");


            userNewPassword.setPassword(encodePassword(newPassword));


            System.out.println("Contraseña actual" + userNewPassword.getPassword());


            usuRepo.save(userNewPassword);

            return userNewPassword;
        }

        return null; // No existe
    }


    private String encodePassword(String pass) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
		String encodedPass = Base64.getEncoder().encodeToString(hash);
		return encodedPass;
	}

    public UsersEntity findById(Integer id_usuario) {
        return usuRepo.findById(id_usuario).orElse(null);
    }
}
