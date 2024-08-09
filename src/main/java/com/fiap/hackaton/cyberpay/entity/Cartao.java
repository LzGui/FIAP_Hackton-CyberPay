package com.fiap.hackaton.cyberpay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
public class Cartao {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String cpf;
   private String numero;
   private double limite;
   private double saldoDisponivel;
   private String dataValidade;
   private String cvv;
}