package com.thelibrarian.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thelibrarian.data.entity.UsersEntity;
import com.thelibrarian.data.repository.IUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceBBDD implements IUserService {

    @Autowired
    private IUser user;

    public UsersEntity findById(Integer id) {

        return user.findById(id).orElse(null);
    }

    public List<UsersEntity> findAll() {

        return user.findAll();
    }

    public UsersEntity insert(UsersEntity userEntity) {
        System.out.println(" Println 2" + userEntity);
        return user.save(userEntity);
    }

    public UsersEntity Update(UsersEntity users, Integer id) {

        if (user.existsById(id)) {

            users.setId(id);

            return user.save(users);
        }
        return null;

    }

}
