package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.TrajetRepository;
import com.cov.covproxym.enums.TrajetEnum;
import com.cov.covproxym.model.Trajet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service

public class TrajetServiceImpl implements TrajetService  {


    @Autowired
    TrajetRepository trajetRepository ;

    @PostConstruct()
  private void createDefaultTrajets(){
        for(TrajetEnum trajetEnum:TrajetEnum.values()){
            Trajet trajet= trajetRepository.findByNomTrajet(trajetEnum.getTrajetName());

            if(trajet==null){
                trajetRepository.save(new Trajet(trajetEnum.getTrajetName(),trajetEnum.getTrajetFrom(),trajetEnum.getTrajetTo()));
            }
        }
    }


    @Override
    public Trajet savetrajet(Trajet trajet) {
       trajetRepository.save(trajet);
       return trajet;
    }

    @Override
    public List<Trajet> trajets() {
        trajetRepository.findAll();
        return  trajets() ;
    }

    @Override
    public Optional<Trajet> showtrajet(long id) {
       return trajetRepository.findById(id);

    }

    @Override
    public Optional<Trajet> findByLieuDepart(String lieuDepart) {
        return trajetRepository.findByLieuDepart(lieuDepart);
    }

    @Override
    public Optional<Trajet> findByLieuArivve(String LieuArivve) {
         return trajetRepository.findByLieuArivve(LieuArivve);
      }
}
