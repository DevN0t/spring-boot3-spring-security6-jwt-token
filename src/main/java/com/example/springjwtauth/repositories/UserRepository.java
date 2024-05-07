package com.example.springjwtauth.repositories;

import com.example.springjwtauth.domain.entity.user.User;
import com.example.springjwtauth.entrypoint.dto.UserListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    UserDetails findByLogin(String login);

    @Query("SELECT new com.example.springjwtauth.entrypoint.dto.UserListDTO(users.id, users.name, users.login) from User users")
    List<UserListDTO> findUsers();
}
