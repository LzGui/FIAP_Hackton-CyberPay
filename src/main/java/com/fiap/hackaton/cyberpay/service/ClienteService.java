package com.fiap.hackaton.cyberpay.service;

import com.fiap.hackaton.cyberpay.dto.ClienteDTO;
import com.fiap.hackaton.cyberpay.entity.Cliente;
import com.fiap.hackaton.cyberpay.repository.ClienteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

   private final ClienteRepository clienteRepository;

   public ClienteService(ClienteRepository clienteRepository) {
      this.clienteRepository = clienteRepository;
   }

   public Cliente registerCliente(ClienteDTO clienteDTO) {
      Cliente cliente = new Cliente();
      cliente.setCpf(clienteDTO.cpf());
      cliente.setNome(clienteDTO.nome());
      cliente.setEmail(clienteDTO.email());
      cliente.setTelefone(clienteDTO.telefone());
      cliente.setEndereco(clienteDTO.rua() + ", "
              + clienteDTO.cidade() + ", "
              + clienteDTO.estado() + ", "
              + clienteDTO.cep() + ", "
              + clienteDTO.pais());

      return clienteRepository.save(cliente);
   }
}
