package com.livraria.livros.resources;

import com.livraria.livros.entities.Livro;
import com.livraria.livros.entities.enums.Autor;
import com.livraria.livros.entities.enums.Categoria;
import com.livraria.livros.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/livros")
@RestController
public class LivroResource {

    @Autowired
    private LivroService livroService;
    @GetMapping
    public ResponseEntity<List<Livro>> findAll(){
        List<Livro> listaLivros = livroService.getTodosLivros();
        return ResponseEntity.ok().body(listaLivros);
    }
}