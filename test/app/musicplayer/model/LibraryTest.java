package app.musicplayer.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {



    @Test
    void isSupportedFileTypeAsMP3() {
        boolean result = Library.isSupportedFileType("sound.mp3");
        assertTrue(result);
    }

    @Test
    void isSupportedFileTypeAsMP4() {
        boolean result = Library.isSupportedFileType("sound.mp4");
        assertTrue(result);
    }

    @Test
    void isSupportedFileTypeAsM4A() {
        boolean result = Library.isSupportedFileType("sound.m4a");
        assertTrue(result);
    }

    @Test
    void isSupportedFileTypeAsM4V() {
        boolean result = Library.isSupportedFileType("sound.m4v");
        assertTrue(result);
    }

    @Test
    void isSupportedFileTypeAsWAV() {
        boolean result = Library.isSupportedFileType("sound.wav");
        assertTrue(result);
    }

    @Test
    void isSupportedFileTypeAsEXE() {
        boolean result = Library.isSupportedFileType("sound.exe");
        assertFalse(result);
    }

}