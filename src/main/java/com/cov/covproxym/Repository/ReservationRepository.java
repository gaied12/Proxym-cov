package com.cov.covproxym.Repository;

import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findAllByPublicationTrajet(PublicationTrajet publicationTrajet);
}
