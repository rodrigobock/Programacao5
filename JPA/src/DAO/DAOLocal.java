package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import av2_prog5.Localizacao;

public class DAOLocal {

     public static Localizacao getID(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV2_PU");
        EntityManager em = emf.createEntityManager();
        return em.find(Localizacao.class, id);
    }
     
    public static List<Localizacao> getAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV2_PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Localizacao> tq = em.createQuery("select l from localizacao l", Localizacao.class);
        return tq.getResultList();
    }
    
    public static boolean delete(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AV2_PU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Localizacao local = em.find(Localizacao.class, id);
            em.remove(local);
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
