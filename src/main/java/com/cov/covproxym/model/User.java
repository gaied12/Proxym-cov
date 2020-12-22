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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id",unique = true,nullable = false)
    private long id;
    @Column(name = "username",unique = true,nullable =false)
    private String userName;
    @Column(name = "name")
    private String firstName ;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "vMarque")
    private String vMarque;

    public String getvMarque() {
        return vMarque;
    }

    public void setvMarque(String vMarque) {
        this.vMarque = vMarque;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Column(name = "img_path")
    private String imgPath;
    @Column(name = "sexe")
    private String sexe ;

    @Column (name = " PhoneNumber ")
    private int PhoneNumber ;
    @Column(name = "password")
    private String paswword ;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Code>codes ;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPaswword() {
        return paswword;
    }

    public void setPaswword(String paswword) {
        this.paswword = paswword;
    }

    public User (){

    }
}
