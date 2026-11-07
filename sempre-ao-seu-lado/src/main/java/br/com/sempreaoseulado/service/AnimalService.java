
package br.com.sempreaoseulado.service;

import br.com.sempreaoseulado.entity.Animal;
import br.com.sempreaoseulado.exception.AnimalNaoEncontradoException;
import br.com.sempreaoseulado.repository.AnimalRepository;
import br.com.sempreaoseulado.request.AnimalRequest;
import br.com.sempreaoseulado.response.AnimalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<AnimalResponse> listarTodos() {
        return animalRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public AnimalResponse buscarPorId(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new AnimalNaoEncontradoException());

        return converterParaResponse(animal);
    }

    public AnimalResponse salvar(AnimalRequest request) {
        Animal animal = new Animal();

        animal.setNome(request.getNome());
        animal.setEspecie(request.getEspecie());
        animal.setSituacao(request.getSituacao());

        Animal animalSalvo = animalRepository.save(animal);

        return converterParaResponse(animalSalvo);
    }

    public AnimalResponse atualizar(Long id, AnimalRequest request) {
        Animal animalExistente = animalRepository.findById(id)
                .orElseThrow(AnimalNaoEncontradoException::new);

        animalExistente.setNome(request.getNome());
        animalExistente.setEspecie(request.getEspecie());
        animalExistente.setSituacao(request.getSituacao());

        Animal animalAtualizado = animalRepository.save(animalExistente);

        return converterParaResponse(animalAtualizado);
    }

    public void excluir(Long id) {
        Animal animalExistente = animalRepository.findById(id)
                .orElseThrow(AnimalNaoEncontradoException::new);

        animalRepository.delete(animalExistente);
    }

    private AnimalResponse converterParaResponse(Animal animal) {
        return new AnimalResponse(
                animal.getId(),
                animal.getNome(),
                animal.getEspecie(),
                animal.getSituacao()
        );
    }
}
