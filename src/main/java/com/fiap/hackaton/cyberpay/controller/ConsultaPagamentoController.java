package com.fiap.hackaton.cyberpay.controller;

import com.fiap.hackaton.cyberpay.entity.Pagamento;
import com.fiap.hackaton.cyberpay.repository.PagamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos/cliente")
public class ConsultaPagamentoController {

   private final PagamentoRepository pagamentoRepository;

   public ConsultaPagamentoController(PagamentoRepository pagamentoRepository) {
      this.pagamentoRepository = pagamentoRepository;
   }

   @GetMapping("/{idPagamento}")
   public ResponseEntity<List<Pagamento>> listarPagamentos(@PathVariable String idPagamento) {
      List<Pagamento> pagamentos = pagamentoRepository.findByCpf(idPagamento);
      return ResponseEntity.ok(pagamentos);
   }
}
