package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MetricsExporterTest {

    @Test
    public void testWriteFile() {
        // Create a mock MetricsExporter implementation for testing
        MetricsExporter exporter = new MetricsExporter() {
            @Override
            public void writeFile(Map<String, Integer> metrics, String filepath) {
                // Mock implementation
                System.out.println("Writing metrics to file: " + filepath);
            }
        };

        // Prepare sample metrics data
        Map<String, Integer> metrics = new HashMap<>();
        metrics.put("LOC", 100);
        metrics.put("NOM", 5);
        metrics.put("NOC", 2);

        // Define the expected output file path
        String expectedFilepath = "output.csv";

        // Call the writeFile method and assert the behavior
        try {
            exporter.writeFile(metrics, expectedFilepath);
        } catch (Exception e) {
            Assert.fail("Exception occurred: " + e.getMessage());
        }
        // Add additional assertions if needed
    }
}
