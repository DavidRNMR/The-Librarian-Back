package com.thelibrarian.data.repository;

import com.thelibrarian.data.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository <UsersEntity, Integer> {


}
