package com.example.springjwtauth.entrypoint.dto;

import com.example.springjwtauth.domain.entity.user.role.RoleEnum;

public record UserListDTO(
        Integer id,
        String name,
        String login
) {
}
