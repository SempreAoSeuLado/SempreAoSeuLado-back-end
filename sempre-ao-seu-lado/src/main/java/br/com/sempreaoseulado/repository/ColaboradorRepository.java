
package br.com.sempreaoseulado.repository;

import br.com.sempreaoseulado.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    boolean existsByEmail(String email);
    List<Colaborador> findByAtivoTrue();
}
