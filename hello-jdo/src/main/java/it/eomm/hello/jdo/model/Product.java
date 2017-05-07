package it.eomm.hello.jdo.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Created by Manuel Spigolon on 07/05/2017.
 */
@PersistenceCapable
public class Product {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    long id;
    String name = null;
    String description = null;
    double price = 0.0;

    public Product(String name, String desc, double price) {
        this.name = name;
        this.description = desc;
        this.price = price;
    }
}
