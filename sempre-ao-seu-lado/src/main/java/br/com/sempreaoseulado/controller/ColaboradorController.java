
package br.com.sempreaoseulado.controller;

import br.com.sempreaoseulado.request.ColaboradorRequest;
import br.com.sempreaoseulado.response.ColaboradorResponse;
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
    public ColaboradorResponse salvar(
            @Valid @RequestBody ColaboradorRequest request) {
        return colaboradorService.salvar(request);
    }

    @GetMapping
    public List<ColaboradorResponse> listarTodos() {
        return colaboradorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ColaboradorResponse buscarPorId(@PathVariable Long id) {
        return colaboradorService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ColaboradorResponse atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ColaboradorRequest request) {

        return colaboradorService.atualizar(id, request);
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<Void> desativar(@PathVariable Long id) {
        colaboradorService.desativar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ativos")
    public List<ColaboradorResponse> listarAtivos() {
        return colaboradorService.listarAtivos();
    }
}
