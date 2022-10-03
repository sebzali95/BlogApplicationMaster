package com.example.blogapplicationmaster.service;

import com.example.blogapplicationmaster.model.dto.UserDTO;
import com.example.blogapplicationmaster.model.entity.User;
import com.example.blogapplicationmaster.model.mapper.UserMapper;
import com.example.blogapplicationmaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    public User createUsers(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    public User getUsersById(Long id) {
        Optional<User> byId = userRepository.findById(id);
        return byId.orElseThrow(() -> new RuntimeException("User not found."));
    }

    public void deleteUsersById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUsers(Long id, UserDTO userDTO) {
        Optional<User> byId = userRepository.findById(id);

        if (!byId.isPresent()) {
            return null;
        }

        User user = byId.get();
        user.setUserName(userDTO.getUserName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setMail(userDTO.getMail());
        user.setPhoneNumber(userDTO.getPhoneNumber());

        return userRepository.save(user);
    }

}

