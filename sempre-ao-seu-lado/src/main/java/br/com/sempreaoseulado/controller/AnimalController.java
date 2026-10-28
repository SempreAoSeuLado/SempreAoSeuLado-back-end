
package br.com.sempreaoseulado.controller;

import br.com.sempreaoseulado.entity.Animal;
import br.com.sempreaoseulado.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

//    @GetMapping
//    public List<Animal> listarTodos() {
//        return animalService.listarTodos();
//    }

    @GetMapping
    public Page<Animal> listarTodos(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho) {

        if (pagina < 0) {
            throw new IllegalArgumentException(
                    "O número da página não pode ser negativo"
            );
        }

        if (tamanho < 1 || tamanho > 100) {
            throw new IllegalArgumentException(
                    "O tamanho da página deve estar entre 1 e 100"
            );
        }

        return animalService.listarPaginado(pagina, tamanho);
    }


    @GetMapping("/pagina")
    public Page<Animal> listarPaginado(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho) {

        if (pagina < 0) {
            throw new IllegalArgumentException(
                    "O número da página não pode ser negativo"
            );
        }

        if (tamanho < 1 || tamanho > 100) {
            throw new IllegalArgumentException(
                    "O tamanho da página deve estar entre 1 e 100"
            );
        }

        return animalService.listarPaginado(pagina, tamanho);
    }

    @PostMapping
    public Animal salvar(@Valid @RequestBody Animal animal) {
        return animalService.salvar(animal);
    }

    @PutMapping("/{id}")
    public Animal atualizar(@PathVariable Long id, @Valid @RequestBody Animal animal) {
        return animalService.atualizar(id, animal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        animalService.excluir(id);
        return ResponseEntity.noContent().build();
    }


}
