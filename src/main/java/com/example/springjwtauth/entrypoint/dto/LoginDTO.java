package com.example.springjwtauth.entrypoint.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(

        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
