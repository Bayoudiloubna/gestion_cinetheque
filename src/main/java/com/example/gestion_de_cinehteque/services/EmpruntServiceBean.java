package com.example.gestion_de_cinehteque.services;




import com.example.gestion_de_cinehteque.entities.CD;
import com.example.gestion_de_cinehteque.entities.Emprunt;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EmpruntServiceBean implements EmpruntService {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    @Override
    public List<CD> getCdsDisponibles() {
        return em.createQuery("SELECT c FROM CD c WHERE c.disponible = true", CD.class)
                .getResultList();
    }

    @Override
    public void emprunterCd(int cdId, int utilisateurId) {
        CD cd = em.find(CD.class, cdId);
        if (cd != null && cd.isDisponible()) {
            Emprunt emprunt = new Emprunt();
            emprunt.setCd(cd);
            emprunt.setUtilisateurId(utilisateurId);
            emprunt.setDateEmprunt(new java.util.Date());

            em.persist(emprunt);

            cd.setDisponible(false);
            em.merge(cd);
        } else {
            throw new IllegalStateException("CD non disponible ou introuvable");
        }
    }

    @Override
    public void retournerCd(int cdId, int utilisateurId) {
        Emprunt emprunt = em.createQuery("SELECT e FROM Emprunt e WHERE e.cd.id = :cdId AND e.utilisateurId = :utilisateurId", Emprunt.class)
                .setParameter("cdId", cdId)
                .setParameter("utilisateurId", utilisateurId)
                .getSingleResult();

        if (emprunt != null) {
            em.remove(emprunt);

            CD cd = emprunt.getCd();
            cd.setDisponible(true);
            em.merge(cd);
        } else {
            throw new IllegalStateException("Emprunt introuvable");
        }
    }
}

