package com.example.Allermi.domain.User.service;

import com.example.Allermi.domain.User.Dto.UserRequest;
import com.example.Allermi.domain.User.Entity.UserEntity;
import com.example.Allermi.domain.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public String register(UserRequest request){
        try{
            userRepository.save(
                    UserEntity.builder()
                            .nickname(request.getNickname())
                            .password(request.getPassword())
                            .allergy(request.getAllergy())
                            .build()
            );
            return "Success";
        }catch(Exception e){
            throw new AlreadyExistsException();
        }
    }
}

