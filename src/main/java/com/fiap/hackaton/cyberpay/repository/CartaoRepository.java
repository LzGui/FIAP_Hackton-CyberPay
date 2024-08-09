package com.fiap.hackaton.cyberpay.repository;

import com.fiap.hackaton.cyberpay.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
   List<Cartao> findByCpf(String cpf);
   Optional<Cartao> findByCpfAndNumero(String cpf, String numero);
}
