package codeanalyzer;

import org.junit.Test;
import static org.junit.Assert.*;

public class SourceCodeAnalyzerFactoryTest {

    @Test
    public void testGetAnalyzerWithNullAnalyzerType() {
        SourceCodeAnalyzerFactory factory = new SourceCodeAnalyzerFactory();

        String analyzerType = null;
        try {
            factory.getAnalyzer(analyzerType);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("No source code analyzer type was given", e.getMessage());
        }
    }

    @Test
    public void testGetAnalyzerWithInvalidAnalyzerType() {
        SourceCodeAnalyzerFactory factory = new SourceCodeAnalyzerFactory();

        String analyzerType = "invalid";
        try {
            factory.getAnalyzer(analyzerType);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("The analyzer type requested is not available", e.getMessage());
        }
    }

    @Test
    public void testGetAnalyzerWithValidAnalyzerType() {
        SourceCodeAnalyzerFactory factory = new SourceCodeAnalyzerFactory();

        String analyzerType = "regex";
        SourceCodeAnalyzer analyzer = factory.getAnalyzer(analyzerType);
        assertTrue(analyzer instanceof RegexAnalyzer);

        analyzerType = "strcomp";
        analyzer = factory.getAnalyzer(analyzerType);
        assertTrue(analyzer instanceof StrCompAnalyzer);
    }

    private void assertEquals(String expected, String actual) {
        org.junit.Assert.assertEquals(expected, actual);
    }

    private void assertTrue(boolean condition) {
        org.junit.Assert.assertTrue(condition);
    }
}
