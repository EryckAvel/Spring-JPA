package com.eryckavel.springjpa.localizacao.controller;


import com.eryckavel.springjpa.localizacao.DTO.CidadeDTO;
import com.eryckavel.springjpa.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    CidadeService service;

    @PostMapping
    public ResponseEntity<CidadeDTO> salvarCidade(@RequestBody CidadeDTO dto){
        return service.salvar(dto);
    }


}
