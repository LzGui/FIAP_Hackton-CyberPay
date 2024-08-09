package com.fiap.hackaton.cyberpay.service;

import com.fiap.hackaton.cyberpay.dto.PagamentoDTO;
import com.fiap.hackaton.cyberpay.entity.Cartao;
import com.fiap.hackaton.cyberpay.entity.Pagamento;
import com.fiap.hackaton.cyberpay.repository.CartaoRepository;
import com.fiap.hackaton.cyberpay.repository.PagamentoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PagamentoService {

   private final CartaoRepository cartaoRepository;
   private final PagamentoRepository pagamentoRepository;

   public PagamentoService(CartaoRepository cartaoRepository, PagamentoRepository pagamentoRepository) {
      this.cartaoRepository = cartaoRepository;
      this.pagamentoRepository = pagamentoRepository;
   }

   public Pagamento processarPagamento(PagamentoDTO pagamentoDTO) {
      Cartao cartao = (Cartao) cartaoRepository.findByCpfAndNumero(pagamentoDTO.cpf(), pagamentoDTO.numero())
              .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado"));

      if (!cartao.getDataValidade().equals(pagamentoDTO.data_validade()) || !cartao.getCvv().equals(pagamentoDTO.cvv())) {
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados do cartão inválidos");
      }

      if (cartao.getSaldoDisponivel() < pagamentoDTO.valor()) {
         throw new ResponseStatusException(HttpStatus.PAYMENT_REQUIRED, "Limite do cartão excedido");
      }

      cartao.setSaldoDisponivel(cartao.getSaldoDisponivel() - pagamentoDTO.valor());
      cartaoRepository.save(cartao);

      Pagamento pagamento = new Pagamento();
      pagamento.setCpf(pagamentoDTO.cpf());
      pagamento.setNumeroCartao(pagamentoDTO.numero());
      pagamento.setValor(pagamentoDTO.valor());
      pagamento.setStatus("aprovado");

      return pagamentoRepository.save(pagamento);
   }
}
