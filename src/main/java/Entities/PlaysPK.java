package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlaysPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_artist")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "id_song")
    private Song song;

    public PlaysPK() {
    }

    public PlaysPK(Artist artist, Song song) {
        this.artist = artist;
        this.song = song;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaysPK playsPK = (PlaysPK) o;
        return Objects.equals(artist, playsPK.artist) && Objects.equals(song, playsPK.song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, song);
    }
}
