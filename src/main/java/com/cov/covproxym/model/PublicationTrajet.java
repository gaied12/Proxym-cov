package com.cov.covproxym.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "publicationtrajets")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PublicationTrajet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    @Column(name = "NombreDePlace ", nullable = false)
    @Max(4)
    private int NombreDePlace;
    @Column(name = "HeureDeDepart")
    private String HeureDeDepart;
    @Column(name = "TrajetDescription")
    private String TrajetDiscription;


    @Column(name = "DateAnnonce")

    private String DateAnnonce;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Date_creation")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "UTC")
    private Date Datecreation;



    @OneToOne
    @JoinColumn(name = "TrajetId", nullable = false)
    private Trajet trajet;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "UserId", nullable = false)
    private User user;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Reservation> reservations;



    public PublicationTrajet() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNombreDePlace() {
        return NombreDePlace;
    }

    public void setNombreDePlace(int nombreDePlace) {
        NombreDePlace = nombreDePlace;
    }

    public String getHeureDeDepart() {
        return HeureDeDepart;
    }

    public void setHeureDeDepart(String heureDeDepart) {
        HeureDeDepart = heureDeDepart;
    }

    public String getTrajetDiscription() {
        return TrajetDiscription;
    }

    public void setTrajetDiscription(String trajetDiscription) {
        TrajetDiscription = trajetDiscription;
    }

    public String getDateAnnonce() {
        return DateAnnonce;
    }

    public void setDateAnnonce(String dateAnnonce) {
        DateAnnonce = dateAnnonce;
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

    public void setUser(User user) {
        this.user = user;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }



}

