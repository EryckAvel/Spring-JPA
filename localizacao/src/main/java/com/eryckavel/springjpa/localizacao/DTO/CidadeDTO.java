package com.eryckavel.springjpa.localizacao.DTO;

import com.eryckavel.springjpa.localizacao.model.Cidade;

public class CidadeDTO {

    private Long id;
    private String nome;
    private Long habitantes;

    public CidadeDTO() {
    }

    public CidadeDTO(Cidade cidade) {
        id = cidade.getId();
        nome = cidade.getNome();
        habitantes = cidade.getHabitantes();
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

    public Long getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(Long habitantes) {
        this.habitantes = habitantes;
    }
}
