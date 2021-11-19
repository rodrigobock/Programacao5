package av2_prog5;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="compromisso")

public class Compromisso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date data;
    private Time hora;
    private Time duracao;

    @OneToMany(mappedBy = "compromisso")
    private List<Participante> participante;

    @ManyToOne
    @JoinColumn(name = "idlocal")
    private Localizacao local;

    public Compromisso() {
    }

    public Localizacao getLocal() {
        return local;
    }

    public void setLocal(Localizacao local) {
        this.local = local;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Time getDuracao() {
        return duracao;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }

    public List<Participante> getParticipante() {
        return participante;
    }

    public void setParticipante(List<Participante> participante) {
        this.participante = participante;
    }

    @Override
    public String toString() {
        return "Compromisso{" + "id=" + id + ", data=" + data + ", hora=" + hora + ", duracao=" + duracao + ", participante=" + participante + ", local=" + local + '}';
    }

}
