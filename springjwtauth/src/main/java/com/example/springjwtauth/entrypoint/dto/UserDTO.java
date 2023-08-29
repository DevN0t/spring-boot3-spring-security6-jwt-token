package com.example.springjwtauth.entrypoint.dto;

import com.example.springjwtauth.domain.entity.user.role.RoleEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record UserDTO(
        @NotBlank
        String login,
        @NotBlank
        String password,
        @NotNull
        @Enumerated
        RoleEnum role
) {
}
