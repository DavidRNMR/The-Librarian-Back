package com.thelibrarian.data.auth.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class ChangePasswordDTO implements Serializable {

    private int id;
    private String email;
    private String name;
    private String password;
    private String newPassword;

}
