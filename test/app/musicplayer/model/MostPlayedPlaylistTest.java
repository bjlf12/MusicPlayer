package app.musicplayer.model;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MostPlayedPlaylistTest {
    @Test
    void getSongs() {
        MostPlayedPlaylist mostPlayedPlaylist = new MostPlayedPlaylist(0);
        ObservableList<Song> result = mostPlayedPlaylist.getSongs();
        for (Song i: result
             ) {
            System.out.println(i.getId());
        }
        assertNotNull(result);
    }
}