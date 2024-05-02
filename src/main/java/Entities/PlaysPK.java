package Entities;

import java.io.Serializable;
import java.util.Objects;

public class PlaysPK implements Serializable {

    private Integer artist;
    private Integer song;

    public PlaysPK() {
    }

    public PlaysPK(Integer artist, Integer song) {
        this.artist = artist;
        this.song = song;
    }

    public Integer getArtist() {
        return artist;
    }

    public void setArtist(Integer artist) {
        this.artist = artist;
    }

    public Integer getSong() {
        return song;
    }

    public void setSong(Integer song) {
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
