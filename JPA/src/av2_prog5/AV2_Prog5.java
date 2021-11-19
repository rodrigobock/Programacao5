package av2_prog5;

import DAO.DAOCompromisso;
import DAO.DAOContato;
import DAO.DAOGeneric;
import DAO.DAOLocal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

public class AV2_Prog5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Declaração
        Participante p = new Participante();
        Contato c = new Contato();
        Localizacao l = new Localizacao();
        Compromisso comp = new Compromisso();

        // Localizacao
        l.setRua("Rua Benjamin Constant");
        l.setNumero("1213");
        l.setDescricao("Condominio Jardmim Europa");
        l.setCidade("Blumenau");
        l.setCep("89037501");
        l.setBairro("Escola Agricola");

        // Compromisso
        comp.setHora(Time.valueOf(LocalTime.of(14, 30)));
        comp.setDuracao(Time.valueOf(LocalTime.of(0, 30)));
        comp.setData(Date.valueOf(LocalDate.of(2021, Month.FEBRUARY, 12)));

        // Participante
        p.setStatus(true);
        p.setCompromisso(comp);
        p.setContato(c);

        // Contato
        c.setNome("rodrigo");

        try {
            // Salvar valores
            DAOGeneric.persist(l);
            DAOGeneric.persist(comp);
            DAOGeneric.persist(c);
            DAOGeneric.persist(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Editar nome
        c.setNome("Rodrigo Cabral Bock");
        c.setEmail("rodrigocabralbock@gmail.com");
        c.setFone("47988515051");
        DAOGeneric.editar(c);

        //editar idLocal compromisso
        comp.setLocal(l);
        DAOGeneric.editar(comp);

        // Consultar local
        l = DAOLocal.getID(1L);
        System.out.println("Rua: " + l.getRua() + ". N°: " + l.getNumero() + ". Bairro: " + l.getBairro() + ". Cidade: " + l.getCidade() + ". CEP: " + l.getCep() + ". Descrição: " + l.getDescricao());
        System.out.println("");

        List<Localizacao> ListaLoc = DAOLocal.getAll();
        for (Localizacao item : ListaLoc) {
            System.out.println(item);
            System.out.println("");
        }

        // Consultar compromissos
        comp = DAOCompromisso.getID(2L);
        System.out.print("Data: " + comp.getData() + " Duração: " + comp.getDuracao() + " Hora: " + comp.getHora());
        System.out.println("");

        List<Compromisso> ListaComp = DAOCompromisso.getAll();
        for (Compromisso item : ListaComp) {
            System.out.print(item);
            System.out.println("");
        }

        // Consultar Contato
        c = DAOContato.getID(3L);
        System.out.println("Nome: " + c.getNome() + " E-mail: " + c.getEmail() + " Fone: " + c.getFone());
        System.out.println("");

        List<Contato> ListaCo = DAOContato.getAll();
        for (Contato item : ListaCo) {
            System.out.print(item);
            System.out.println("");
        }

        // Encontrar contato pelo nome
        System.out.println("");
        List<Contato> contatos = DAOContato.getContato("rodrigo");
        for (Contato item : contatos) {
            System.out.println(item);
            System.out.println("");
        }

        /*
        
        // Compromisso por local
        List<Compromisso> listComp1 = DAOCompromisso.getCompromissoLocal("Co");
        for (Compromisso item : listComp1) {
            System.out.println(item);
        }
        
        // Compromisso por contato
        List<Compromisso> listComp2 = DAOCompromisso.getCompromissoContato("rodrigo");
        for (Compromisso item : listComp2) {
            System.out.println(item);
        }
        
         */
 
        /*
        
        //Delete participante
        try {
            DAOParticipantes.delete(4L);
            System.out.println("Excluido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Delete Contato
        try {
            DAOContato.delete(3L);
            System.out.println("Excluido com sucesso!");
        } catch (Exception e) {

        }

        // Delete Compromissos
        try {
            DAOCompromisso.delete(2L);
            System.out.println("Excluido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Delete Localizacao
        try {
            DAOLocal.delete(1L);
            System.out.println("Excluido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
         */
    }

}
