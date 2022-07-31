package com.example.Allermi.domain.User.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserRequest {
    private String nickname;
    private String password;
    private String allergy;
}
