package br.com.sempreaoseulado.exception;

public class AnimalNaoEncontradoException extends RuntimeException {

    public AnimalNaoEncontradoException() {
        super("Animal não encontrado");
    }
}
