package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.PublicationTrajetRepository;
import com.cov.covproxym.Repository.TrajetRepository;
import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.exception.NotFoundException;
import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.Trajet;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PublicationTrajetSerciceImpl implements PublicationTrajetSercice {
    @Autowired
    PublicationTrajetRepository publicationtrajetRepository;
    @Autowired
    TrajetRepository trajetRepository;
    @Autowired
    PublicationTrajetRepository publicationTrajetRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public ResponseEntity<PublicationTrajet> updatepub(long id, PublicationTrajet publicationTrajet) {
        Optional<PublicationTrajet> pubData = publicationtrajetRepository.findById(id);
        if (pubData.isPresent()) {
            PublicationTrajet _pub = pubData.get();
            _pub.setHeure_depart(publicationTrajet.getHeure_depart());
            _pub.setNbr_place(publicationTrajet.getNbr_place());
            _pub.setDisponibilte_trajet(publicationTrajet.isDisponibilte_trajet());
            return new ResponseEntity<>(publicationtrajetRepository.save(_pub), HttpStatus.ACCEPTED);


        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<String> deletepub(Long id) {
        Optional<PublicationTrajet> pubData = publicationtrajetRepository.findById(id);
        if (pubData.isPresent()) {
            publicationtrajetRepository.deleteById(id);
            return new ResponseEntity<>("Pub Deleted", HttpStatus.OK);

        }
        return new ResponseEntity<>("Pub Deleted", HttpStatus.OK);


    }

    @Override
    public ResponseEntity<String> deleteall() {
        publicationtrajetRepository.deleteAll();
        return new ResponseEntity<>("All pub Deleted", HttpStatus.OK);


    }

    @Override
    public List<PublicationTrajet> showpubs() {
        List<PublicationTrajet> pubs = new ArrayList<>();
        publicationtrajetRepository.findAll().forEach(pubs::add);
        return pubs;
    }

    @Override
    public Optional<PublicationTrajet> findById(long publicationTrajetId) {
        return publicationTrajetRepository.findById(publicationTrajetId);
    }


    @Override
    public void save(Publication publication) {
        PublicationTrajet publicationTrajet = new PublicationTrajet();


         Optional<User>user= userRepository.findById(publication.getUserId());
         if(user.isPresent())
             publicationTrajet.setUser(user.get());
        Optional<Trajet>trajet=trajetRepository.findById(publication.getTrajetId());
        if (trajet.isPresent())
            publicationTrajet.setTrajet(trajet.get());
        //  publicationTrajet.setUser(user.get());
        //publicationTrajet.setTrajet(trajet.get());


        publicationTrajet.setHeure_depart(publication.getHeure_depart());
        publicationTrajet.setDisponibilte_trajet(publication.getDisponibilte_trajet());
        publicationTrajet.setNbr_place(publication.getNbr_place());


        publicationtrajetRepository.save(publicationTrajet);

    }


    @Override
    public Optional<PublicationTrajet> showpub(long id) {
        return publicationtrajetRepository.findById(id);
    }


}



