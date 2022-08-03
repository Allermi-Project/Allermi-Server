package com.example.Allermi.domain.User.Entity;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class UserEntity implements Serializable {
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

    public void update(UserEntity userEntity){
        this.password = userEntity.password;
        this.allergy = userEntity.allergy;
    }
}

