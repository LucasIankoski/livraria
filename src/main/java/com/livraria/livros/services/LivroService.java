package com.livraria.livros.services;

import com.livraria.livros.entities.Livro;
import com.livraria.livros.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getTodosLivros(){
        return livroRepository.findAll();
    }
}
