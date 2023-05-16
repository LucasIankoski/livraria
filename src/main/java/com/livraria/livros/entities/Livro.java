package com.livraria.livros.entities;

import com.livraria.livros.entities.enums.Autor;
import com.livraria.livros.entities.enums.Categoria;
import com.sun.istack.NotNull;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "livro")
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nomeLivro;
    @NotBlank
    private String isbn;
    @NotNull
    private Integer categoria;
    @NotNull
    private Integer autor;

    public Livro(){

    }
    public Livro(Long id, String nomeLivro, String isbn, Categoria categoria, Autor autor) {
        this.id = id;
        this.nomeLivro = nomeLivro;
        this.isbn = isbn;
        setCategoria(categoria);
        setAutor(autor);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Categoria getCategoria() {
        return Categoria.valueof(categoria);
    }

    public void setCategoria(Categoria categoria) {
        if(categoria != null){
            this.categoria = categoria.getCodigo();
        }
    }

    public Autor getAutor() {
        return Autor.valueOf(autor);
    }

    public void setAutor(Autor autor) {
        if(autor != null){
            this.autor = autor.getCodigo();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
