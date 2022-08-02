package com.example.Allermi.domain.User.Controller;

import com.example.Allermi.domain.User.Entity.UserEntity;
import com.example.Allermi.domain.User.Repository.UserRepository;
import com.example.Allermi.domain.User.service.UserService;
import com.example.Allermi.global.handler.ex.CustomValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
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

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateEmployee(@PathVariable long id, @RequestBody UserEntity userEntity) {
        UserEntity updateEmployee = userRepository.findById(id)
                .orElseThrow(() -> new CustomValidationException("Employee not exist with id: " + id));
        updateEmployee.setAllergy(userEntity.getAllergy());
        userRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new CustomValidationException("Employee not exist with id: " + id));

        userRepository.delete(userEntity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}