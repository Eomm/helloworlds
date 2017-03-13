package it.eomm.hello.jpa.test;

import it.eomm.hello.jpa.business.IMotorcycleRally;
import it.eomm.hello.jpa.business.MotorcycleRally;
import it.eomm.hello.jpa.entities.Biker;
import it.eomm.hello.jpa.entities.MotorBike;
import it.eomm.hello.jpa.utils.BikersFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manuel Spigolon on 27/02/2017.
 */
public class TestJpa {


    private IMotorcycleRally crud;

    /**
     * This method is executed BEFORE each `@Test`
     */
    @Before
    public void before() {
        crud = new MotorcycleRally();
    }

    @Test
    public void insertBiker() {
        Biker insert = BikersFactory.buildRandomBiker();

        // assert the id doesn't exist
        Assert.assertNull(insert.getId());
        insert = crud.saveBiker(insert);

        // assert the id has been set
        Assert.assertNotNull(insert.getId());

        // assert that the commit is OK
        // TODO
    }

    @Test
    public void updateBiker() {
        /** insert a biker **/
        Biker insert = BikersFactory.buildRandomBiker();
        insert = crud.saveBiker(insert);
        Assert.assertNotNull(insert.getId());

        /** update the record **/
        final String newName = "Linus";
        insert.setName(newName);
        Biker update = crud.updateBiker(insert);
        Assert.assertNotNull(update);

        /** read the new value and check all the difference **/
        Biker read = crud.findById(update.getId());
        Assert.assertEquals(newName, read.getName());
        Assert.assertEquals(insert.getBattleName(), update.getBattleName());
        Assert.assertEquals(insert.getBeard(), update.getBeard());
        Assert.assertEquals(insert.getBirthday(), update.getBirthday());
        Assert.assertEquals(insert.getRegistrationDate(), update.getRegistrationDate());
    }

    @Test
    public void insertListOfBike() {

        Biker manuel = new Biker();
        manuel.setName("Manuel");
        manuel.setBeard(false);

        MotorBike bikeDucati = new MotorBike();
        bikeDucati.setModelNo("42");
        bikeDucati.setModel("Ducati 696");
        bikeDucati.setOwner(manuel);

        MotorBike bikeGuzzi = new MotorBike();
        bikeGuzzi.setModelNo("123");
        bikeGuzzi.setModel("MOTOGUZZI");
        bikeGuzzi.setOwner(manuel);

        List<MotorBike> manyBikes = new ArrayList<MotorBike>();
        manyBikes.add(bikeDucati);
        manyBikes.add(bikeGuzzi);
        manuel.setMotorBikes(manyBikes);


        Assert.assertNull(manuel.getId());
        manuel = crud.saveBiker(manuel);
        Assert.assertNotNull(manuel.getId());

        // TODO Assert

    }

}
