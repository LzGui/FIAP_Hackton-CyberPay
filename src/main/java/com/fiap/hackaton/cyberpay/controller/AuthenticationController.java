package com.fiap.hackaton.cyberpay.controller;

import com.fiap.hackaton.cyberpay.dto.AuthRequest;
import com.fiap.hackaton.cyberpay.dto.AuthResponse;
import com.fiap.hackaton.cyberpay.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthenticationController {
   @Autowired
   private AuthenticationManager authenticationManager;

   @Autowired
   private ClienteRepository repository;

   @Autowired
   private TokenService tokenService;

   @PostMapping("/login")
   public ResponseEntity login(@RequestBody @Valid AuthRequest data){
      var usernamePassword = new UsernamePasswordAuthenticationToken(data.usuario(), data.senha());
      var auth = this.authenticationManager.authenticate(usernamePassword);

      var token = tokenService.generateToken((User) auth.getPrincipal());

      return ResponseEntity.ok(new AuthResponse(token));
   }

   @PostMapping("/register")
   public ResponseEntity register(@RequestBody @Valid AuthRequest data){
      if(this.repository.findByLogin(data.usuario()) != null) return ResponseEntity.badRequest().build();

      String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
      User newUser = new User(data.usuario(), encryptedPassword, data.role());

      this.repository.save(newUser);

      return ResponseEntity.ok().build();
   }
}
