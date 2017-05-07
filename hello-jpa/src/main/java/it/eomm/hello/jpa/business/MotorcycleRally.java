package it.eomm.hello.jpa.business;

import it.eomm.hello.jpa.entities.Biker;
import it.eomm.hello.jpa.utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Manuel Spigolon on 02/02/2017.
 */
public class MotorcycleRally implements IMotorcycleRally {


    /**
     * This method uses NAMED QUERY
     *
     * @return
     */
    public List<Biker> findAllBikers() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        return em.createNamedQuery("findAllBikers").getResultList();
    }

    /**
     * This method uses CRITERIA API
     *
     * @param registrationDate
     * @param bearded          search for biker with or without the bear, if null doesn't apply any filter
     * @return
     */
    public List<Biker> findBiker(Date registrationDate, Boolean bearded) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        CriteriaBuilder build = em.getCriteriaBuilder();
        List<Predicate> filterList = new ArrayList();

        CriteriaQuery<Biker> criteria = em.getCriteriaBuilder().createQuery(Biker.class);
        Root<Biker> bikerRoot = criteria.from(Biker.class);

        if (registrationDate != null) {
            Predicate p = build.lessThan(bikerRoot.<Date>get("registrationDate"), registrationDate);
            filterList.add(p);
        }

        if (bearded != null) {
            Predicate p = build.equal(bikerRoot.get("beard"), bearded);
            filterList.add(p);
        }

        criteria.where(filterList.toArray(new Predicate[]{}));

        return em.createQuery(criteria).getResultList();
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

    /**
     * This method uses NATIVE QUERY
     *
     * @return
     */
    public Integer deleteAllBikers() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();

        // In NATIVE QUERY, you have to refer to the database directly
        em.createNativeQuery("DELETE FROM MOTOR_BIKE").executeUpdate();
        int deleted = em.createNativeQuery("DELETE FROM BIKER").executeUpdate();
        em.getTransaction().commit();
        return deleted;
    }
}
