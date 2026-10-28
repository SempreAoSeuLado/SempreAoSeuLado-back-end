
package br.com.sempreaoseulado.service;

import br.com.sempreaoseulado.entity.Colaborador;
import br.com.sempreaoseulado.exception.ColaboradorNaoEncontradoException;
import br.com.sempreaoseulado.exception.EmailDuplicadoException;
import br.com.sempreaoseulado.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;


    public Colaborador salvar(Colaborador colaborador) {
        String emailNormalizado = colaborador.getEmail()
                .trim()
                .toLowerCase();

        colaborador.setEmail(emailNormalizado);

        if (colaboradorRepository.existsByEmail(emailNormalizado)) {
            throw new EmailDuplicadoException();
        }

        return colaboradorRepository.save(colaborador);
    }


    public List<Colaborador> listarTodos() {
        return colaboradorRepository.findAll();
    }

    public Colaborador atualizar(Long id, Colaborador colaboradorAtualizado) {

        Colaborador colaboradorExistente = colaboradorRepository.findById(id)
                .orElseThrow(ColaboradorNaoEncontradoException::new);

        String emailNormalizado = colaboradorAtualizado.getEmail()
                .trim()
                .toLowerCase();

        if (!colaboradorExistente.getEmail().equals(emailNormalizado)
                && colaboradorRepository.existsByEmail(emailNormalizado)) {
            throw new EmailDuplicadoException();
        }

        colaboradorExistente.setNome(colaboradorAtualizado.getNome());
        colaboradorExistente.setEmail(emailNormalizado);
        colaboradorExistente.setPerfil(colaboradorAtualizado.getPerfil());
        colaboradorExistente.setAtivo(colaboradorAtualizado.isAtivo());

        return colaboradorRepository.save(colaboradorExistente);
    }


    public void desativar(Long id) {

        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(ColaboradorNaoEncontradoException::new);

        colaborador.setAtivo(false);

        colaboradorRepository.save(colaborador);
    }

    public List<Colaborador> listarAtivos() {
        return colaboradorRepository.findByAtivoTrue();
    }


}
