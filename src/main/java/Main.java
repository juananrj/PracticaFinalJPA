import Entities.Album;
import Entities.Artist;
import Entities.Play;
import Entities.Song;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) throws IOException, ParseException {
        FileAccessor fa = new FileAccessor();
        fa.readArtistFile("src/main/resources/artist.txt");
        fa.readAlbumFile("src/main/resources/album.txt");
        fa.readSongFile("src/main/resources/song.txt");
        fa.readPlayFile("src/main/resources/play.txt");

        entityManagerFactory = Persistence.createEntityManagerFactory("MusicaPersistenceUnit");

        Main main = new Main();

        System.out.println("Leyendo artistas");
        for (Artist artist : fa.artistList) {
            System.out.println(artist.toString());
            main.addArtist(artist);
        }

        System.out.println("Leyendo álbumes");
        for (Album album : fa.albumList) {
            System.out.println(album.toString());
            main.addAlbum(album);
        }

        System.out.println("Leyendo canciones");
        for (Song song : fa.songList) {
            System.out.println(song.toString());
            main.addSong(song);
        }

        System.out.println("Leyendo reproducciones");
        for (Play play : fa.playList) {
            System.out.println(play.toString());
            main.addPlay(play);
        }

        entityManagerFactory.close();
    }

    public void addArtist(Artist artist) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(artist);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void addAlbum(Album album) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(album);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void addSong(Song song) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(song);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void addPlay(Play play) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(play);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
