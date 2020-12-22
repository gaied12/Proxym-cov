package com.cov.covproxym.Repository;

import com.cov.covproxym.model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet,Long> {

}
