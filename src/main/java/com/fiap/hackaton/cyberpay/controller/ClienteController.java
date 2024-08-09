package com.fiap.hackaton.cyberpay.controller;

import com.fiap.hackaton.cyberpay.dto.ClienteDTO;
import com.fiap.hackaton.cyberpay.entity.Cliente;
import com.fiap.hackaton.cyberpay.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

   private final ClienteService clienteService;

   public ClienteController(ClienteService clienteService) {
      this.clienteService = clienteService;
   }

   @PostMapping
   public ResponseEntity<Map<String, String>> registerCliente(@RequestBody ClienteDTO clienteDTO) {
      Cliente cliente = clienteService.registerCliente(clienteDTO);
      return ResponseEntity.ok(Map.of("id_cliente", cliente.getId()));
   }
}