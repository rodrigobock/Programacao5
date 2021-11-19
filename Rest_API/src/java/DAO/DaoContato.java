package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import entidades.Contato;

public class DaoContato {

    public static Contato getID(Long pId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prog5PU");
        EntityManager em = emf.createEntityManager();
        return em.find(Contato.class, pId);
    }

    public static List<Contato> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prog5PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Contato> tq = em.createQuery("select c  from Contato c", Contato.class);
        return tq.getResultList();
    }

    public static List<Contato> getContato(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prog5PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Contato> tq = em.createQuery("select c from contato c where c.nome like '%" + nome + "%'", Contato.class);
        return tq.getResultList();
    }

    public static boolean delete(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prog5PU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Contato c = em.find(Contato.class, id);
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

}
