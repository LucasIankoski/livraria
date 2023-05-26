package com.livraria.livros.entities;


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
    private Categoria categoria;

    @NotNull
    private Autor autor;

    public Livro(Long id, String nomeLivro, String isbn, Categoria categoria, Autor autor) {
        this.id = id;
        this.nomeLivro = nomeLivro;
        this.isbn = isbn;
        setAutor(autor);
        setCategoria(categoria);
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
