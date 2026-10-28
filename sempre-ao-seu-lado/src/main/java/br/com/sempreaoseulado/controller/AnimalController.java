
package br.com.sempreaoseulado.controller;

import br.com.sempreaoseulado.entity.Animal;
import br.com.sempreaoseulado.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> listarTodos() {
        return animalService.listarTodos();
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
