package com.eryckavel.springjpa.localizacao.service;

import com.eryckavel.springjpa.localizacao.DTO.CidadeDTO;
import com.eryckavel.springjpa.localizacao.model.Cidade;
import com.eryckavel.springjpa.localizacao.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository repository;

    public ResponseEntity<List<CidadeDTO>> listar() {
        List<Cidade> entidade = repository.findAll();
        List<CidadeDTO> dto = entidade.stream().map(CidadeDTO::new).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    public ResponseEntity<List<CidadeDTO>> filtroDinamico(Cidade cidade) {
        Example<Cidade> example = Example.of(cidade);
        List<Cidade> entidade = repository.findAll(example);
        List<CidadeDTO> dto = entidade.stream().map(CidadeDTO::new).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    public ResponseEntity<List<CidadeDTO>> listarOrdenado(String order) {
        List<Cidade> entidade = repository.listarCidade(Sort.by(order));
        List<CidadeDTO> dto = entidade.stream().map(CidadeDTO::new).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    public ResponseEntity<List<CidadeDTO>> paginar() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<Cidade> entidade = repository.paginarCidade(pageable);
        List<CidadeDTO> dto = entidade.stream().map(CidadeDTO::new).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    public ResponseEntity<CidadeDTO> salvar(CidadeDTO dto) {
        var cidade = new Cidade();
        copiarDTOparaEntidade(cidade, dto);
        cidade = repository.save(cidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CidadeDTO(cidade));
    }

    public ResponseEntity<CidadeDTO> buscar(String nome) {
        try {
            Cidade cidade = repository.buscarNomeCidade(nome).orElseThrow();
            var dto = new CidadeDTO(cidade);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrada!");
        }
    }

    public ResponseEntity<CidadeDTO> buscaNativa(String nome) {
        try {
            Cidade cidade = repository.buscarCidadeNomeNativo(nome).orElseThrow();
            var dto = new CidadeDTO(cidade);
            return ResponseEntity.status(HttpStatus.OK).body(dto);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrada!");
        }
    }

    public void copiarDTOparaEntidade(Cidade entidade, CidadeDTO dto){
        entidade.setNome(dto.getNome());
        entidade.setHabitantes(dto.getHabitantes());
    }


}
