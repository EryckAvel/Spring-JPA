package com.eryckavel.springjpa.localizacao.repository;

import com.eryckavel.springjpa.localizacao.DTO.CidadeDTO;
import com.eryckavel.springjpa.localizacao.model.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("SELECT c FROM Cidade c WHERE c.nome=:nome")
    Optional<Cidade> buscarNomeCidade(String nome);

    @Query("SELECT c FROM Cidade c")
    List<Cidade> listarCidade(Sort sort);

    @Query("SELECT c FROM Cidade c")
    Page<Cidade> paginarCidade(Pageable pageable);


}