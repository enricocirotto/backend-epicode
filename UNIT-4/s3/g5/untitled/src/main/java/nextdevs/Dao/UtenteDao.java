package nextdevs.Dao;


import nextdevs.Entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class UtenteDao {
    private EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }
    public void save(Utente utente){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(utente);
        et.commit();
    }

    public Utente getById(Integer id){

        return em.find(Utente.class,id);
    }

    public void update(Utente utente){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(utente);
        et.commit();
    }

    public List<Utente> findAll(){
        return em.createQuery("SELECT u FROM Utente u",Utente.class).getResultList();
    }

    public void delete(Utente utente){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(utente);
        et.commit();
    }
}
