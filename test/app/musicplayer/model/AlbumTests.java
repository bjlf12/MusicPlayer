package app.musicplayer.model;

import app.musicplayer.model.Album;
import org.junit.jupiter.api.Test;
import app.musicplayer.model.Song;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(ApplicationExtension.class)
public class AlbumTests {

    @Test
    public void givenTwoEqualsAlbums_whenCompareTo_thenReturnZero() {
        // given
        int id1 = 1;
        String title1 = "Beatles";
        String artist1 = "Beatles";

        int id2 = 2;
        String title2 = "Beatles";
        String artist2 = "Beatles";
        ArrayList<Song> songs2 = null;

        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,
                1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);

        // when
        Album testAlbum1 = new Album(id1, title1, artist1, testSongsList);
        Album testAlbum2 = new Album(id2, title2, artist2, testSongsList);

        // then
        assertTrue(testAlbum1.compareTo(testAlbum2) == 0);
    }

    @Test
    public void givenSameAlbumWithArticleAndWithoutArticle_whenCompareTo_thenReturnZero() {
        // given
        int id1 = 1;
        String title1 = "The Beatles";
        String artist1 = "The Beatles";

        int id2 = 2;
        String title2 = "Beatles";
        String artist2 = "Beatles";
        ArrayList<Song> songs2 = null;

        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,
                1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);

        // when
        Album testAlbum1 = new Album(id1, title1, artist1, testSongsList);
        Album testAlbum2 = new Album(id2, title2, artist2, testSongsList);

        // then
        assertTrue(testAlbum1.compareTo(testAlbum2) == 0);
    }

    @Test
    public void givenTwoDifferentAlbums_whenCompareTo_thenReturnDifferentFromZero() {
        // given
        int id1 = 1;
        String title1 = "Eatles";
        String artist1 = "Eatles";
        ArrayList<Song> songs1 = null;

        int id2 = 2;
        String title2 = "Beatles";
        String artist2 = "Beatles";
        ArrayList<Song> songs2 = null;

        // when
        Album testAlbum1 = new Album(id1, title1, artist1, songs1);
        Album testAlbum2 = new Album(id2, title2, artist2, songs2);

        // then
        assertTrue(testAlbum1.compareTo(testAlbum2) != 0);
    }
}
