package com.example.restAPI.Entity;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Getter
@Setter
@Entity
public class UserEntity {
    @Id @GeneratedValue

    private Long id;
    @NotNull
    private String userid;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String allergy;

    public UserEntity(){
    }

    public UserEntity(String userid, String password, String name, String allergy) {
        this.userid = userid;
        this.password = password;
        this.name = name;
        this.allergy = allergy;
    }
}
