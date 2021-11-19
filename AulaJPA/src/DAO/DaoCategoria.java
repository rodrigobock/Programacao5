/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import aulajpa.Categoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rodrigo
 */
public class DaoCategoria {

    public static boolean salvar(Object tbl) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AulaJPAPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tbl);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public static Categoria getOne(Long pId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AulaJPAPU");
        EntityManager em = emf.createEntityManager();
        return em.find(Categoria.class, pId);
    }

    public static boolean editar(Object tbl) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AulaJPAPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(tbl);
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
