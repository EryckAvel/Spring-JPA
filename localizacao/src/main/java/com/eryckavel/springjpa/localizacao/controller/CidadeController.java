package com.eryckavel.springjpa.localizacao.controller;


import com.eryckavel.springjpa.localizacao.DTO.CidadeDTO;
import com.eryckavel.springjpa.localizacao.model.Cidade;
import com.eryckavel.springjpa.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    CidadeService service;

    @GetMapping
    public ResponseEntity<List<CidadeDTO>> listarCidades(){
        return service.listar();
    }

    @GetMapping("/paginacao")
    public ResponseEntity<List<CidadeDTO>> paginarCidades(){
        return service.paginar();
    }

    @GetMapping("ordernada/{order}")
    public ResponseEntity<List<CidadeDTO>> listarCidadesOrdenadas(@PathVariable("order") String order){
        return service.listarOrdenado(order);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<CidadeDTO> buscarCidadePorNome(@PathVariable("nome") String nome){
        return service.buscar(nome);
    }

    @GetMapping("/dinamic")
    public ResponseEntity<List<CidadeDTO>> listarFiltroDinamico(){
        var cidade = new Cidade(null, null, 300000L);
        return service.filtroDinamico(cidade);
    }

    @PostMapping
    public ResponseEntity<CidadeDTO> salvarCidade(@RequestBody CidadeDTO dto){
        return service.salvar(dto);
    }


}
