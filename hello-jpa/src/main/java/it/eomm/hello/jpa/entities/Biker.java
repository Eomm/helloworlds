package it.eomm.hello.jpa.entities;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Manuel Spigolon on 02/02/2017.
 */

// By default, the placement of the @Id annotation gives the default access strategy.
// At Class level set the default behaviour in case of multiple AccessType configuration.
// With access at PROPERTY you have to annotate with @Transient all the helper methods or bidirectional associations
@Access(AccessType.FIELD)

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

    /**
     * @Access, in conjunction with the relations @OneToOne, let get the ID of the objects <b>without</b> making a
     * select for getting all the columns. This because the Proxy think that is a standard field access and loads
     * the whole record.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Column(name = "bikerName")
    private String name;

    @Column(unique = true, updatable = false)
    private String battleName;

    private Boolean beard;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    @Transient // --> this annotation make the field transient only for JPA
    private transient String criminalRecord; // this keyword make the field transient for JPA and serialization

    /* without mappedBy attribute, a third-party table will be generated,
     * but specify the java-field that represents the FK relation, the connection
     * will be established correctly.
     */
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MotorBike> motorBikes;

    // SELF-JOIN
    @OneToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "friendId", nullable = true)
    private Biker bestFriend;

    // Another Self-Join
    @OneToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "enemyId", nullable = true)
    private Biker worseFriend;

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

    /**
     * This configuration work overriding the default AccessType (FILED in this class example)
     */
//    @Access(AccessType.PROPERTY)
//    @OneToMany(...)
    public List<MotorBike> getMotorBikes() {
        return motorBikes;
    }

    public void setMotorBikes(List<MotorBike> motorBikes) {
        this.motorBikes = motorBikes;
    }

    public Biker getBestFriend() {
        return bestFriend;
    }

    public void setBestFriend(Biker bestFriend) {
        this.bestFriend = bestFriend;
    }

    public Biker getWorseFriend() {
        return worseFriend;
    }

    public void setWorseFriend(Biker worseFriend) {
        this.worseFriend = worseFriend;
    }
}
