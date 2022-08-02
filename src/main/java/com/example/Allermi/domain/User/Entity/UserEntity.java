package com.example.Allermi.domain.User.Entity;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class UserEntity {
    @Id @GeneratedValue
    private Long id;
    @NotNull
    private String nickname;
    @NotNull
    private String password;
    @ElementCollection
    private List<String> allergy;

    @Builder
    public UserEntity(String nickname, String password, List<String> allergy) {
        this.nickname = nickname;
        this.password = password;
        this.allergy = allergy;
    }
}
