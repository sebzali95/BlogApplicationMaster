package com.example.blogapplicationmaster.controller;


import com.example.blogapplicationmaster.model.dto.UserDTO;
import com.example.blogapplicationmaster.model.entity.User;
import com.example.blogapplicationmaster.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity createNemUser(@RequestBody UserDTO userDTO) {
        User users = userService.createUsers(userDTO);
        if (users == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("The user could not be successfully created");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsersById(@PathVariable Long id) {
        try {
            userService.deleteUsersById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to find User to delete");
        }
        return ResponseEntity.status(HttpStatus.OK).body("User has been deleted successfully.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUsers(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User updateUsers = userService.updateUsers(id, userDTO);
        if (updateUsers == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update user. No such user exists.");
        }
       return ResponseEntity.status(HttpStatus.OK).body(updateUsers);
    }


    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Long id) {
        User userById;
        try {
            userById = userService.getUsersById(id);
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Kullanici bulunamadi");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userById);
    }
}
