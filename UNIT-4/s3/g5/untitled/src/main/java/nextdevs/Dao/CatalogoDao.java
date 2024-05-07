package nextdevs.Dao;

import nextdevs.Entity.Catalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CatalogoDao {
    private EntityManager em;

    public CatalogoDao(EntityManager em) {
        this.em = em;
    }
    public void save(Catalogo catalogo){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.persist(catalogo);
        et.commit();
    }

    public Catalogo getById(String codiceISBN){

        return em.find(Catalogo.class,codiceISBN);
    }

    public void update(Catalogo catalogo){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(catalogo);
        et.commit();
    }

    public List<Catalogo> findAll(){
        return em.createQuery("SELECT c FROM Catalogo c",Catalogo.class).getResultList();
    }

    public List<Catalogo>findByAnno(Integer anno){
        return em.createQuery("SELECT c FROM Catalogo c WHERE anno_pubblicazione=:anno ", Catalogo.class)
                .setParameter("anno",anno)
                .getResultList();
    }

    public List<Catalogo> findByAutore(String autore){
        return em.createQuery("SELECT c FROM Catalogo c WHERE autore LIKE :autore ", Catalogo.class)
                .setParameter("autore","%"+autore+"%")
                .getResultList();
    }

    public  List<Catalogo> findByTitolo(String titolo){
        return em.createQuery("SELECT c FROM Catalogo c WHERE titolo LIKE :titolo ", Catalogo.class)
                .setParameter("titolo","%"+titolo+"%")
                .getResultList();

    }
    public void delete(Catalogo catalogo){
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.remove(catalogo);
        et.commit();

    }

}