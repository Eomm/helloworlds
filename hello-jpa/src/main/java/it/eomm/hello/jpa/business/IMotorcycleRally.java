package it.eomm.hello.jpa.business;

import it.eomm.hello.jpa.entities.Biker;

import java.util.Date;
import java.util.List;

/**
 * Created by Manuel Spigolon on 02/02/2017.
 */
public interface IMotorcycleRally {

    List<Biker> findAllBikers();

    List<Biker> findBiker(Date registrationDate, Boolean bearded);

    Integer deleteAllBikers();

    Biker saveBiker(Biker biker);

    Biker updateBiker(Biker biker);

    Biker findById(Long id);

}
