package it.eomm.hello.jpa.test;

import it.eomm.hello.jpa.business.IMotorcycleRally;
import it.eomm.hello.jpa.business.MotorcycleRally;
import it.eomm.hello.jpa.entities.Biker;
import it.eomm.hello.jpa.entities.MotorBike;
import it.eomm.hello.jpa.utils.BikersFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Test
    public void searchAllBikers() {
        int deleted = crud.deleteAllBikers();
        Assert.assertTrue(deleted >= 0);

        final int bikersNumber = 10;
        for (int i = 0; i < 10; i++) {
            Biker insert = BikersFactory.buildRandomBiker();
            insert = crud.saveBiker(insert);
        }

        List<Biker> bikers = crud.findAllBikers();
        Assert.assertEquals(bikersNumber, bikers.size());
    }

    @Test
    public void searchCriteria() throws ParseException {
        int deleted = crud.deleteAllBikers();
        Assert.assertTrue(deleted >= 0);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        final int bikersNumber = 10;
        int bearded = 0;
        int notBeaderded = 0;
        for (int i = 0; i < 10; i++) {
            Biker insert = BikersFactory.buildRandomBiker();

            boolean haveBear = i % 3 == 0;
            bearded += (haveBear) ? 1 : 0;
            notBeaderded += (haveBear) ? 0 : 1;
            insert.setBeard(haveBear);

            if (haveBear) {
                insert.setRegistrationDate(sdf.parse("25/12/2099"));
            }

            insert = crud.saveBiker(insert);
        }

        List<Biker> res = crud.findBiker(null, true);
        Assert.assertEquals(bearded, res.size());

        res = crud.findBiker(null, false);
        Assert.assertEquals(notBeaderded, res.size());

        res = crud.findBiker(new Date(), false);
        Assert.assertEquals(notBeaderded, res.size());

        res = crud.findBiker(new Date(), true);
        Assert.assertEquals(0, res.size());
    }

}
