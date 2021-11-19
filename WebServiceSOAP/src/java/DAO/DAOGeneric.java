package DAO;

import av3_prog5.Compromisso;
import av3_prog5.Contato;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAOGeneric {

    public static boolean editar(Object ct) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prog5_av3PU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(ct);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public static List<Contato> BuscaContato(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prog5_av3PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Contato> tq = em.createQuery("SELECT * FROM Contato WHERE nome = '" + nome + "'", Contato.class);
        return tq.getResultList();
    }

    public static List<Compromisso> getCompromissoLocal(String descricao) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prog5_av3PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Compromisso> tq = em.createQuery("select c from compromisso c, localizacao l where c.idlocal = l and l.descricao like '%" + descricao + "%'", Compromisso.class);
        return tq.getResultList();
    }

    public static List<Compromisso> getCompromissoContato(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prog5_av3PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Compromisso> tq = em.createQuery("select c from compromisso c, contato co, participante p where c.participante = p and p.contato = co and lower(co.nome) like lower('%" + nome + "%')", Compromisso.class);
        return tq.getResultList();

    }
}
