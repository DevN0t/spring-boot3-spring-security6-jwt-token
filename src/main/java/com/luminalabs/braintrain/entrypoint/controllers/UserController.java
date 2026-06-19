package com.luminalabs.braintrain.entrypoint.controllers;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.luminalabs.braintrain.domain.entity.user.User;
import com.luminalabs.braintrain.entrypoint.dto.LoginDTO;
import com.luminalabs.braintrain.entrypoint.dto.LoginResponseDTO;
import com.luminalabs.braintrain.entrypoint.dto.UserDTO;
import com.luminalabs.braintrain.entrypoint.dto.UserListDTO;
import com.luminalabs.braintrain.services.authorization.AuthorizationService;
import com.luminalabs.braintrain.services.restservices.UserService;

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
    public List<UserListDTO> getAllUsers(){
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
