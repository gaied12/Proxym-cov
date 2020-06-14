package com.cov.covproxym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    @Column (name = " PhoneNumber ")
    private int PhoneNumber ;
    @Column(name = "password")
    private String Paswword ;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Code>codes ;

    public String getPaswword() {
        return Paswword;
    }

    public void setPaswword(String paswword) {
        Paswword = paswword;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }



    public long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
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
