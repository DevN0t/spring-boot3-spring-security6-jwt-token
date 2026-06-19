package com.luminalabs.braintrain.entrypoint.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(

        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
