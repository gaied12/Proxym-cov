package com.cov.covproxym.Service;

import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.utils.Publication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface PublicationTrajetSercice {
    public ResponseEntity<PublicationTrajet> updatepub( long id,  PublicationTrajet publicationTrajet);
    public ResponseEntity<String>deletepub(Long id);
    public ResponseEntity <String>deleteall();
    public List <PublicationTrajet> showpubs ();

    public void save (Publication publication) ;

        // public List<PublicationTrajet> showpub(long id) ;
    public Optional<PublicationTrajet> showpub(long id);

    }
  //  @GetMapping("/pc/{id}")
   // public Optional <ordinateur> getordonateur(@PathVariable String id) {
      //  return repository.findById(id);
  //  }