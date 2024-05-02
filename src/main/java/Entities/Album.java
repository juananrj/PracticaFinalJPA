package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table( name = "album")
public class Album {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "recorded")
    private Date recorded;

    @Column(name = "label")
    private String label;

    @Column(name ="available")
    private boolean available;

    @OneToMany(mappedBy = "album")
    private Set<Song> songs;

    public Album(String code, String title, Date recorded, String label, boolean available) {
        this.code = code;
        this.title = title;
        this.recorded = recorded;
        this.label = label;
        this.available = available;
        this.songs = new HashSet<Song>();
    }

    public Album() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRecorded() {
        return this.recorded;
    }

    public void setRecorded(Date recorded) {
        this.recorded = recorded;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public String toString() {
        return "Album{code='" + this.code + "', title='" + this.title + "', recorded=" + this.recorded + ", label='" + this.label + "', available=" + this.available + "}";
    }
}
