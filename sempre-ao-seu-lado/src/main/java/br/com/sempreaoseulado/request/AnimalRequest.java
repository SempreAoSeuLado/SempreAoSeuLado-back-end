
package br.com.sempreaoseulado.request;

import jakarta.validation.constraints.NotBlank;

public class AnimalRequest {

    @NotBlank(message = "O nome do animal é obrigatório")
    private String nome;

    @NotBlank(message = "A espécie do animal é obrigatória")
    private String especie;

    @NotBlank(message = "A situação do animal é obrigatória")
    private String situacao;

    public AnimalRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
