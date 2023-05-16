package com.livraria.livros.config;

import com.livraria.livros.entities.Livro;
import com.livraria.livros.entities.enums.Autor;
import com.livraria.livros.entities.enums.Categoria;
import com.livraria.livros.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private LivroRepository livroRepository;


    @Override
    public void run(String... args) throws Exception {

    }
}
