package com.example.gestion_de_cinehteque.admin;



import com.example.gestion_de_cinehteque.entities.CD;

import jakarta.ejb.Local;
import java.util.List;

@Local
public interface AdministrationBean {

    /**
     * Ajoute un nouveau CD.
     *
     * @param cd Le CD à ajouter.
     * @return L'ID du CD ajouté.
     */
    int ajouterCD(CD cd);

    /**
     * Modifie un CD existant.
     *
     * @param cd Le CD avec les nouvelles informations.
     */
    void modifierCD(CD cd);

    /**
     * Supprime un CD existant.
     *
     * @param cdId L'ID du CD à supprimer.
     */
    void supprimerCD(int cdId);

    /**
     * Récupère tous les CD disponibles.
     *
     * @return Une liste de CD.
     */
    List<CD> listerCD();

    /**
     * Récupère un CD par son ID.
     *
     * @param cdId L'ID du CD à récupérer.
     * @return Le CD correspondant.
     */
    CD recupererCD(int cdId);
}

