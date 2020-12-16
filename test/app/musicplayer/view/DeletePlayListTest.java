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
public class DeletePlayListTest {

    @Test
    public void PauseSong() throws InterruptedException, FindFailed {
        Screen screen = new Screen();
        ImagePath.add("test\\resources\\DeletePlayListTest");
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
        screen.click("New_Botton.png");
        Thread.sleep(2000);
        screen.click("Deselect.png");
        Thread.sleep(2000);
        screen.click("Select_botton.png");
        Thread.sleep(2000);
        screen.click("Delete_botton.png");
        Thread.sleep(2000);
        assertNotNull(screen.exists("Select_botton.png"));
    }
}
