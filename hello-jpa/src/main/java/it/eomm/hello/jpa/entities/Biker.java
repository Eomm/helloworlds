package it.eomm.hello.jpa.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Manuel Spigolon on 02/02/2017.
 */
@Entity
@Table(name = "BIKER")
@NamedQueries({
        // In HQL (or JPQL) queries you must use the names of the types (java)
        @NamedQuery(
                name = "findAllBikers",
                query = "SELECT b FROM Biker b"
        )
})
public class Biker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "bikerName")
    private String name;

    @Column(unique = true, updatable = false)
    private String battleName;

    private Boolean beard;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Temporal(TemporalType.TIME)
    private Date registrationDate;

    @Transient // --> this annotiation make the field transient only for JPA
    private transient String criminalRecord; // this keyword make the field transient for JPA and serialization

    /* without mappedBy attribute, a third-party table will be generated,
     * but specify the java-field that represents the FK relation, the connection
     * will be established correctly.
     */
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MotorBike> motorBikes;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBattleName() {
        return battleName;
    }

    public void setBattleName(String battleName) {
        this.battleName = battleName;
    }

    public Boolean getBeard() {
        return this.beard;
    }

    public void setBeard(Boolean beard) {
        this.beard = beard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCriminalRecord() {
        return criminalRecord;
    }

    public void setCriminalRecord(String criminalRecord) {
        this.criminalRecord = criminalRecord;
    }

    public List<MotorBike> getMotorBikes() {
        return motorBikes;
    }

    public void setMotorBikes(List<MotorBike> motorBikes) {
        this.motorBikes = motorBikes;
    }
}
