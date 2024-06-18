package com.vishav.usercrud.user.mapper;

import com.vishav.usercrud.user.pojo.UserPojo;
import com.vishav.usercrud.user.entity.User;
import com.vishav.usercrud.user.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserPojo toPojo(User user) {
        UserPojo pojo = new UserPojo();
        pojo.setId(user.getId());
        pojo.setName(user.getName());
        pojo.setUsername(user.getUsername()); // Correct mapping for username
        pojo.setEmail(user.getEmail());
        pojo.setCity(user.getCity());
        pojo.setCountry(user.getCountry());
        pojo.setState(user.getState());
        pojo.setZip(user.getZip());
        pojo.setPassword(user.getPassword()); // Correct mapping for password
        return pojo;
    }

    public User toEntity(UserPojo pojo) {
        User user = new User();
        user.setId(pojo.getId());
        user.setName(pojo.getName());
        user.setUsername(pojo.getUsername()); // Correct mapping for username
        user.setEmail(pojo.getEmail());
        user.setCity(pojo.getCity());
        user.setCountry(pojo.getCountry());
        user.setState(pojo.getState());
        user.setZip(pojo.getZip());
        user.setPassword(pojo.getPassword()); // Correct mapping for password
        return user;
    }

    public UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setUsername(user.getUsername()); // Correct mapping for username
        response.setEmail(user.getEmail());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());
        response.setCity(user.getCity());
        response.setCountry(user.getCountry());
        response.setState(user.getState());
        response.setZip(user.getZip());
        return response;
    }
}
