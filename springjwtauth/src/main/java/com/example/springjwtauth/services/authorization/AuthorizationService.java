package com.example.springjwtauth.services.authorization;

import com.example.springjwtauth.domain.entity.user.User;
import com.example.springjwtauth.domain.entity.user.role.RoleEnum;
import com.example.springjwtauth.entrypoint.dto.LoginDTO;
import com.example.springjwtauth.entrypoint.dto.LoginResponseDTO;
import com.example.springjwtauth.entrypoint.dto.UserDTO;
import com.example.springjwtauth.infra.security.TokenService;
import com.example.springjwtauth.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;




@Service
public class AuthorizationService implements UserDetailsService{


    private TokenService tokenService;
    private final ApplicationContext context;
    private UserRepository userRepository;

    public AuthorizationService(TokenService tokenService, ApplicationContext context, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.context = context;
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody @Valid LoginDTO data){
        AuthenticationManager authenticationManager = context.getBean(AuthenticationManager.class);
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = this.tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserDTO data){
            if (!data.password().equals(data.confirmPassword())) {
            return ResponseEntity.badRequest().build();}
        if(this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        String encriptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User();
        newUser.setName(data.name());
        newUser.setLogin(data.login());
        newUser.setPassword(encriptedPassword);
        newUser.setRole(RoleEnum.USER);
        this.userRepository.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

