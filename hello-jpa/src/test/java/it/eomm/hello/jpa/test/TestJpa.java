package it.eomm.hello.jpa.test;

import it.eomm.hello.jpa.business.IMotorcycleRally;
import it.eomm.hello.jpa.business.MotorcycleRally;
import it.eomm.hello.jpa.entities.Biker;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Manuel Spigolon on 27/02/2017.
 */
public class TestJpa {


    @Test
    public void insertBiker() {
        IMotorcycleRally crud = new MotorcycleRally();

        Biker manuel = new Biker();
        manuel.setName("Manuel");
        manuel.setBeard(false);

        manuel = crud.saveBiker(manuel);

        Assert.assertEquals(manuel.getId(), Long.valueOf(1L));
    }

}
