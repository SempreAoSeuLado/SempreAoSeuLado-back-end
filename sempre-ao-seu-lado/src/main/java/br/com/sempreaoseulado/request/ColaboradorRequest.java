
package br.com.sempreaoseulado.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ColaboradorRequest {

    @NotBlank(message = "O nome do colaborador é obrigatório")
    private String nome;

    @NotBlank(message = "O e-mail do colaborador é obrigatório")
    @Email(message = "Informe um e-mail válido")
    private String email;

    @NotBlank(message = "O perfil do colaborador é obrigatório")
    private String perfil;

    public ColaboradorRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
