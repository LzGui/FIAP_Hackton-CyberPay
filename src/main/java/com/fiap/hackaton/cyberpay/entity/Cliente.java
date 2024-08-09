package com.fiap.hackaton.cyberpay.entity;

import com.fiap.hackaton.cyberpay.entity.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Cliente {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String cpf;
   private String nome;
   private String email;
   private String telefone;
   private String endereco;
   private String login;
   private String password;
   private UserRole role;

   public Cliente(String login, String password, UserRole role){
      this.login = login;
      this.password = password;
      this.role = role;
   }

   public Cliente() {

   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      if(this.role == UserRole.ADMIN) return List.of(
              new SimpleGrantedAuthority("ROLE_ADMIN"),
              new SimpleGrantedAuthority("ROLE_USER"));
      else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
   }
}
