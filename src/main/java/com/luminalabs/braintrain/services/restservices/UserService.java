package com.luminalabs.braintrain.services.restservices;


import org.springframework.stereotype.Service;

import com.luminalabs.braintrain.domain.entity.user.User;
import com.luminalabs.braintrain.entrypoint.dto.UserListDTO;
import com.luminalabs.braintrain.repositories.UserRepository;

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
