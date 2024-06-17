package com.vishav.usercrud.user.controller;

import com.vishav.usercrud.user.pojo.UserPojo;
import com.vishav.usercrud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/fetch")
    public List<UserPojo> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<UserPojo> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public UserPojo createUser(@RequestBody UserPojo userPojo) {
        return userService.createUser(userPojo);
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