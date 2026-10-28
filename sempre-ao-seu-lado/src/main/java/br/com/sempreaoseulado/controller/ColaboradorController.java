
package br.com.sempreaoseulado.controller;

import br.com.sempreaoseulado.entity.Colaborador;
import br.com.sempreaoseulado.service.ColaboradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping
    public Colaborador salvar(@Valid @RequestBody Colaborador colaborador) {
        return colaboradorService.salvar(colaborador);
    }

    @GetMapping
    public List<Colaborador> listarTodos() {
        return colaboradorService.listarTodos();
    }

    @PutMapping("/{id}")
    public Colaborador atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Colaborador colaborador) {

        return colaboradorService.atualizar(id, colaborador);
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<Void> desativar(@PathVariable Long id) {
        colaboradorService.desativar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ativos")
    public List<Colaborador> listarAtivos() {
        return colaboradorService.listarAtivos();
    }

}
