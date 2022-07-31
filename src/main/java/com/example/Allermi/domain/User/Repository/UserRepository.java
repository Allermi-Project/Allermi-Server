package com.example.Allermi.domain.User.Repository;

import com.example.Allermi.domain.User.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserEntityByNickname(String nickname);
}
