package com.cov.covproxym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class User implements Serializable  {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id",unique = true,nullable = false)
    private long id;
    @Column(name = "username",unique = true,nullable =false)
    private String username;
    @Column(name = "name")
    private String Name ;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "departement")
    private String Departement;
    @Column (name = "profession")
    private String Profession ;



    public long getId() {
        return id;
    }



    public String getUsername() {
        return username;
    }

    public void setId(long id) {
        this.id = id;
    }





    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartement() {
        return Departement;
    }

    public void setDepartement(String departement) {
        Departement = departement;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public User (){

    }
}
