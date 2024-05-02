import Entities.Album;
import Entities.Artist;
import Entities.Play;
import Entities.Song;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public Main() {
    }

    private static SessionFactory factory;

    public static void main(String[] args) throws IOException, ParseException {
        FileAccessor fa = new FileAccessor();
        fa.readArtistFile("src/main/resources/artist.txt");
        fa.readAlbumFile("src/main/resources/album.txt");
        fa.readSongFile("src/main/resources/song.txt");
        fa.readPlayFile("src/main/resources/play.txt");

        // Session Factory
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }


        Main MA = new Main();

        System.out.println("Se esta leyendo");
        for (int i = 0; i < fa.artistList.size(); i++) {
            System.out.println(fa.artistList.get(i).toString());
            MA.addArtist(fa.artistList.get(i));
        }

        System.out.println("Se esta leyendo");
        for (int i = 0; i < fa.albumList.size(); i++) {
            System.out.println(fa.albumList.get(i).toString());
            MA.addAlbum(fa.albumList.get(i));
        }

        System.out.println("Se esta leyendo");
        for (int i = 0; i < fa.songList.size(); i++) {
            System.out.println(fa.songList.get(i).toString());
            MA.addSong(fa.songList.get(i));
        }

        System.out.println("Se esta leyendo");
        for (int i = 0; i < fa.songList.size(); i++) {
            System.out.println(fa.playList.get(i).toString());
            MA.addPlay(fa.playList.get(i));
        }
    }

    public void addArtist(Artist artist) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer ArtistID = null;
        try {
            tx = session.beginTransaction();
            ArtistID = (Integer) session.save(artist);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void addAlbum(Album album) {
        Session session = factory.openSession();
        Transaction tx = null;
        String AlbumID = null;
        try {
            tx = session.beginTransaction();
            AlbumID = (String) session.save(album);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void addSong(Song song) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer SongID = null;
        try {
            tx = session.beginTransaction();
            SongID = (Integer) session.save(song);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void addPlay(Play play) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(play);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

