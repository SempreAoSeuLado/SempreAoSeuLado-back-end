package br.com.sempreaoseulado.exception;

public class EmailDuplicadoException extends RuntimeException {

    public EmailDuplicadoException() {
        super("Já existe um colaborador cadastrado com este e-mail");
    }
}