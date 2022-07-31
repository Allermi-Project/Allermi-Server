package com.example.Allermi.domain.User.service;

import com.example.Allermi.domain.User.Entity.UserEntity;
import com.example.Allermi.domain.User.Repository.UserRepository;
import com.example.Allermi.global.handler.ex.CustomValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository userRepository;

    @Transactional
    public UserEntity save(UserEntity userEntity){
        if(userRepository.findUserEntityByNickname(userEntity.getNickname()) != null) throw new CustomValidationException("이미 존재하는 이름입니다.");
        return userRepository.save(UserEntity.builder()
                .nickname(userEntity.getNickname())
                .password(userEntity.getPassword())
                .allergy(userEntity.getAllergy())
                .build());
    }
}

