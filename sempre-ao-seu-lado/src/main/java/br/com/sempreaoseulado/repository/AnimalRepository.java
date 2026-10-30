
package br.com.sempreaoseulado.repository;

import br.com.sempreaoseulado.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
