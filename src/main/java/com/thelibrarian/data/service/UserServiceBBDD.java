package com.thelibrarian.data.service;

import com.thelibrarian.data.entity.UsersEntity;
import com.thelibrarian.data.repository.IUser;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void save (UsersEntity userEntity){

        user.save(userEntity);
    }

    public UsersEntity Update (UsersEntity users, Integer id){

        if(user.existsById(id)){

            users.setId(id);

            return user.save(users);
        }
            return null;

    }


}
