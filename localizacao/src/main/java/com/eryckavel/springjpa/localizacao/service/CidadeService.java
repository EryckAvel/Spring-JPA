package com.eryckavel.springjpa.localizacao.service;

import com.eryckavel.springjpa.localizacao.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository repository;

}
