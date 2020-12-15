import app.musicplayer.MusicPlayer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

import static org.junit.jupiter.api.Assertions.assertNull;

public class EliminateSongInPlaylist {

    @Test
    public void EliminateSong() throws InterruptedException, FindFailed {

        Screen screen = new Screen();
        ImagePath.add("test\\resources\\EliminateSongFromPlaylist");
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
        Thread.sleep(1000);
        screen.click("smooth.png");
        Thread.sleep(1000);
        screen.click("eliminateSong.png");
        Thread.sleep(1000);
        assertNull(screen.exists("smooth.png"));
        //thread.stop();
    }

}