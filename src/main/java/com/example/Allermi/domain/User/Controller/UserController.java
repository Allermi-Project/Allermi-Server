package com.example.Allermi.domain.User.Controller;

import com.example.Allermi.domain.User.Entity.UserEntity;
import com.example.Allermi.domain.User.Repository.UserRepository;
import com.example.Allermi.domain.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public UserEntity registerUser(@RequestBody UserEntity userEntity){
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<UserEntity> findOne(@PathVariable Long id) {
        return userRepository.findById(id);
    }
}