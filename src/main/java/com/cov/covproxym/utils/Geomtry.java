package com.cov.covproxym.utils;

public class Geomtry {
    private Long lat ;
    private Long longi ;


    public  String res(){

        return  this.lat +","+this.longi ;
    }

    public Long getLat() {
        return lat;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    public Long getLongi() {
        return longi;
    }

    public void setLongi(Long longi) {
        this.longi = longi;
    }
}
