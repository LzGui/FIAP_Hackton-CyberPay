package com.fiap.hackaton.cyberpay.dto;

public record ClienteDTO(
        String cpf,
        String nome,
        String email,
        String telefone,
        String rua,
        String cidade,
        String estado,
        String cep,
        String pais) {
}
