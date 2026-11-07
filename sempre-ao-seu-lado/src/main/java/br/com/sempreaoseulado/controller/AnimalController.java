
package br.com.sempreaoseulado.controller;

import br.com.sempreaoseulado.request.AnimalRequest;
import br.com.sempreaoseulado.response.AnimalResponse;
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
    public List<AnimalResponse> listarTodos() {
        return animalService.listarTodos();
    }

    @GetMapping("/{id}")
    public AnimalResponse buscarPorId(@PathVariable Long id) {
        return animalService.buscarPorId(id);
    }

    @PostMapping
    public AnimalResponse salvar(@Valid @RequestBody AnimalRequest request) {
        return animalService.salvar(request);
    }

    @PutMapping("/{id}")
    public AnimalResponse atualizar(
            @PathVariable Long id,
            @Valid @RequestBody AnimalRequest request) {

        return animalService.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        animalService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
