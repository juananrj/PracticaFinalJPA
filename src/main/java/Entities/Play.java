package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "play")
@IdClass(PlaysPK.class)
public class Play {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_artist")
    private Artist artist;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_song")
    private Song song;

    @Column(name = "instrument")
    private String instrument;

    public Play(Artist artist, Song song, String instrument) {
        this.artist = artist;
        this.song = song;
        this.instrument = instrument;
    }

    public Play() {
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

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return "Play{" +
                "artist=" + artist +
                ", song=" + song +
                ", instrument='" + instrument + '\'' +
                '}';
    }
}
