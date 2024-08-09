package com.fiap.hackaton.cyberpay.controller;

import com.fiap.hackaton.cyberpay.dto.PagamentoDTO;
import com.fiap.hackaton.cyberpay.entity.Pagamento;
import com.fiap.hackaton.cyberpay.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

   private final PagamentoService pagamentoService;

   public PagamentoController(PagamentoService pagamentoService) {
      this.pagamentoService = pagamentoService;
   }

   @PostMapping
   public ResponseEntity<Map<String, String>> processarPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
      Pagamento pagamento = pagamentoService.processarPagamento(pagamentoDTO);
      return ResponseEntity.ok(Map.of("chave_pagamento", pagamento.getId()));
   }
}
