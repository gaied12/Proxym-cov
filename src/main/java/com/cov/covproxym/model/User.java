package com.cov.covproxym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
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
    @Column(name = "username",unique = true)
    private String username;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "name")
    private String name ;
    @Column(name = "departement")
    private String departement;
    @Column (name = "profession")
    private String Profession ;




    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }






    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", lastName='" + lastName + '\'' + ", name='" + name + '\'' + ", departement='" + departement + '\'' + ", Profession='" + Profession + '\'' + '}';
    }

    public User(String username, String lastName, String name, String departement, String profession) {
        this.username = username;
        this.lastName = lastName;
        this.name = name;
        this.departement = departement;
        this.Profession = profession;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public User (){

    }
}
