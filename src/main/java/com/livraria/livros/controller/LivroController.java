package com.livraria.livros.controller;

import com.livraria.livros.entities.Livro;
import com.livraria.livros.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping(value = "/livros")
@RestController
public class LivroController {

    @Autowired
    private LivroService livroService;
    @GetMapping
    public ResponseEntity<List<Livro>> findAll(){
        List<Livro> listaLivros = livroService.getTodosLivros();
        return ResponseEntity.ok().body(listaLivros);
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro obj){
        obj = livroService.cadastrarLivro(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody Livro obj){
        obj = livroService.atualizarLivro(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}