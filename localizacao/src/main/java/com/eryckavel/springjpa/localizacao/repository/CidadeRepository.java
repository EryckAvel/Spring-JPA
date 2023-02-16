package com.eryckavel.springjpa.localizacao.repository;

import com.eryckavel.springjpa.localizacao.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}