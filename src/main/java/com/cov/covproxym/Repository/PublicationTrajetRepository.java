package com.cov.covproxym.Repository;

import com.cov.covproxym.model.PublicationTrajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PublicationTrajetRepository extends JpaRepository<PublicationTrajet , Long> {
}
