package com.luminalabs.braintrain.entrypoint.dto;

import com.luminalabs.braintrain.domain.entity.user.role.RoleEnum;

public record UserListDTO(
        Integer id,
        String name,
        String login
) {
}
