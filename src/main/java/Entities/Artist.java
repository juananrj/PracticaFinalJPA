package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "born")
    private Date born;

    @Column(name = "died")
    private Date died;

    public Artist(int id, String firstname, String lastname, Date born, Date died) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.born = born;
        this.died = died;
    }

    public Artist() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBorn() {
        return this.born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public Date getDied() {
        return this.died;
    }

    public void setDied(Date died) {
        this.died = died;
    }

    public String toString() {
        return "Artist{id=" + this.id + ", firstname='" + this.firstname + "', lastname='" + this.lastname + "', born=" + this.born + ", died=" + this.died + "}";
    }
}
