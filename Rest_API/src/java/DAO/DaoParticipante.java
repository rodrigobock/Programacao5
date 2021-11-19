package DAO;

import entidades.Participante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DaoParticipante {

    public static Participante getID(Long pId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prog5PU");
        EntityManager em = emf.createEntityManager();
        return em.find(Participante.class, pId);
    }

    public static List<Participante> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prog5PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Participante> tq = em.createQuery("select p from participante p", Participante.class);
        return tq.getResultList();
    }

    public static boolean delete(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prog5PU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Participante p = em.find(Participante.class, id);
            em.remove(p);
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
