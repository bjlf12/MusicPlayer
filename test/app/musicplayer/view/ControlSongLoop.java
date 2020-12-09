package app.musicplayer.view;

import app.musicplayer.MusicPlayer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;
import org.testfx.framework.junit5.ApplicationExtension;

@ExtendWith(ApplicationExtension.class)
public class ControlSongLoop {

    @Test
    public void SongMoment() throws InterruptedException, FindFailed {
        Screen screen = new Screen();
        ImagePath.add("test\\resources\\ControlSongLoop");
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
        screen.click("playlist.png");
        Thread.sleep(2000);
        screen.click("song.png");
        Thread.sleep(1000);
        screen.click("play.png");
        Thread.sleep(1000);
        screen.click("loop.png");
        Thread.sleep(3000);
        screen.dragDrop("SongBar.png", "end1.png");
        Thread.sleep(5000);
        assertNotNull(screen.exists("wait.png"));
    }
}
