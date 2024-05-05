package com.example.springjwtauth.entrypoint.controllers;


import com.example.springjwtauth.domain.entity.user.User;
import com.example.springjwtauth.entrypoint.dto.LoginDTO;
import com.example.springjwtauth.entrypoint.dto.LoginResponseDTO;
import com.example.springjwtauth.entrypoint.dto.UserDTO;
import com.example.springjwtauth.services.authorization.AuthorizationService;
import com.example.springjwtauth.services.restservices.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class UserController {

    private final UserService userService;
    private final AuthorizationService authorizationService;

    public UserController(UserService userService, AuthorizationService authorizationService) {
        this.userService = userService;
        this.authorizationService = authorizationService;
    }

    @GetMapping("/get")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserDTO userDTO){
        return authorizationService.registerUser(userDTO);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> logUser(@RequestBody @Valid LoginDTO loginDTO){
        return authorizationService.loginUser(loginDTO);
    }
}
