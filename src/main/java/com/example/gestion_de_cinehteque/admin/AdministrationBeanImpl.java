package com.example.gestion_de_cinehteque.admin;

import com.example.gestion_de_cinehteque.entities.CD;

import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class AdministrationBeanImpl implements AdministrationBean {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int ajouterCD(CD cd) {
        entityManager.persist(cd);
        return cd.getId(); // Assurez-vous que getId() existe et fonctionne correctement
    }

    @Override
    public void modifierCD(CD cd) {
        entityManager.merge(cd);
    }

    @Override
    public void supprimerCD(int cdId) {
        CD cd = entityManager.find(CD.class, cdId);
        if (cd != null) {
            entityManager.remove(cd);
        }
    }

    @Override
    public List<CD> listerCD() {
        return entityManager.createQuery("SELECT c FROM CD c", CD.class).getResultList();
    }

    @Override
    public CD recupererCD(int cdId) {
        return entityManager.find(CD.class, cdId);
    }
}
