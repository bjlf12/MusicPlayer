package app.musicplayer.model;

import app.musicplayer.MusicPlayer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

public class SearchSongTest {

    @Test
    public void SearchSong() throws FindFailed, InterruptedException {
        Screen screen = new Screen();
        ImagePath.add("test\\resources\\SearchSong");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                new JFXPanel();
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            new MusicPlayer().start(new Stage());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        thread.start();
        screen.click("search.png");
        screen.type("Miracle");
        Thread.sleep(3000);
        assertNotNull(screen.exists("result.png"));
        thread.stop();
    }
}
