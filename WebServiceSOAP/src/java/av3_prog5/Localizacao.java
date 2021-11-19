package av3_prog5;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "localizacao")

public class Localizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private String rua;
    private String bairro;
    private String cidade;
    private String numero;
    private String cep;

    @OneToMany(mappedBy = "local")
    private List<Compromisso> compromisso;

    public Localizacao() {
    }

    public Localizacao(String descricao, String rua, String bairro, String cidade, String numero, String cep) {
        this.descricao = descricao;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.cep = cep;
    }

    public Localizacao(String descricao, String rua, String bairro, String cidade, String numero, String cep, List<Compromisso> compromisso) {
        this.descricao = descricao;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.cep = cep;
        this.compromisso = compromisso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<Compromisso> getCompromisso() {
        return compromisso;
    }

    public void setCompromisso(List<Compromisso> compromisso) {
        this.compromisso = compromisso;
    }

    @Override
    public String toString() {
        return "Localizacao{" + "id=" + id + ", descricao=" + descricao + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", numero=" + numero + ", cep=" + cep + ", compromisso=" + compromisso + '}';
    }

}
