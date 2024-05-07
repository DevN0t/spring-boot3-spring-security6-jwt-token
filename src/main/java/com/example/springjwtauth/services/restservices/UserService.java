package com.example.springjwtauth.services.restservices;


import com.example.springjwtauth.domain.entity.user.User;
import com.example.springjwtauth.entrypoint.dto.UserListDTO;
import com.example.springjwtauth.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<UserListDTO> getAllUsers(){
        List<UserListDTO> user = userRepository.findUsers();
        return user;
}
}
