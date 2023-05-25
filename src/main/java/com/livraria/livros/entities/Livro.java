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

@Getter
@Setter
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

    public Livro(Long id, String nomeLivro, String isbn, Categoria categoria, Autor autor) {
        this.id = id;
        this.nomeLivro = nomeLivro;
        this.isbn = isbn;
        setAutor(autor);
        setCategoria(categoria);
    }

    private void setCategoria(Categoria categoria) {
        if(categoria != null){
            this.categoria = categoria.getCodigo();
        }
    }

    private void setAutor(Autor autor) {
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
