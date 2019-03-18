package com.cov.covproxym.enums;

public enum TrajetEnum {
   TRAJET1("Direction sahoul","pépenieur","sahloul"),
    TRAJET2("Direction cité riadh","pépenieur","cité radth");

    private String trajetName;
    private String trajetFrom;
    private String trajetTo;

    TrajetEnum(String trajetName, String trajetFrom, String trajetTo) {
        this.trajetName = trajetName;
        this.trajetFrom = trajetFrom;
        this.trajetTo = trajetTo;
    }

    public String getTrajetName() {
        return trajetName;
    }

    public void setTrajetName(String trajetName) {
        this.trajetName = trajetName;
    }

    public String getTrajetFrom() {
        return trajetFrom;
    }

    public void setTrajetFrom(String trajetFrom) {
        this.trajetFrom = trajetFrom;
    }

    public String getTrajetTo() {
        return trajetTo;
    }

    public void setTrajetTo(String trajetTo) {
        this.trajetTo = trajetTo;
    }
}
