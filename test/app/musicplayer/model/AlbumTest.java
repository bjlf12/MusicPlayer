package app.musicplayer.model;

import app.musicplayer.model.Album;
import app.musicplayer.model.Song;
import app.musicplayer.util.Resources;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

@ExtendWith(ApplicationExtension.class)
class AlbumTest {

    @Test
    void getId() {
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);
        Album testAlbum = new Album(1, "test", "Kenny", testSongsList);

        assertEquals(1, testAlbum.getId());

    }

    @Test
    void getTitle() {
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);
        Album testAlbum = new Album(1, "test", "Kenny", testSongsList);

        assertEquals("test", testAlbum.getTitle());
    }

    @Test
    void getArtist() {
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);
        Album testAlbum = new Album(1, "test", "Kenny", testSongsList);

        assertEquals("Kenny", testAlbum.getArtist());
    }

    @Test
    void getSongs() {
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> testSongsList = new ArrayList<Song>();
        ArrayList<Song> testSongsListTwo = new ArrayList<Song>();
        testSongsList.add(testSong);
        testSongsListTwo.add(testSong);
        Album testAlbum = new Album(1, "test", "Kenny", testSongsList);

        assertEquals(testSongsListTwo, testAlbum.getSongs());
    }

    @Test
    void getArtwork() {
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);
        Album testAlbum = new Album(1, "test", "Kenny", testSongsList);
        Image result = testAlbum.getArtwork();
        Image expected = new Image(Resources.IMG + "albumsIcon.png");
        assertEquals(result.impl_getUrl(), expected.impl_getUrl());
    }

    @Test
    void compareTo() {
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);
        Album testAlbum = new Album(1, "test", "Kenny", testSongsList);

        Album testAlbum2 = new Album(2, "The test", "Kenny", testSongsList);

        assertEquals(0, testAlbum.compareTo(testAlbum2));
    }
}