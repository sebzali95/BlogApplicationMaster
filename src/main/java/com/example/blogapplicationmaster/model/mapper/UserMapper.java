package com.example.blogapplicationmaster.model.mapper;

import com.example.blogapplicationmaster.model.dto.UserDTO;
import com.example.blogapplicationmaster.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setUserName(user.getUserName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());
        userDTO.setMail(user.getMail());
        userDTO.setPhoneNumber(user.getPhoneNumber());

        return userDTO;
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setMail(userDTO.getMail());
        user.setPhoneNumber(userDTO.getPhoneNumber());

        return user;
    }
}
