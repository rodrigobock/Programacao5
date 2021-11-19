package DAO;

import entidades.Compromisso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DaoCompromisso {

    public static Compromisso getID(Long pId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prog5PU");
        EntityManager em = emf.createEntityManager();
        return em.find(Compromisso.class, pId);
    }

    public static List<Compromisso> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prog5PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Compromisso> tq = em.createQuery("select c from compromisso c", Compromisso.class);
        return tq.getResultList();
    }

    public static boolean delete(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prog5PU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Compromisso c = em.find(Compromisso.class, id);
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public static List<Compromisso> getCompromissoLocal(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prog5PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Compromisso> tq = em.createQuery("select c from compromisso c, localizacao l where c.idlocal = l.id and l.id = " + id, Compromisso.class);
        return tq.getResultList();
    }

    public static List<Compromisso> getCompromissoContato(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prog5PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Compromisso> tq = em.createQuery("select comp from compromisso comp, contato co, participante p where p.idcontato = co.id and co.id = " + id, Compromisso.class);
        return tq.getResultList();
    }

}
