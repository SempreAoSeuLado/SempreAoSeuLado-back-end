
package br.com.sempreaoseulado.service;

import br.com.sempreaoseulado.entity.Colaborador;
import br.com.sempreaoseulado.exception.ColaboradorNaoEncontradoException;
import br.com.sempreaoseulado.exception.EmailDuplicadoException;
import br.com.sempreaoseulado.repository.ColaboradorRepository;
import br.com.sempreaoseulado.request.ColaboradorRequest;
import br.com.sempreaoseulado.response.ColaboradorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public ColaboradorResponse salvar(ColaboradorRequest request) {

        String emailNormalizado = request.getEmail()
                .trim()
                .toLowerCase();

        if (colaboradorRepository.existsByEmail(emailNormalizado)) {
            throw new EmailDuplicadoException();
        }

        Colaborador colaborador = new Colaborador();

        colaborador.setNome(request.getNome());
        colaborador.setEmail(emailNormalizado);
        colaborador.setPerfil(request.getPerfil());

        Colaborador colaboradorSalvo = colaboradorRepository.save(colaborador);

        return converterParaResponse(colaboradorSalvo);
    }

    public List<ColaboradorResponse> listarTodos() {
        return colaboradorRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public ColaboradorResponse buscarPorId(Long id) {
        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() -> new ColaboradorNaoEncontradoException());

        return converterParaResponse(colaborador);
    }

    public ColaboradorResponse atualizar(Long id, ColaboradorRequest request) {

        Colaborador colaboradorExistente = colaboradorRepository.findById(id)
                .orElseThrow(ColaboradorNaoEncontradoException::new);

        String emailNormalizado = request.getEmail()
                .trim()
                .toLowerCase();

        if (!colaboradorExistente.getEmail().equals(emailNormalizado)
                && colaboradorRepository.existsByEmail(emailNormalizado)) {
            throw new EmailDuplicadoException();
        }

        colaboradorExistente.setNome(request.getNome());
        colaboradorExistente.setEmail(emailNormalizado);
        colaboradorExistente.setPerfil(request.getPerfil());

        Colaborador colaboradorAtualizado =
                colaboradorRepository.save(colaboradorExistente);

        return converterParaResponse(colaboradorAtualizado);
    }

    public void desativar(Long id) {

        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(ColaboradorNaoEncontradoException::new);

        colaborador.setAtivo(false);

        colaboradorRepository.save(colaborador);
    }

    public List<ColaboradorResponse> listarAtivos() {
        return colaboradorRepository.findByAtivoTrue()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    private ColaboradorResponse converterParaResponse(Colaborador colaborador) {
        return new ColaboradorResponse(
                colaborador.getId(),
                colaborador.getNome(),
                colaborador.getEmail(),
                colaborador.getPerfil(),
                colaborador.isAtivo()
        );
    }
}
