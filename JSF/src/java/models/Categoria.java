package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.utils.Conexao;

public class Categoria {

    private int idCategoria;
    private String descricao;

    public Categoria() {
    }

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public Categoria(int idCategoria, String descricao) {
        this.idCategoria = idCategoria;
        this.descricao = descricao;
    }

    public Categoria GetAllCategories() {
        ResultSet rs = null;
        Categoria ctgr = null;
        try {
            String sql = "select * from categoria order by idcategoria";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                ctgr = new Categoria(
                        rs.getInt("idcategoria"),
                        rs.getString("descricao"));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return ctgr;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
