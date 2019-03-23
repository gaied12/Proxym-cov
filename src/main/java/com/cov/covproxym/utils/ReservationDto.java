package com.cov.covproxym.utils;

public class ReservationDto {
    private Long userId;
    private Long publicationId;
    public ReservationDto (){

    }

    public Long getUserId() {
        return userId;
    }

    public ReservationDto(Long userId, Long publicationId) {
        this.userId = userId;
        this.publicationId = publicationId;
    }

    public Long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
