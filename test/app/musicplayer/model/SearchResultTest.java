package app.musicplayer.model;

import app.musicplayer.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class SearchResultTest {

    @Test
    public void givenValidArguments_whenCreatingSearchResult_thenCreateSearchResult() {
        // given
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,
                1, 0, LocalDateTime.now(), "/" );
        List<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);

        int albumId = 1;
        String albumTitle = "TestAlbum";
        String albumArtist = "TestArtist";
        Album testAlbum = new Album(albumId, albumTitle, albumArtist, (ArrayList<Song>) testSongsList);

        List<Album> testAlbumList = new ArrayList<Album>();
        Artist testArtist = new Artist(albumArtist, (ArrayList<Album>) testAlbumList);
        List<Artist> testArtistList = new ArrayList<Artist>();

        // when
        SearchResult testSearchResult = new SearchResult(testSongsList, testAlbumList,testArtistList);

        // then
        assertTrue(testSearchResult instanceof SearchResult);
    }

    @Test
    public void givenValidSongsList_whenGetSongsResults_thenReturnSongsList() {
        // given
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,
                1, 0, LocalDateTime.now(), "/" );
        List<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);

        int albumId = 1;
        String albumTitle = "TestAlbum";
        String albumArtist = "TestArtist";
        Album testAlbum = new Album(albumId, albumTitle, albumArtist, (ArrayList<Song>) testSongsList);

        List<Album> testAlbumList = new ArrayList<Album>();
        Artist testArtist = new Artist(albumArtist, (ArrayList<Album>) testAlbumList);
        List<Artist> testArtistList = new ArrayList<Artist>();

        // when
        SearchResult testSearchResult = new SearchResult(testSongsList, testAlbumList,testArtistList);
        List<Song> returnedSongsList = testSearchResult.getSongResults();

        // then
        assertEquals(testSongsList, returnedSongsList);
    }

    @Test
    public void givenValidAlbumList_whenGetAlbumResults_thenReturnAlbumList() {
        // given
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,
                1, 0, LocalDateTime.now(), "/" );
        List<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);

        int albumId = 1;
        String albumTitle = "TestAlbum";
        String albumArtist = "TestArtist";
        Album testAlbum = new Album(albumId, albumTitle, albumArtist, (ArrayList<Song>) testSongsList);

        List<Album> testAlbumList = new ArrayList<Album>();
        Artist testArtist = new Artist(albumArtist, (ArrayList<Album>) testAlbumList);
        List<Artist> testArtistList = new ArrayList<Artist>();

        // when
        SearchResult testSearchResult = new SearchResult(testSongsList, testAlbumList,testArtistList);
        List<Album> returnedAlbumList = testSearchResult.getAlbumResults();

        // then
        assertEquals(testAlbumList, returnedAlbumList);
    }

    @Test
    public void givenValidArtistList_whenGetArtistResults_thenReturnArtistList() {
        // given
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,
                1, 0, LocalDateTime.now(), "/" );
        List<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);

        int albumId = 1;
        String albumTitle = "TestAlbum";
        String albumArtist = "TestArtist";
        Album testAlbum = new Album(albumId, albumTitle, albumArtist, (ArrayList<Song>) testSongsList);

        List<Album> testAlbumList = new ArrayList<Album>();
        Artist testArtist = new Artist(albumArtist, (ArrayList<Album>) testAlbumList);
        List<Artist> testArtistList = new ArrayList<Artist>();

        // when
        SearchResult testSearchResult = new SearchResult(testSongsList, testAlbumList,testArtistList);
        List<Artist> returnedArtistList = testSearchResult.getArtistResults();

        // then
        assertEquals(testArtistList, returnedArtistList);
    }

    @Test
    public void givenInvalidSongsList_whenGetSongsResults_thenNull() {
        // given
        List<Song> testSongsList = null;

        int albumId = 1;
        String albumTitle = "TestAlbum";
        String albumArtist = "TestArtist";
        Album testAlbum = new Album(albumId, albumTitle, albumArtist, (ArrayList<Song>) testSongsList);

        List<Album> testAlbumList = new ArrayList<Album>();
        Artist testArtist = new Artist(albumArtist, (ArrayList<Album>) testAlbumList);
        List<Artist> testArtistList = new ArrayList<Artist>();

        // when
        SearchResult testSearchResult = new SearchResult(testSongsList, testAlbumList,testArtistList);
        List<Song> returnedSongsList = testSearchResult.getSongResults();

        // then
        assertEquals(testSongsList, returnedSongsList);
    }

    @Test
    public void givenInvalidAlbumList_whenGetAlbumResults_thenReturnNull() {
        // given
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,
                1, 0, LocalDateTime.now(), "/" );
        List<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);

        String albumArtist = "TestArtist";

        List<Album> testAlbumList = null;
        Artist testArtist = new Artist(albumArtist, (ArrayList<Album>) testAlbumList);
        List<Artist> testArtistList = new ArrayList<Artist>();

        // when
        SearchResult testSearchResult = new SearchResult(testSongsList, testAlbumList,testArtistList);
        List<Album> returnedAlbumList = testSearchResult.getAlbumResults();

        // then
        assertNull(returnedAlbumList);
    }

    @Test
    public void givenInvalidArtistList_whenGetArtistResults_thenReturnNull() {
        // given
        Song testSong = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1,
                1, 0, LocalDateTime.now(), "/" );
        List<Song> testSongsList = new ArrayList<Song>();
        testSongsList.add(testSong);

        int albumId = 1;
        String albumTitle = "TestAlbum";
        String albumArtist = "TestArtist";
        Album testAlbum = new Album(albumId, albumTitle, albumArtist, (ArrayList<Song>) testSongsList);

        List<Album> testAlbumList = new ArrayList<Album>();
        Artist testArtist = new Artist(albumArtist, (ArrayList<Album>) testAlbumList);
        List<Artist> testArtistList = null;

        // when
        SearchResult testSearchResult = new SearchResult(testSongsList, testAlbumList,testArtistList);
        List<Artist> returnedArtistList = testSearchResult.getArtistResults();

        // then
        assertNull(returnedArtistList);
    }
}