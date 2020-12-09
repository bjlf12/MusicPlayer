package app.musicplayer.view;

import app.musicplayer.MusicPlayer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)
public class CreatePlaylistTest {

    @Test
    public void CreatePlaylist() throws FindFailed, InterruptedException {
        Screen screen = new Screen();
        ImagePath.add("test\\resources\\CreatePlayList");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                new JFXPanel(); // Initializes the JavaFx Platform
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
        screen.click("newPlaylist.png");
        Thread.sleep(100);
        screen.click("name.png");
        screen.type("test" + Key.ENTER);
        Thread.sleep(100);
        assertNotNull(screen.exists("create.png"));
    }
}
