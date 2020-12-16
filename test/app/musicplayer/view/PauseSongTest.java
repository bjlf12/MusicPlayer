package app.musicplayer.view;

import app.musicplayer.MusicPlayer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)
public class PauseSongTest {

    @Test
    public void PauseSong() throws InterruptedException, FindFailed {
        Screen screen = new Screen();
        ImagePath.add("test\\resources\\PauseSongTest");
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
        screen.click("Play.png");
        Thread.sleep(3000);
        screen.click("Pause.png");
        Thread.sleep(2000);
        screen.click("playlist.png");
        screen.click("Play.png");
        Thread.sleep(3000);
        assertNotNull(screen.exists("Pause.png"));
    }
}