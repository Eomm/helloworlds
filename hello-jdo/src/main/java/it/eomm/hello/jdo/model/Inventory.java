package it.eomm.hello.jdo.model;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Manuel Spigolon on 07/05/2017.
 */
@PersistenceCapable
public class Inventory {

    @PrimaryKey
    String name = null;

    @Element(column = "INVENTORY_ID", dependent = "true")
    Set<Product> products = new HashSet<Product>();

    public Inventory(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
