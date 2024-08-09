package com.fiap.hackaton.cyberpay.service;

import com.fiap.hackaton.cyberpay.dto.CartaoDTO;
import com.fiap.hackaton.cyberpay.entity.Cartao;
import com.fiap.hackaton.cyberpay.repository.CartaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CartaoService {

   private final CartaoRepository cartaoRepository;

   public CartaoService(CartaoRepository cartaoRepository) {
      this.cartaoRepository = cartaoRepository;
   }

   public Cartao gerarCartao(CartaoDTO cartaoDTO) {
      List<Cartao> cartoes = cartaoRepository.findByCpf(cartaoDTO.cpf());
      if (cartoes.size() >= 2) {
         throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Número máximo de cartões atingido");
      }
      Cartao cartao = new Cartao();
      cartao.setCpf(cartaoDTO.cpf());
      cartao.setNumero(cartaoDTO.numero());
      cartao.setLimite(cartaoDTO.limite());
      cartao.setSaldoDisponivel(cartaoDTO.limite());
      cartao.setDataValidade(cartaoDTO.data_validade());
      cartao.setCvv(cartaoDTO.cvv());
      return cartaoRepository.save(cartao);
   }
}
