package com.eryckavel.springjpa.localizacao.service;

import com.eryckavel.springjpa.localizacao.DTO.CidadeDTO;
import com.eryckavel.springjpa.localizacao.model.Cidade;
import com.eryckavel.springjpa.localizacao.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository repository;

    public ResponseEntity<CidadeDTO> salvar(CidadeDTO dto) {
        var cidade = new Cidade();
        copiarDTOparaEntidade(cidade, dto);
        cidade = repository.save(cidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CidadeDTO(cidade));
    }

    public void copiarDTOparaEntidade(Cidade entidade, CidadeDTO dto){
        entidade.setNome(dto.getNome());
        entidade.setHabitantes(dto.getHabitantes());
    }

}
