package br.com.sempreaoseulado.service;

import br.com.sempreaoseulado.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorDetailsService implements UserDetailsService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        var colaborador = colaboradorRepository
                .findByEmailAndAtivoTrue(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Colaborador não encontrado ou inativo"
                ));

        return org.springframework.security.core.userdetails.User
                .withUsername(colaborador.getEmail())
                .password(colaborador.getSenha())
                .roles(colaborador.getPerfil())
                .build();
    }
}
