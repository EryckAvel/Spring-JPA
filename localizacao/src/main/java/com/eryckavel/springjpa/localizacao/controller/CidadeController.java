package com.eryckavel.springjpa.localizacao.controller;


import com.eryckavel.springjpa.localizacao.service.CidadeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    CidadeService service;


}
