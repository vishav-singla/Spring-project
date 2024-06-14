package com.vishav.usercrud.user.mapper;

import com.vishav.usercrud.user.pojo.UserPojo;
import com.vishav.usercrud.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserPojo toPojo(User user) {
        UserPojo pojo = new UserPojo();
        pojo.setId(user.getId());
        pojo.setName(user.getName());
        pojo.setEmail(user.getEmail());
        pojo.setCity(user.getCity());
        pojo.setCountry(user.getCountry());
        pojo.setState(user.getState());
        pojo.setZip(user.getZip());
        return pojo;
    }

    public User toEntity(UserPojo pojo) {
        User user = new User();
        user.setId(pojo.getId());
        user.setName(pojo.getName());
        user.setEmail(pojo.getEmail());
        user.setCity(pojo.getCity());
        user.setCountry(pojo.getCountry());
        user.setState(pojo.getState());
        user.setZip(pojo.getZip());
        return user;
    }
}