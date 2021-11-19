/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulajpa;

/**
 *
 * @author Rodrigo
 */
public class AulaJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Categoria cat = DAO.DaoCategoria.getOne(1L);
        
        System.out.println(cat.toString());
        
//        Categoria cat = new Categoria();
//        cat.setDescricao("Doces");
//        
//        if(DAO.DaoCategoria.salvar(cat)){
//            System.out.println("Categoria salva com sucesso");
//        }
//        Produto pdt = new Produto();
//        pdt.setDescricao("Arroz");
//        pdt.setPreco(25);
//        pdt.setEstoque(5);
//        pdt.setIdCategoria(1);
//        
//        if(DAO.DaoCategoria.salvar(pdt)){
//            System.out.println("Produto salvo com sucesso");
//        }
    }

}
