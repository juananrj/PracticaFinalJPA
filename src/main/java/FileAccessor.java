import Entities.Album;
import Entities.Artist;
import Entities.Play;
import Entities.Song;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.StringTokenizer;

public class FileAccessor {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    public Artist[] artistList;
    public Album[] albumList;
    public Song[] songList;
    public Play[] playList;

    public FileAccessor() {
        entityManagerFactory = Persistence.createEntityManagerFactory("MusicaPersistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void readArtistFile(String filename) throws IOException, ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(line, ",");
            int id = Integer.parseInt(str.nextToken());
            String firstname = str.nextToken();
            String lastname = str.nextToken();
            java.util.Date born = dateFormat.parse(str.nextToken());
            java.util.Date died = dateFormat.parse(str.nextToken());
            Artist artist = new Artist(id, firstname, lastname, born, died);
            persistEntity(artist);
            System.out.println(artist.toString());
        }

        br.close();
    }

    public void readAlbumFile(String filename) throws IOException, ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(line, ",");
            String code = str.nextToken();
            String title = str.nextToken();
            java.util.Date recorded = dateFormat.parse(str.nextToken());
            String label = str.nextToken();
            boolean available = Boolean.parseBoolean(str.nextToken());
            Album album = new Album(code, title, recorded, label, available);
            persistEntity(album);
            System.out.println(album.toString());
        }

        br.close();
    }

    public void readSongFile(String filename) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(line, ",");
            int id = Integer.parseInt(str.nextToken());
            Album album = findAlbumById(Integer.parseInt(str.nextToken()));
            String title = str.nextToken();
            LocalTime duration = LocalTime.parse(str.nextToken());
            Song song = new Song(album, title, duration);
            persistEntity(song);
            System.out.println(song.toString());
        }

        br.close();
    }

    public void readPlayFile(String filename) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(line, ",");
            Artist artist = findArtistById(Integer.parseInt(str.nextToken()));
            Song song = findSongById(Integer.parseInt(str.nextToken()));
            String instrument = str.nextToken();
            Play play = new Play(artist, song, instrument);
            persistEntity(play);
            System.out.println(play.toString());
        }

        br.close();
    }

    private void persistEntity(Object entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    private Album findAlbumById(int id) {
        return entityManager.find(Album.class, id);
    }

    private Artist findArtistById(int id) {
        return entityManager.find(Artist.class, id);
    }

    private Song findSongById(int id) {
        return entityManager.find(Song.class, id);
    }

    public void closeEntityManager() {
        entityManager.close();
        entityManagerFactory.close();
    }
}

