//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Entities.Album;
import Entities.Artist;
import Entities.Play;
import Entities.Song;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class FileAccessor {
    public final ArrayList<Album> albumList = new ArrayList();
    public final ArrayList<Artist> artistList = new ArrayList();
    public final ArrayList<Play> playList = new ArrayList();
    public final ArrayList<Song> songList = new ArrayList();

    public FileAccessor() {
    }

    public void readArtistFile(String filename) throws IOException, ParseException {
        DateFormat dateformat = new SimpleDateFormat("YYYY-MM-DD");
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";

        while((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            int id = Integer.parseInt(str.nextToken());
            String firstname = str.nextToken();
            String lastname = str.nextToken();
            Date born = dateformat.parse(str.nextToken());
            Date died = dateformat.parse(str.nextToken());
            System.out.println("" + id + firstname + lastname + born + died);
            this.artistList.add(new Artist(id, firstname, lastname, born, died));
        }

        br.close();
    }

    public void printArtistas() {
        for(int i = 0; i < this.artistList.size(); ++i) {
            System.out.println(((Artist)this.artistList.get(i)).toString());
        }

    }

    public void readAlbumFile(String filename) throws IOException, ParseException {
        DateFormat dateformat = new SimpleDateFormat("YYYY-MM-DD");
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";

        while((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            String code = str.nextToken();
            String title = str.nextToken();
            Date recorded = dateformat.parse(str.nextToken());
            String label = str.nextToken();
            boolean available = Boolean.parseBoolean(str.nextToken());
            System.out.println(code + title + recorded + label + available);
            this.albumList.add(new Album(code, title, recorded, label, available));
        }

        br.close();
    }

    public void printAlbums() {
        for(int i = 0; i < this.albumList.size(); ++i) {
            System.out.println(((Album)this.albumList.get(i)).toString());
        }

    }

    public void readSongFile(String filename) throws IOException, ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";

        while((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            int id = Integer.parseInt(str.nextToken());
            Album album = albumList.get(Integer.parseInt(str.nextToken()) - 1);
            String title = str.nextToken();
            LocalTime duration = LocalTime.parse(str.nextToken(), formatter);

            Song song = new Song(id, album, title, duration);
            this.songList.add(song);
            album.addSong(song);
            System.out.println(song);
        }

        br.close();
    }

    public void printSongs() {
        for(int i = 0; i < this.songList.size(); ++i) {
            System.out.println(((Song)this.songList.get(i)).toString());
        }

    }

    public void readPlayFile(String filename) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";

        while((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            Artist artist = (Artist)this.artistList.get(Integer.parseInt(str.nextToken()) - 1);
            Song song = (Song)this.songList.get(Integer.parseInt(str.nextToken()) - 1);
            String instrument = str.nextToken();
            PrintStream var10000 = System.out;
            String var10001 = artist.getFirstname();
            var10000.println(var10001 + song.getTitle() + instrument);
            this.playList.add(new Play(artist, song, instrument));
        }

        br.close();
    }

    public void printPlays() {
        for(int i = 0; i < this.playList.size(); ++i) {
            System.out.println(((Play)this.playList.get(i)).toString());
        }

    }
}

