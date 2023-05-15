package com.livraria.livros.entities.enums;

public enum Categoria {
    FANTASIA(1),
    ROMANCE(2),
    TERROR(3),
    CONTO(4);

    private int codigo;

    private Categoria(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public static Categoria valueof(int codigo){
        for (Categoria codigoCat : Categoria.values()){
            if(codigoCat.getCodigo() == codigo){
                return codigoCat;
            }
        }
        throw new IllegalArgumentException("O código de categoria está inválido");
    }
}
