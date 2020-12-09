package app.musicplayer.model;

import app.musicplayer.util.Resources;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class ArtistTest {

    @Test
    void getTitle() {
        Artist artist = new Artist("Artist", null);
        String result = artist.getTitle();
        String expected = "Artist";
        assertEquals(result, expected);
    }

    @Test
    void getTitleNull() {
        Artist artist = new Artist(null, null);
        assertNull(artist.getTitle());
    }

    @Test
    void getAlbums() {
        Song song = new Song(0, "Song", "Artist", "Album", Duration.ZERO, 1, 1, 0, LocalDateTime.now(), "/" );
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(song);
        Album album1 = new Album(0, "Title", "Artist", songs);
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(album1);
        Artist artist = new Artist("Artist", albums);
        ArrayList<Album> expected = albums;
        ArrayList<Album> result = artist.getAlbums();
        assertEquals(result, expected);
    }

    @Test
    void artistImageProperty() {
        Artist artist = new Artist("Artist", new ArrayList<>());
        ObjectProperty<Image>  expected = new SimpleObjectProperty<>(new Image(Resources.IMG + "artistsIcon.png"));
        ObjectProperty<Image> result = artist.artistImageProperty();
        assertEquals(expected.getValue().impl_getUrl(), result.getValue().impl_getUrl());
    }

    @Test
    void getArtistImage() {
        Artist artist = new Artist("Artist", new ArrayList<>());
        Image result = artist.getArtistImage();
        Image expected = new Image(Resources.IMG + "artistsIcon.png");
        assertEquals(result.impl_getUrl(), expected.impl_getUrl());
    }

    @Test
    void downloadArtistImage() {
        Artist artist = new Artist("Artist", new ArrayList<>());
        artist.getArtistImage();
        assertNotNull(artist.getArtistImage());
    }

    @Test
    void compareToSameArtist() {
        Artist other = new Artist("Artist", new ArrayList<>());
        Artist artist = new Artist("Artist", new ArrayList<>());
        int result = artist.compareTo(other);
        int expected = 0;
        assertEquals(result, expected);
    }
    @Test
    void compareToDifferentArtist() {
        Artist other = new Artist("Other", new ArrayList<>());
        Artist artist = new Artist("Artist", new ArrayList<>());
        int result = artist.compareTo(other);
        int expected = 0;
        assertNotEquals(result, expected);
    }
}