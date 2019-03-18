package com.cov.covproxym.Service;

import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.Trajet;

import java.util.List;
import java.util.Optional;

public interface TrajetService {
    public Trajet savetrajet(Trajet trajet);
    public List <Trajet> trajets ();
    public Optional<Trajet> showtrajet(long id);
    Optional<Trajet>findByLieuDepart(String lieuDepart );
    Optional<Trajet>findByLieuArivve(String LieuArivve);



}
