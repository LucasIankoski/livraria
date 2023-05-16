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

    public Livro cadastrarLivro(Livro obj){
        livroRepository.save(obj);
        return obj;
    }

    public void deletarLivro(Long id){
        livroRepository.deleteById(id);
    }

    public Livro atualizarLivro(Long id, Livro obj){
        Livro livro = livroRepository.getReferenceById(id);
        enviarDados(livro, obj);
        return livroRepository.save(livro);
    }

    private void enviarDados(Livro livro, Livro obj) {
        livro.setNomeLivro(obj.getNomeLivro());
        livro.setIsbn(obj.getIsbn());
        livro.setCategoria(obj.getCategoria());
        livro.setAutor(obj.getAutor());
    }
}
