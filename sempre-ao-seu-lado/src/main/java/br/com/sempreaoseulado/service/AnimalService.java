
package br.com.sempreaoseulado.service;

import br.com.sempreaoseulado.entity.Animal;
import br.com.sempreaoseulado.exception.AnimalNaoEncontradoException;
import br.com.sempreaoseulado.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }


    public Page<Animal> listarPaginado(int pagina, int tamanho) {
        Pageable pageable = PageRequest.of(
                pagina,
                tamanho,
                Sort.by("id").ascending()
        );

        return animalRepository.findAll(pageable);
    }


    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal atualizar(Long id, Animal animalAtualizado) {
        Animal animalExistente = animalRepository.findById(id)
                .orElseThrow(AnimalNaoEncontradoException::new);

        animalExistente.setNome(animalAtualizado.getNome());
        animalExistente.setEspecie(animalAtualizado.getEspecie());
        animalExistente.setSituacao(animalAtualizado.getSituacao());

        return animalRepository.save(animalExistente);
    }


    public void excluir(Long id) {
        Animal animalExistente = animalRepository.findById(id)
                .orElseThrow(AnimalNaoEncontradoException::new);

        animalRepository.delete(animalExistente);
    }

}
