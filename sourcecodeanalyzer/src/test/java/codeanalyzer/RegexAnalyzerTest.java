package codeanalyzer;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RegexAnalyzerTest {
    private RegexAnalyzer regexAnalyzer;

    @Before
    public void setUp() {
        regexAnalyzer = new RegexAnalyzer();
    }

    @Test
    public void testCalculateLOC_LocalFile() throws IOException {
        String filepath = "src/test/resources/TestClass.java";
        String locationType = "local";
        int expectedLOC = 21;

        int loc = regexAnalyzer.calculateLOC(filepath, locationType);

        assertEquals(expectedLOC, loc);
    }

    @Test
    public void testCalculateLOC_WebFile() throws IOException {
        String filepath = "https://raw.githubusercontent.com/tachyontec/Troys_Quest/dev/src/main/java/main/game/Animation.java";
        String locationType = "web";
        int expectedLOC = 42;

        int loc = regexAnalyzer.calculateLOC(filepath, locationType);

        assertEquals(expectedLOC, loc);
    }

    @Test
    public void testCalculateNOM_LocalFile() throws IOException {
        String filepath = "src/test/resources/TestClass.java";
        String locationType = "local";
        int expectedNOM = 3;

        int nom = regexAnalyzer.calculateNOM(filepath, locationType);

        assertEquals(expectedNOM, nom);
    }

    @Test
    public void testCalculateNOM_WebFile() throws IOException {
        String filepath = "https://raw.githubusercontent.com/tachyontec/Troys_Quest/dev/src/main/java/main/game/Animation.java";
        String locationType = "web";
        int expectedNOM = 5;

        int nom = regexAnalyzer.calculateNOM(filepath, locationType);

        assertEquals(expectedNOM, nom);
    }

    @Test
    public void testCalculateNOC_LocalFile() throws IOException {
        String filepath = "src/test/resources/TestClass.java";
        String locationType = "local";
        int expectedNOC = 3;

        int noc = regexAnalyzer.calculateNOC(filepath, locationType);

        assertEquals(expectedNOC, noc);
    }

    @Test
    public void testCalculateNOC_WebFile() throws IOException {
        String filepath = "https://raw.githubusercontent.com/tachyontec/Troys_Quest/dev/src/main/java/main/game/Animation.java";
        String locationType = "web";
        int expectedNOC = 1;

        int noc = regexAnalyzer.calculateNOC(filepath, locationType);

        assertEquals(expectedNOC, noc);
    }
}
