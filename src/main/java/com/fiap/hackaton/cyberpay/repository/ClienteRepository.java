package com.fiap.hackaton.cyberpay.repository;

import com.fiap.hackaton.cyberpay.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
   Optional<Cliente> findByCpf(String cpf);
   UserDetails findByLogin(String login);
}
