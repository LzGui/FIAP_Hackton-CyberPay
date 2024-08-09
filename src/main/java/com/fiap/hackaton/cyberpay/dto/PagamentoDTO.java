package com.fiap.hackaton.cyberpay.dto;

public record PagamentoDTO(
        String cpf,
        String numero,
        String data_validade,
        String cvv,
        double valor) {
}
