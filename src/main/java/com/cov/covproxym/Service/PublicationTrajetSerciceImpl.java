package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.PublicationTrajetRepository;
import com.cov.covproxym.Repository.TrajetRepository;
import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.Reservation;
import com.cov.covproxym.model.Trajet;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.PublicationTrajetDto;
import com.cov.covproxym.utils.TrajetDro;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PublicationTrajetSerciceImpl implements PublicationTrajetSercice {
    @Autowired
    TrajetRepository trajetRepository ;
    @Autowired
    PublicationTrajetRepository publicationtrajetRepository;

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
         publicationTrajet.setDepart(publication.getDepart());
        publicationTrajet.setDestination(publication.getDestination());

        publicationTrajet.setHeureDeDepart(publication.getHeureDeDepart());
        publicationTrajet.setTrajetDiscription(publication.getTrajetDiscription());
        publicationTrajet.setNombreDePlace(publication.getNombreDePlace());
        publicationTrajet.setDateAnnonce(publication.getDateAnnonce());
        String Depart=this.cordGeo(publication.getDepart());
        String Dest=this.cordGeo(publication.getDestination());

       TrajetDro trajet= this.trajetDesc(Depart,Dest);
       Trajet trajet1=new Trajet();
       trajet1.setTotal_time(trajet.getTotal_time());
       trajet1.setTotal_distance(trajet.getTotal_distance());

      Trajet trajet2= trajetRepository.save(trajet1);
      publicationTrajet.setTrajet(trajet2);





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

    @Override
    public String cordGeo(String adrr) {

      String url=  "https://api.mapbox.com/geocoding/v5/mapbox.places/"+adrr+".json?limit=2&access_token=pk.eyJ1Ijoib3Vzc2FtYTEyIiwiYSI6ImNraXJ6aWhwcDF4NjgycHAzbjNxNHd6YzUifQ.1M8F1zN9wB-8O4lINoSlMQ";

        RestTemplate restTemplate = new RestTemplate();
        JsonNode object=   restTemplate.getForObject(url, JsonNode.class);
         JsonNode n=   object.findValue("center");
        ObjectMapper mapper = new ObjectMapper();

        ArrayList<Double> cordinates = mapper.convertValue(n, ArrayList.class);
        double lat=cordinates.get(1);
        double longi=cordinates.get(0);
     String a=new DecimalFormat("##.##########").format(lat);
        String b=new DecimalFormat("##.##########").format(longi);
        StringBuilder x=new StringBuilder(a);
        x.setCharAt(a.indexOf(","),'.');

        StringBuilder z=new StringBuilder(b);
        z.setCharAt(b.indexOf(","),'.');


        return x+","+z ;
    }

    @Override
    public TrajetDro trajetDesc(String Depart, String Destination) {

        String url1="https://api.distancematrix.ai/maps/api/distancematrix/json?origins="+Depart+"&destinations="+Destination+"&key=WmgKuUh6XMzebmXpshf4ggVXvf1gd";

        RestTemplate restTemplate=new RestTemplate();
        JsonNode jsonNode= restTemplate.getForObject(url1,JsonNode.class);
      JsonNode distance=  jsonNode.findValue("distance");

      JsonNode time=jsonNode.findValue("duration");



        String finalDistance=distance.get("text").textValue();
        String finalTime=time.get("text").textValue();
        TrajetDro trajetDec=new TrajetDro();
        trajetDec.setTotal_distance(finalDistance);
        trajetDec.setTotal_time(finalTime);
        return  trajetDec ;








    }


}



