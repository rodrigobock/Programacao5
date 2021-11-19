package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.utils.Conexao;

public class Produto {

    private Integer idProduto;
    private int fkCategoria;
    private String descricao;
    private String observacao;
    private double preco;
    private int estoque;

    public Produto() {
    }

    public Produto(int fkCategoria, String descricao, String observacao, double preco, int estoque) {
        this.fkCategoria = fkCategoria;
        this.descricao = descricao;
        this.observacao = observacao;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(int idProduto, int fkCategoria, String descricao, String observacao, double preco, int estoque) {
        this.idProduto = idProduto;
        this.fkCategoria = fkCategoria;
        this.descricao = descricao;
        this.observacao = observacao;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto consultarById(int id) {
        ResultSet rs = null;
        Produto pdt = null;
        try {
            String sql = "select * from produto"
                    + " where idproduto = ? ";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                pdt = new Produto(
                        rs.getInt("idproduto"),
                        rs.getInt("idcategoria"),
                        rs.getString("descricao"),
                        rs.getString("observacao"),
                        rs.getDouble("preco"),
                        rs.getInt("estoque"));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return pdt;
    }

    public boolean excluir(){
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM produto WHERE idproduto = "+this.idProduto;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute(); 
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean salvar() {
        try {
           Connection con = Conexao.conectar();
            String sql; 
             if (this.idProduto == null) {
                 sql = "insert into produto(descricao, observacao, preco, estoque, idcategoria)"
                    + "values(?,?,?,?,?)";
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, this.descricao);
                stm.setString(2, this.observacao);
                stm.setDouble(3, this.preco);
                stm.setInt(4, this.estoque);
                stm.setInt(5, this.fkCategoria);
                stm.execute(); 
                return true;
            }else{
                   sql = "UPDATE produto SET descricao = '"+this.descricao+
                         "', observacao = '"+this.observacao+
                         "', preco = "+this.preco+
                         ", estoque = "+this.estoque+
                         ", idcategoria = "+this.fkCategoria +
                         " where idproduto = "+this.idProduto;
                   
                    PreparedStatement stm = con.prepareStatement(sql);
                    stm.execute();
                    return true;
             }
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public List<Produto> consultar(String filtro, boolean checkFilter, Categorias categoria) {
        ResultSet rs = null;
        List<Produto> lista = new ArrayList<>();
        try {
            
            String sql;
            if (checkFilter && categoria != null) {
                sql = "SELECT * from produto INNER JOIN categoria ON produto.idcategoria = categoria.idcategoria"
                    + " where categoria.idcategoria = " + categoria.getIndex();
            }else{
                sql = "select * from produto where descricao like '%" + filtro + "%'";
            }

            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                lista.add(new Produto(
                        rs.getInt("idproduto"),
                        rs.getInt("idcategoria"),
                        rs.getString("descricao"),
                        rs.getString("observacao"),
                        rs.getDouble("preco"),
                        rs.getInt("estoque")
                ));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return lista;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getFkCategoria() {
        return fkCategoria;
    }

    public void setFkCategoria(int fkCategoria) {
        this.fkCategoria = fkCategoria;
    }

}
