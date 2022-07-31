package com.example.Allermi.domain.User.Controller;

import com.example.Allermi.domain.User.Dto.UserRequest;
import com.example.Allermi.domain.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public String Register(@RequestBody UserRequest userRequest){
        return userService.register(userRequest);
    }
}