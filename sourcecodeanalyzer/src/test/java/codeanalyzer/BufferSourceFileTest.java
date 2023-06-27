package codeanalyzer;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class BufferSourceFileTest {

    @Test
    public void testCreateBufferedReader_LocalFile() throws IOException {
        String filepath = "src/test/resources/TestClass.java";
        String type = "local";

        BufferedReader reader = BufferSourceFile.createBufferedReader(filepath, type);

        assertNotNull(reader);
        reader.close();
    }

    @Test
    public void testCreateBufferedReader_WebFile() throws IOException {
        String filepath = "https://raw.githubusercontent.com/tachyontec/Troys_Quest/dev/src/main/java/main/game/Animation.java";
        String type = "web";

        BufferedReader reader = BufferSourceFile.createBufferedReader(filepath, type);

        assertNotNull(reader);
        reader.close();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateBufferedReader_InvalidType() throws IOException {
        String filepath = "src/test/resources/TestClass.java";
        String type = "invalid";

        BufferSourceFile.createBufferedReader(filepath, type);
    }

    @Test(expected = IOException.class)
    public void testCreateBufferedReader_InvalidFilePath() throws IOException {
        String filepath = "invalid/file/path";
        String type = "local";

        BufferSourceFile.createBufferedReader(filepath, type);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateBufferedReader_InvalidURL() throws IOException {
        String filepath = "htttps://google.com";
        String type = "web";

        try {
            BufferSourceFile.createBufferedReader(filepath, type);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IOException e) {
            if (e instanceof MalformedURLException) {
                assertEquals("The URL of the file is invalid or the file cannot be opened", e.getMessage());
            } else {
                fail("Expected IllegalArgumentException to be thrown");
            }
        }
    }

    @Test
    public void testBufferSourceFileInstantiation() {
        BufferSourceFile bufferSourceFile = new BufferSourceFile();
        assertNotNull(bufferSourceFile);
    }

}
