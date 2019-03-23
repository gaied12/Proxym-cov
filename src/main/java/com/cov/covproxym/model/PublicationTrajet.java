package com.cov.covproxym.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "publicationtrajets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PublicationTrajet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id",unique = true,nullable = false)
    private long id;
    @Column(name = "nbre de place ",nullable = false)
    @Max(4)
    private int nbr_place;
    @Column(name = "heure_depart")
    private String heure_depart;
    @Column(name = "disponibilte_trajet")
    private Boolean disponibilte_trajet;


    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "date_publication")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "UTC")
    private Date publicationDate;

    @OneToOne(fetch = FetchType.LAZY, targetEntity =Trajet.class)
    @JoinColumn(name = "trajet_id", nullable = false)
    private Trajet trajet;

    @OneToOne(fetch = FetchType.LAZY ,targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;




    public void setUser(User user) {
        this.user = user;
    }
    public Boolean getDisponibilte_trajet() {
        return disponibilte_trajet;
    }


    public Trajet getTrajet() {
        return trajet;
    }


    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public User getUser() {
        return user;
    }

    public void setUser() {
        this.user = user;
    }

    public PublicationTrajet() {

    }


    @Override
    public String toString() {
        return "Publication_trajet{" + "id=" + id + ", nbr_place=" + nbr_place + ", publicationDate=" + publicationDate + ", heure_depart='" + heure_depart + '\'' + '}';
    }


    public long getId() {
        return id;
    }

    public PublicationTrajet(int nbr_place, Date publicationDate, String heure_depart, Boolean disponibilte_trajet) {
        this.nbr_place = nbr_place;
        this.publicationDate = publicationDate;
        this.heure_depart = heure_depart;
        this.disponibilte_trajet = disponibilte_trajet;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean isDisponibilte_trajet() {
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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(String heure_depart) {
        this.heure_depart = heure_depart;
    }


}

