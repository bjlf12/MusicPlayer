package app.musicplayer.model;

import app.musicplayer.model.Playlist;
import app.musicplayer.model.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {

    @Test
    public void givenValidArguments_whenCreatingPlaylist_thenCreatePlaylist() {
        // given
        int id = 1;
        String title = "TestPlaylist";
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,
                1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);

        // when
        Playlist testPlaylist = new Playlist(id, title, testSongsList);

        // then
        assertTrue(testPlaylist instanceof Playlist);
    }

    @Test
    public void givenValidId_whenGetId_thenReturnId() {
        // given
        int id = 1;
        String title = "TestPlaylist";
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,
                1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);

        // when
        Playlist testPlaylist = new Playlist(id, title, testSongsList);
        int returnedId = testPlaylist.getId();

        // then
        assertEquals(id, returnedId);
    }

    @Test
    public void givenValidTitle_whenGetTitle_thenReturnTitle() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        int id = 1;
        String title = "TestPlaylist";
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,
                1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);

        // when
        Playlist testPlaylist = new Playlist(id, title, testSongsList);
        String returnedTitle = testPlaylist.getTitle();

        // then
        assertEquals(title, returnedTitle);
    }

    @Test
    public void givenValidSongs_whenGetSongs_thenReturnSongs() {
        // given
        int id = 1;
        String title = "TestPlaylist";
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,
                1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);

        ObservableList<Song> expectedSongs = FXCollections.observableArrayList(testSongsList);

        // when
        Playlist testPlaylist = new Playlist(id, title, testSongsList);
        ObservableList<Song> returnedSongs = testPlaylist.getSongs();

        // then
        assertEquals(expectedSongs, returnedSongs);
    }

    @Test
    public void givenInvalidTitle_whenGetTitle_thenReturnNull() {
        // given
        int id = 1;
        String title = null;
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,
                1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);

        // when
        Playlist testPlaylist = new Playlist(id, title, testSongsList);
        String returnedTitle = testPlaylist.getTitle();

        // then
        assertNull(returnedTitle);
    }

    @Test
    public void givenInvalidSongs_whenGetSongs_thenReturnNull() {
        // given
        int id = 1;
        String title = "TestPlaylist";
        ArrayList<Song> testSongsList = null;

        // when
        Playlist testPlaylist = new Playlist(id, title, testSongsList);

        // then
        assertThrows(NullPointerException.class,
                ()->{
                    ObservableList<Song> returnedSongs = testPlaylist.getSongs();
                });
    }
}
