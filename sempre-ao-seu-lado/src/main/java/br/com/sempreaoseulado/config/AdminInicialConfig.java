
package br.com.sempreaoseulado.config;

import br.com.sempreaoseulado.entity.Colaborador;
import br.com.sempreaoseulado.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInicialConfig {

    @Value("${app.admin.email}")
    private String email;

    @Value("${app.admin.password}")
    private String senha;

    @Bean
    public CommandLineRunner criarAdminInicial(
            ColaboradorRepository colaboradorRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {
            String emailNormalizado = email.trim().toLowerCase();

            if (!colaboradorRepository.existsByEmail(emailNormalizado)) {
                Colaborador admin = new Colaborador();

                admin.setNome("Administrador");
                admin.setEmail(emailNormalizado);
                admin.setSenha(passwordEncoder.encode(senha));
                admin.setPerfil("ADMINISTRADOR");
                admin.setAtivo(true);

                colaboradorRepository.save(admin);
            }
        };
    }
}
