package com.example.Allermi.domain.User.Entity;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id @GeneratedValue

    private Long id;
    @NotNull
    private String nickname;
    @NotNull
    private String password;
    @NotNull
    private String allergy;
}
