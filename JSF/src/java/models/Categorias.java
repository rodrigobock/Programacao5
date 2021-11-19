/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Rodrigo
 */
public enum Categorias {
    
    CEREAIS(1,"Cereais"),
    BEBIDAS(2,"Bebidas"),
    Lacticinios(3, "Lacticinios"),
    Condimentos(4, "Condimentos"),
    MaterialDeLimpeza(5, "Material de limpeza"),
    Frutas(6, "Frutas"),
    Verduras(7, "Verduras");
    
    
    private int index;
    private String descricao;

    Categorias(int index, String descricao){
        this.index= index;
        this.descricao=descricao;
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
