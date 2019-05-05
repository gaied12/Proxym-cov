package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.PublicationTrajetRepository;
import com.cov.covproxym.Repository.TrajetRepository;
import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.Reservation;
import com.cov.covproxym.model.Trajet;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.PublicationTrajetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
            _pub.setHeureDeDepart(publicationTrajet.getHeureDeDepart());
            _pub.setNombreDePlace(publicationTrajet.getNombreDePlace());
            _pub.setTrajetDiscription(publicationTrajet.getTrajetDiscription());
            return new ResponseEntity<>(publicationtrajetRepository.save(_pub), HttpStatus.ACCEPTED);


        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deletepub(long id) {
        this.publicationtrajetRepository.deleteById(id);
    }

    @Override
    public void removeall() {
        publicationtrajetRepository.deleteAll();


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
    public PublicationTrajet save(PublicationTrajetDto publication) {
        PublicationTrajet publicationTrajet = new PublicationTrajet();


         Optional<User>user= userRepository.findById(publication.getUserId());
         if(user.isPresent())
             publicationTrajet.setUser(user.get());
        Optional<Trajet>trajet=trajetRepository.findById(publication.getTrajetId());
        if (trajet.isPresent())
            publicationTrajet.setTrajet(trajet.get());


        publicationTrajet.setHeureDeDepart(publication.getHeureDeDepart());
        publicationTrajet.setTrajetDiscription(publication.getTrajetDiscription());
        publicationTrajet.setNombreDePlace(publication.getNombreDePlace());
        publicationTrajet.setDateAnnonce(publication.getDateAnnonce());


       return publicationtrajetRepository.save(publicationTrajet);

    }


    @Override
    public Optional<PublicationTrajet> showpub(long id) {
        return publicationtrajetRepository.findById(id);
    }

    @Override
    public List<User> findAllUserForPublication(Long id) {
        List<User> users=new ArrayList<>();
       Optional<PublicationTrajet> publicationTrajetOptional= publicationTrajetRepository.findById(id);
       if (publicationTrajetOptional.isPresent()){
           PublicationTrajet publicationTrajet=publicationTrajetOptional.get();
           List<Reservation> list=publicationTrajet.getReservations();
           list.forEach(reservation -> {
               users.add(reservation.getUser());
           });
       }
        return users;
    }


}



