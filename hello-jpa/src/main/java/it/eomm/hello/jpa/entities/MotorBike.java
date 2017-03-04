package it.eomm.hello.jpa.entities;

import javax.persistence.*;

/**
 * Created by Manuel Spigolon on 01/03/2017.
 */
@Entity
@Table(name = "MOTOR_BIKE")
public class MotorBike {

    @Id
    @Column(name = "serialModelNumber")
    private String modelNo;

    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Biker owner;

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Biker getOwner() {
        return owner;
    }

    public void setOwner(Biker owner) {
        this.owner = owner;
    }
}
