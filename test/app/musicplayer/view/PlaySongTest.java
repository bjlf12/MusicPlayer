package app.musicplayer.view;

import app.musicplayer.MusicPlayer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

public class PlaySongTest {

    @Test
    public void PlaySong() throws InterruptedException, FindFailed {
        Screen screen = new Screen();
        ImagePath.add("test\\resources\\PlaySong");
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
        screen.click("play.png");
        Thread.sleep(2000);
        Assertions.assertNotNull(screen.exists("playing.png"));
        thread.stop();
    }
}
