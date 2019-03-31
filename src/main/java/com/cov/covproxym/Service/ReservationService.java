package com.cov.covproxym.Service;

import com.cov.covproxym.model.Reservation;
import com.cov.covproxym.utils.ReservationDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    public void save (ReservationDto reservationDto) ;
    public List <Reservation> resrvation ();
    public Optional<Reservation> ShowReservation(long id);
    public ResponseEntity<String> DeleteReservation (long id);
    public ResponseEntity<String>DeleteAllReservation ();


    }
