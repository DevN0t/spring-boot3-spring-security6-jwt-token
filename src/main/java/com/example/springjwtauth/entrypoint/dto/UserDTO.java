package com.example.springjwtauth.entrypoint.dto;

import jakarta.validation.constraints.NotBlank;


public record UserDTO(

        @NotBlank
        String name,
        @NotBlank
        String login,
        @NotBlank
        String password,
        @NotBlank
        String confirmPassword
) {
}
