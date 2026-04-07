package com.eventmanagement.eventmanagementsystem.user.Service;

import com.eventmanagement.eventmanagementsystem.user.DTO.UserModelDTO;
import com.eventmanagement.eventmanagementsystem.user.Exception.UserNotFoundException;
import com.eventmanagement.eventmanagementsystem.user.Model.UserModel;
import com.eventmanagement.eventmanagementsystem.user.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel registerUser(UserModelDTO userModelDTO) {
        UserModel user = new UserModel();
        user.setName(userModelDTO.getName());
        user.setEmail(userModelDTO.getEmail());
        return userRepository.save(user);
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User not found with id: " + id));

    }

    public UserModel updateUser(Long id, UserModelDTO userModelDTO) {
        UserModel user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userModelDTO.getName());
            user.setEmail(userModelDTO.getEmail());
            return userRepository.save(user);
        }
        return null;
    }

    public UserModel deleteUser(Long id) {
        UserModel user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);

        }
        return null;
    }
}
