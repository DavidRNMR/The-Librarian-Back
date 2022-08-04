package com.thelibrarian.data.service;

import com.thelibrarian.data.entity.BookEntity;
import com.thelibrarian.data.entity.UsersEntity;
import com.thelibrarian.data.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceBBDD {

    @Autowired
    IUser user;

    public UsersEntity findById(Integer id) {

        return user.findById(id).orElse(null);
    }

    public List<UsersEntity> findAll() {

        return user.findAll();
    }
}
