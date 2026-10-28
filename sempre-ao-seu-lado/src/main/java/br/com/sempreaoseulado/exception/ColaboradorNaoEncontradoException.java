package br.com.sempreaoseulado.exception;

public class ColaboradorNaoEncontradoException extends RuntimeException {

    public ColaboradorNaoEncontradoException() {
        super("Colaborador não encontrado");
    }
}