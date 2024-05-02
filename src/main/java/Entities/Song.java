package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "song")
public class Song implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "code_album")
    private Album album;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private LocalTime duration;



    public Song() {
    }

    public Song(int id, Album album, String title, LocalTime duration) {
        this.id = id;
        this.album = album;
        this.title = title;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", album=" + album +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
