package com.luminalabs.braintrain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.luminalabs.braintrain.domain.entity.user.User;
import com.luminalabs.braintrain.entrypoint.dto.UserListDTO;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    UserDetails findByLogin(String login);

    @Query("SELECT new com.luminalabs.braintrain.entrypoint.dto.UserListDTO(users.id, users.name, users.login) from User users")
    List<UserListDTO> findUsers();
}
