package com.example.Allermi.domain.User.Controller;

import com.example.Allermi.domain.User.Entity.UserEntity;
import com.example.Allermi.domain.User.Repository.UserRepository;
import com.example.Allermi.domain.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getUsers(@PageableDefault Pageable pageable){
        Page<UserEntity> userEntities = userRepository.findAll(pageable);
        PagedModel.PageMetadata pageMetadata = new PagedModel.PageMetadata(pageable.getPageSize(),
                userEntities.getNumber(), userEntities.getTotalElements());
        PagedModel<UserEntity> model = PagedModel.of(userEntities.getContent(), pageMetadata);

        return ResponseEntity.ok(model);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserEntity userEntity){
        userService.save(userEntity);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putUser(@PathVariable("id") Long id, @RequestBody UserEntity userEntity) {
        UserEntity user = userRepository.getReferenceById(id);
        user.update(userEntity);
        userRepository.save(user);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}