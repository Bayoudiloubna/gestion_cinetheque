package com.example.gestion_de_cinehteque.services;

import com.example.gestion_de_cinehteque.entities.CD;
import java.util.List;

public interface EmpruntService {
    List<CD> getCdsDisponibles();
    void emprunterCd(int cdId, int utilisateurId);
    void retournerCd(int cdId, int utilisateurId);
}