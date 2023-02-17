package com.eryckavel.springjpa.localizacao.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.print.attribute.standard.MediaSize;
import java.util.Objects;

@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @Column(name = "id_cidade")
    private Long id;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "qtd_habitantes")
    private Long habitantes;

    public Cidade() {
    }

    public Cidade(Long id, String nome, Long habitantes) {
        this.id = id;
        this.nome = nome;
        this.habitantes = habitantes;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id) && Objects.equals(nome, cidade.nome) && Objects.equals(habitantes, cidade.habitantes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, habitantes);
    }
}
