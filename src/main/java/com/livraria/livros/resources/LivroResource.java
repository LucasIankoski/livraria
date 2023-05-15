package com.livraria.livros.resources;

import com.livraria.livros.entities.Livro;
import com.livraria.livros.entities.enums.Autor;
import com.livraria.livros.entities.enums.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping(value = "/livros")
@RestController
public class LivroResource {
    @GetMapping
    public ResponseEntity<Livro> findAll(){
        Livro livro = new Livro(1L, "Harry Potter e a Pedra Filosofal", "9780606323451", Categoria.FANTASIA, Autor.JK_ROWLING);
        return ResponseEntity.ok().body(livro);
    }
}
