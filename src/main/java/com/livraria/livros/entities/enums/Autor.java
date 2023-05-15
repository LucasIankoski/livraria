package com.livraria.livros.entities.enums;

public enum Autor {
    JK_ROWLING(1),
    JOHN_GREEN(2),
    STEPHEN_KING(3),
    MACHADO_DE_ASSIS(4);

    private int codigo;

    private Autor(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public static Autor valueOf(int codigo){
        for(Autor codigoAutor : Autor.values()){
            if(codigoAutor.getCodigo() == codigo){
                return codigoAutor;
            }
        }
        throw new IllegalArgumentException("O código do autor não existe.");
    }

}
