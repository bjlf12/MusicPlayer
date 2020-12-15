import app.musicplayer.MusicPlayer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

import static org.junit.jupiter.api.Assertions.assertNull;

public class RandomSongModTest {

    @Test
    public void RandomSongPlayed() throws InterruptedException, FindFailed {

        Screen screen = new Screen();
        ImagePath.add("test\\resources\\RandomSongModTest");
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
        Thread.sleep(2000);
        screen.click("playlist.png");
        Thread.sleep(500);
        screen.click("Random.png");
        Thread.sleep(1000);
        screen.click("PlayPlaylist.png");
        Thread.sleep(2000);
        screen.click("Next.png");
        Thread.sleep(2000);
        screen.click("Next.png");
        Thread.sleep(2000);
        screen.click("Next.png");
        Thread.sleep(2000);
        screen.click("Next.png");
        Thread.sleep(2000);
        //thread.stop();
    }
}
