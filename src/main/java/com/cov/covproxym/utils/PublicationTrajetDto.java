package com.cov.covproxym.utils;

import java.sql.Time;
import java.util.Date;

public class PublicationTrajetDto {
 private Long UserId;
 private Long TrajetId;
 private String HeureDeDepart;
 private String TrajetDiscription;
 private String DateAnnonce ;
 private int NombreDePlace;


 public String getDateAnnonce() {
 return DateAnnonce;
 }

 public void setDateAnnonce(String dateAnnonce) {
 DateAnnonce = dateAnnonce;
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

 public int getNombreDePlace() {
 return NombreDePlace;
 }

 public void setNombreDePlace(int nombreDePlace) {
 NombreDePlace = nombreDePlace;
 }

 public Long getUserId() {
 return UserId;
 }

 public void setUserId(Long userId) {
 UserId = userId;
 }

 public Long getTrajetId() {
 return TrajetId;
 }

 public void setTrajetId(Long trajetId) {
 TrajetId = trajetId;
 }

    public PublicationTrajetDto() {
    }
}

