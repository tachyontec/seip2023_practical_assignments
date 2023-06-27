package codeanalyzer;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CsvMetricsExporterTest {

    @Test
    public void testWriteFile() {
        Map<String, Integer> metrics = new HashMap<>();
        metrics.put("Metric1", 10);
        metrics.put("Metric2", 20);
        metrics.put("Metric3", 30);
        String filepath = "src/test/resources/test_metrics";

        CsvMetricsExporter exporter = new CsvMetricsExporter();
        exporter.writeFile(metrics, filepath);

        try {
            String expectedFileContent = "Metric1,Metric3,Metric2,\n10,30,20,\n";
            String actualFileContent = readFileAsString(filepath + ".csv");

            assertEquals(expectedFileContent, actualFileContent);
        } catch (IOException e) {
            fail("Exception thrown while reading the file: " + e.getMessage());
        }
    }

    private String readFileAsString(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }

        reader.close();
        return content.toString();
    }
}
