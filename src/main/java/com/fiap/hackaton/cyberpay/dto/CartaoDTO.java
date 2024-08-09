package com.fiap.hackaton.cyberpay.dto;

public record CartaoDTO(
        String cpf,
        double limite,
        String numero,
        String data_validade,
        String cvv) {
}
