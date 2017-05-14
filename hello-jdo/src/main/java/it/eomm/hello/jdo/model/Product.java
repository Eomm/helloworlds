package it.eomm.hello.jdo.model;

import javax.jdo.annotations.*;

/**
 * Created by Manuel Spigolon on 07/05/2017.
 */
@PersistenceCapable
public class Product {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.UUIDHEX)
    @Column(name = "PRODUCT_ID")
    private String id;

    @Persistent
    private String name = null;

    @Persistent
    private String description = null;

    @Persistent
    private double price = 0.0;

    @Element(mappedBy = "Inventory")
    private Inventory inventory;

    public Product(String name, String desc, double price) {
        this.name = name;
        this.description = desc;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
