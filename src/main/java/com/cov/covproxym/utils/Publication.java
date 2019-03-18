package com.cov.covproxym.utils;

import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.Trajet;
import com.cov.covproxym.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;


public class Publication {
    private Long userId;
    private Long trajetId;
    private String heure_depart;
    private Boolean disponibilte_trajet;
    private int nbr_place;


    public String getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(String heure_depart) {
        this.heure_depart = heure_depart;
    }

    public Boolean getDisponibilte_trajet() {
        return disponibilte_trajet;
    }

    public void setDisponibilte_trajet(Boolean disponibilte_trajet) {
        this.disponibilte_trajet = disponibilte_trajet;
    }

    public int getNbr_place() {
        return nbr_place;
    }

    public void setNbr_place(int nbr_place) {
        this.nbr_place = nbr_place;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTrajetId() {
        return trajetId;
    }

    public void setTrajetId(Long trajetId) {
        this.trajetId = trajetId;
    }

    public Publication(Long userId, Long trajetId, String heure_depart, Boolean disponibilte_trajet, int nbr_place) {
        this.userId = userId;
        this.trajetId = trajetId;
        this.heure_depart = heure_depart;
        this.disponibilte_trajet = disponibilte_trajet;
        this.nbr_place = nbr_place;
    }

    public Publication() {

    }
}
