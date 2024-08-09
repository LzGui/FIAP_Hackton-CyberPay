package com.fiap.hackaton.cyberpay.dto;

import com.fiap.hackaton.cyberpay.entity.enums.UserRole;

public record AuthRequest(String usuario, String senha, UserRole role) {
}
