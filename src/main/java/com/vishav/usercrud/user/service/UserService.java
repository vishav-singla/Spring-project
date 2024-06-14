package com.vishav.usercrud.user.service;

import com.vishav.usercrud.user.entity.User;
import com.vishav.usercrud.user.pojo.UserPojo;
import com.vishav.usercrud.user.repository.UserRepository;
import com.vishav.usercrud.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserPojo> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toPojo).collect(Collectors.toList());
    }

    public Optional<UserPojo> getUserById(Long id) {
        return userRepository.findById(id).map(userMapper::toPojo);
    }

    public UserPojo createUser(UserPojo userPojo) {
        User user = userMapper.toEntity(userPojo);
        User savedUser = userRepository.save(user);
        return userMapper.toPojo(savedUser);
    }

    public UserPojo updateUser(Long id, UserPojo userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setCity(userDetails.getCity());
            user.setCountry(userDetails.getCountry());
            user.setState(userDetails.getState());
            user.setZip(userDetails.getZip());
            User updatedUser = userRepository.save(user);
            return userMapper.toPojo(updatedUser);
        }).orElseGet(() -> {
            User user = userMapper.toEntity(userDetails);
            user.setId(id);
            User newUser = userRepository.save(user);
            return userMapper.toPojo(newUser);
        });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}