package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StrCompAnalyzerTest {

    @Test
    public void testCalculateLOC() throws IOException {
        StrCompAnalyzer analyzer = new StrCompAnalyzer();
        String filepath = "src/test/resources/AnalyzerClass.java";
        String locationType = "local";

        int loc = analyzer.calculateLOC(filepath, locationType);

        // Assert that the LOC value is correct based on the actual number of lines of code
        Assert.assertEquals(11, loc);
    }

    @Test
    public void testCalculateNOM() throws IOException {
        StrCompAnalyzer analyzer = new StrCompAnalyzer();
        String filepath = "src/test/resources/AnalyzerClass.java";
        String locationType = "local";

        int nom = analyzer.calculateNOM(filepath, locationType);

        // Assert that the NOM value is correct based on the actual number of methods
        Assert.assertEquals(6, nom);
    }

    @Test
    public void testCalculateNOC() throws IOException {
        StrCompAnalyzer analyzer = new StrCompAnalyzer();
        String filepath = "src/test/resources/AnalyzerClass.java";
        String locationType = "local";

        int noc = analyzer.calculateNOC(filepath, locationType);

        // Assert that the NOC value is correct based on the actual number of classes
        Assert.assertEquals(2, noc);
    }
}
