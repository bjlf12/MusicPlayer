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
import org.sikuli.script.ScreenImage;

public class NextSongTest {

    @Test
    public void PlayNextSong() throws InterruptedException, FindFailed {
        Screen screen = new Screen();
        ImagePath.add("test\\resources\\NextSong");
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
        Thread.sleep(100);
        screen.click("clickplaylist.png");
        Thread.sleep(100);
        screen.click("selectSong.png");
        Thread.sleep(100);
        screen.click("playSong.png");
        Thread.sleep(100);
        ScreenImage previews = screen.capture();
        screen.click("next.png");
        ScreenImage result = screen.capture();
        Thread.sleep(2000);
        thread.stop();
        Assertions.assertNotEquals(previews, result);
    }
}
