package codeanalyzer;

import org.junit.Test;

import static org.junit.Assert.*;

public class MetricsExporterFactoryTest {

    @Test
    public void testGetExporter() {
        // Create an instance of MetricsExporterFactory
        MetricsExporterFactory factory = new MetricsExporterFactory();

        // Test case 1: Output type "csv"
        String outputType1 = "csv";
        MetricsExporter exporter1 = factory.getExporter(outputType1);
        assertTrue(exporter1 instanceof CsvMetricsExporter);

        // Test case 2: Unsupported output type
        String outputType2 = "json";
        try {
            MetricsExporter exporter2 = factory.getExporter(outputType2);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("The output type requested is not available", e.getMessage());
        }
    }


    @Test
    public void testGetExporterWithNullOutputType() {
        // Create an instance of MetricsExporterFactory
        MetricsExporterFactory factory = new MetricsExporterFactory();

        // Test case: Output type is null
        String outputType = null;
        try {
            factory.getExporter(null);
        } catch (IllegalArgumentException e) {
            assertEquals("No outpput type given", e.getMessage());
        }
    }
}
