package br.com.sempreaoseulado.response;

public class AnimalResponse {

    private Long id;
    private String nome;
    private String especie;
    private String situacao;

    public AnimalResponse() {
    }

    public AnimalResponse(Long id, String nome, String especie, String situacao) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.situacao = situacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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