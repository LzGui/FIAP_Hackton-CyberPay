package com.fiap.hackaton.cyberpay.service;

import com.fiap.hackaton.cyberpay.repository.ClienteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthorizationService implements UserDetailsService {

   private ClienteRepository repository;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return repository.findByLogin(username);
   }
}
