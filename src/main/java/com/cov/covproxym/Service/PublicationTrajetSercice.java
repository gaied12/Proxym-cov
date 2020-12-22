package com.cov.covproxym.Service;

import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.Trajet;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.PublicationTrajetDto;
import com.cov.covproxym.utils.TrajetDro;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PublicationTrajetSercice {
    public ResponseEntity<PublicationTrajet> updatepub( long id,  PublicationTrajet publicationTrajet);
    public void deletepub(long id);
    public void removeall();
    public List <PublicationTrajet> showpubs ();

    Optional<PublicationTrajet> findById (long id) ;
    public PublicationTrajet save (PublicationTrajetDto publication) ;

        // public List<PublicationTrajet> showpub(long id) ;
    public Optional<PublicationTrajet> showpub(long id);

    List <User> findAllUserForPublication(Long id);
    public  String cordGeo (String adrr);
    public TrajetDro trajetDesc(String Depart , String Destination);

    }
