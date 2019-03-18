package com.cov.covproxym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "trajets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Trajet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id",unique = true,nullable = false)
    private long id;
    @Column(name = "nom_trajet")
    private String nomTrajet ;
    @Column (name = "lieu_depart" )
    private String lieuDepart ;

    @Column (name = "Lieu_arivve")
    private String lieuArivve ;



    public String getNomTrajet() {
        return nomTrajet;
    }

    public Trajet(String nomTrajet, String lieuDepart, String lieuArivve) {
        this.nomTrajet = nomTrajet;
        this.lieuDepart = lieuDepart;
        this.lieuArivve = lieuArivve;
    }

    public void setNomTrajet(String nomTrajet) {
        this.nomTrajet = nomTrajet;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public String getLieuArivve() {
        return lieuArivve;
    }

    public void setLieuArivve(String lieuArivve) {
        this.lieuArivve = lieuArivve;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Trajet (){

}
}
