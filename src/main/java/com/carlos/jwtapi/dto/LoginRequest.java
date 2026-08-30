package com.carlos.jwtapi.dto;

public record LoginRequest(
       String login,
       String senha
) {
}
