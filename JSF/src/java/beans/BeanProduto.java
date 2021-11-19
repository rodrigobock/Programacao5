package beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import models.Categorias;
import models.Produto;

@ManagedBean
@SessionScoped
public class BeanProduto {

    private int idProduto;
    private int fkCategoria;
    private String descricao;
    private String observacao;
    private double preco;
    private int estoque;
    private String categorias;
    private boolean checkFilter;
    private String filtro = "";
    private List<Produto> lista = new ArrayList<>();
    private Categorias categoria;
    private Produto produto = new Produto();

    // Metodos aqui
    public void consultarById(int id) {
        Produto pdt = new Produto();
        pdt = pdt.consultarById(id);
        idProduto = pdt.getIdProduto();
        descricao = pdt.getDescricao();
        observacao = pdt.getObservacao();
        preco = pdt.getPreco();
        fkCategoria = pdt.getFkCategoria();
        estoque = pdt.getEstoque();
    }

    public Categorias[] getCategoriasEnum() {
        return Categorias.values();
    }

    public void salvar() {
        FacesContext view = FacesContext.getCurrentInstance();
        FacesMessage msg = null;

        if (produto.getDescricao() == null) {
            msg = new FacesMessage("Informe a descrição");
            view.addMessage(null, msg);
        }

        if (produto.getFkCategoria() == 0) {
            msg = new FacesMessage("Informe a categoria do produto");
            view.addMessage(null, msg);
        }

        if (produto.getPreco() == 0) {
            msg = new FacesMessage("Informe o preço do produto");
            view.addMessage(null, msg);
        }

        if (produto.getEstoque() == 0) {
            msg = new FacesMessage("Informe a quantidade em estoque desse produto");
            view.addMessage(null, msg);
        }

        if (msg == null) {
            if (produto.salvar()) {
                try {
                    produto = new Produto();
                    msg = new FacesMessage("Contato salvo com sucesso");
                    view.addMessage(null, msg);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
                    lista = null;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void limpar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
            lista = null;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void consultar() {
        lista = new Produto().consultar(descricao, checkFilter, categoria);
    }

    public void Excluir(Produto produto) {
        try {
            if (produto.excluir()) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
                lista = null;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Editar(Produto produto) {
        try {
            this.produto = produto;
            FacesContext.getCurrentInstance().getExternalContext().redirect("cadastro.jsf");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getFkCategoria() {
        return fkCategoria;
    }

    public void setFkCategoria(int fkCategoria) {
        this.fkCategoria = fkCategoria;
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

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public List<Produto> getLista() {
        return lista;
    }

    public void setLista(List<Produto> lista) {
        this.lista = lista;
    }

    public boolean isCheckFilter() {
        return checkFilter;
    }

    public void setCheckFilter(boolean checkFilter) {
        this.checkFilter = checkFilter;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
