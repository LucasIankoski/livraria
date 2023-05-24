package com.livraria.livros.entities;

import com.livraria.livros.entities.enums.Autor;
import com.livraria.livros.entities.enums.Categoria;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;


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
    @Getter
    private Long id;

    @NotBlank
    @Getter
    @Setter
    private String nomeLivro;

    @NotBlank
    @Getter
    @Setter
    private String isbn;

    @NotNull
    @Getter
    @Setter
    private Categoria categoria;

    @NotNull
    @Getter
    @Setter
    private Autor autor;

    public Livro(){

    }
    public Livro(Long id, String nomeLivro, String isbn, Categoria categoria, Autor autor) {
        this.id = id;
        this.nomeLivro = nomeLivro;
        this.isbn = isbn;
        this.autor = autor;
        this.categoria = categoria;
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
