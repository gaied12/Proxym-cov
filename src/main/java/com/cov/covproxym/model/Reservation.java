package com.cov.covproxym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reservations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id",unique = true,nullable = false)
    private long id;

    @OneToOne(fetch =FetchType.LAZY,targetEntity = PublicationTrajet.class)
    @JoinColumn(name = "publicationtrajet_id", nullable = false)
    private PublicationTrajet publicationTrajet ;

    @OneToOne(fetch =FetchType.LAZY,cascade = CascadeType.MERGE)
    @JsonIgnore
    private User user;


public Reservation (){

}


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }



    public PublicationTrajet getPublicationTrajet() {
        return publicationTrajet;
    }

    public void setPublicationTrajet(PublicationTrajet publicationTrajet) {
        this.publicationTrajet = publicationTrajet;
    }
}
