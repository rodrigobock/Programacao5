package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import av3_prog5.Participante;

public class DAOParticipantes {

    public static boolean inserirParticipante(Participante participante) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prog5_av3PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(participante);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public static Participante getID(Long pId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prog5_av3PU");
        EntityManager em = emf.createEntityManager();
        return em.find(Participante.class, pId);
    }

    public static List<Participante> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prog5_av3PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Participante> tq = em.createQuery("select p from participante p", Participante.class);
        return tq.getResultList();
    }

    public static boolean delete(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prog5_av3PU");
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
