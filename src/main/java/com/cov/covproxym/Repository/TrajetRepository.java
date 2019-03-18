package com.cov.covproxym.Repository;

import com.cov.covproxym.model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TrajetRepository extends JpaRepository<Trajet,Long>

{
    Trajet findByNomTrajet(String nomTrajet);

Optional<Trajet>findByLieuDepart(String lieuDepart );
Optional<Trajet>findByLieuArivve(String LieuArivve);
}
