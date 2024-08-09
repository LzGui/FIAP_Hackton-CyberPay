package com.fiap.hackaton.cyberpay.repository;

import com.fiap.hackaton.cyberpay.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
   List<Pagamento> findByCpf(String cpf);
}
