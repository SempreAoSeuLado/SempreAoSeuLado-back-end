
package br.com.sempreaoseulado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AnimalNaoEncontradoException.class)
    public ResponseEntity<String> tratarAnimalNaoEncontrado(
            AnimalNaoEncontradoException exception) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> tratarErroValidacao(
            MethodArgumentNotValidException exception) {

        List<String> mensagens = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> erro.getDefaultMessage())
                .toList();

        Map<String, Object> corpo = Map.of(
                "erro", "Erro de validação",
                "mensagens", mensagens
        );

        return ResponseEntity.badRequest().body(corpo);
    }

    @ExceptionHandler(EmailDuplicadoException.class)
    public ResponseEntity<String> tratarEmailDuplicado(
            EmailDuplicadoException exception) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exception.getMessage());
    }

    @ExceptionHandler(ColaboradorNaoEncontradoException.class)
    public ResponseEntity<String> tratarColaboradorNaoEncontrado(
            ColaboradorNaoEncontradoException exception) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

}


