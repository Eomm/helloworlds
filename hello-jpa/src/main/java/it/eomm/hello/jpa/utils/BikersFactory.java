package it.eomm.hello.jpa.utils;

import it.eomm.hello.jpa.entities.Biker;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Manuel Spigolon on 04/03/2017.
 */
public class BikersFactory {

    private BikersFactory() {
        // this is a factory
    }

    public static Biker buildRandomBiker() {
        return buildBiker("Manuel", UUID.randomUUID().toString(), false, new Date(1), new Date());
    }

    public static Biker buildDefaultBiker() {
        return buildBiker("Manuel", "Eomm", false, new Date(1), new Date());
    }

    public static Biker buildBiker(String name, String battleName, boolean beard, Date birthday, Date registration) {
        Biker biker = new Biker();
        biker.setName(name);
        biker.setBattleName(battleName);
        biker.setBeard(beard);
        biker.setBirthday(birthday);
        biker.setRegistrationDate(registration);

        return biker;
    }

}
