import app.musicplayer.model.Song;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class SongTest {

    @Test
    void songValidInfoCase(){

        int id = 1;
        String title = "Smooth";
        String artist = "Carlos Santana";
        String album = "Test";
        Duration length = Duration.ofMinutes(4);
        int trackNumber = 1;
        int discNumber = 1;
        int playCount = 1;
        LocalDateTime playDate = LocalDateTime.now();
        String location = "resources\\Smooth.mp3";

        Song song = new Song(id, title, artist, album, length, trackNumber, discNumber, playCount, playDate, location);

        assertEquals(song.getId(), id);
        assertEquals(song.getTitle(), title);
        assertEquals(song.getArtist(), artist);
        assertEquals(song.getAlbum(), album);
        assertEquals(song.getLength(), "4:00");
        assertEquals(song.getTrackNumber(), trackNumber);
        assertEquals(song.getDiscNumber(), discNumber);
        assertEquals(song.getPlayCount(), playCount);
        assertEquals(song.getPlayDate(), playDate);
        assertEquals(song.getLocation(), location);
        File directory = new File(location);
        assertTrue(directory.exists());

    }

    @Test
    void songNullTitleCase(){

        int id = 1;
        String title = null;
        String artist = "Carlos Santana";
        String album = "Test";
        Duration length = Duration.ofMinutes(4);
        int trackNumber = 1;
        int discNumber = 1;
        int playCount = 1;
        LocalDateTime playDate = LocalDateTime.now();
        String location = "resources\\Smooth.mp3";

        Song song = new Song(id, title, artist, album, length, trackNumber, discNumber, playCount, playDate, location);

        assertNotEquals(song.getTitle(), null);

    }

    @Test
    void songNullAlbumCase(){

        int id = 1;
        String title = "Smooth";
        String artist = "Carlos Santana";
        String album = null;
        Duration length = Duration.ofMinutes(4);
        int trackNumber = 1;
        int discNumber = 1;
        int playCount = 1;
        LocalDateTime playDate = LocalDateTime.now();
        String location = "resources\\Smooth.mp3";

        Song song = new Song(id, title, artist, album, length, trackNumber, discNumber, playCount, playDate, location);

        assertNotEquals(song.getAlbum(), null);

    }

    @Test
    void songNullArtistCase(){

        int id = 1;
        String title = "Smooth";
        String artist = null;
        String album = "Test";
        Duration length = Duration.ofMinutes(4);
        int trackNumber = 1;
        int discNumber = 1;
        int playCount = 1;
        LocalDateTime playDate = LocalDateTime.now();
        String location = "resources\\Smooth.mp3";

        Song song = new Song(id, title, artist, album, length, trackNumber, discNumber, playCount, playDate, location);

        assertNotEquals(song.getArtist(), null);

    }

    @Test

    void songPlayedValid() throws ParserConfigurationException, IOException, SAXException {

        int id = 1;
        String title = "Smooth";
        String artist = "Carlos Santana";
        String album = "Test";
        Duration length = Duration.ofMinutes(4);
        int trackNumber = 1;
        int discNumber = 1;
        int playCount = 1;
        LocalDateTime playDate = LocalDateTime.now();
        String location = "resources\\Smooth.mp3";

        Song song = new Song(id, title, artist, album, length, trackNumber, discNumber, playCount, playDate, location);

        song.played();

        File file = new File("releases\\library.xml");
        assertEquals(file.exists(), true);
    }
}
