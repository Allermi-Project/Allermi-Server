package com.example.Allermi.domain.User.result;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Result implements Serializable {
    private boolean success;
    private int code;
    private String msg;
}
