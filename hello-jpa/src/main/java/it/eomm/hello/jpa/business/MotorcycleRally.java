package it.eomm.hello.jpa.business;

import it.eomm.hello.jpa.entities.Biker;
import it.eomm.hello.jpa.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Manuel Spigolon on 02/02/2017.
 */
public class MotorcycleRally implements IMotorcycleRally {


    public List<Biker> findAllBikers() {
        return null;
    }

    public Biker saveBiker(Biker biker) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(biker);
        em.getTransaction().commit();
        return biker;
    }

    public Biker updateBiker(Biker biker) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(biker);
        em.getTransaction().commit();
        return biker;
    }

    public Biker findById(Long id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        return em.find(Biker.class, id);
    }
}
