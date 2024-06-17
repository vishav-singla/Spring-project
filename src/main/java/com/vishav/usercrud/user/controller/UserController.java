package com.vishav.usercrud.user.controller;

import com.vishav.usercrud.user.exception.UserAlreadyExistsException;
import com.vishav.usercrud.user.exception.UserNotFoundException;
import com.vishav.usercrud.user.mapper.UserMapper;
import com.vishav.usercrud.user.pojo.UserPojo;
import com.vishav.usercrud.user.response.UserResponse;
import com.vishav.usercrud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public List<UserPojo> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/fetch")
    public ResponseEntity<UserResponse> getUserByName(@RequestParam String username) {
        return userService.getUserByName(username)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<UserPojo> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<UserPojo> createUser(@RequestBody UserPojo userPojo) {
        try {
            UserPojo createdUser = userService.createUser(userPojo);
            return ResponseEntity.ok(createdUser);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserPojo> updateUser(@PathVariable Long id, @RequestBody UserPojo userDetails) {
        return ResponseEntity.ok(userService.updateUser(id, userDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}