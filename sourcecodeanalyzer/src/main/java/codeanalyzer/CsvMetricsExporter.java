package codeanalyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implements the MetricsExporter interface to export metrics to a CSV file.
 * <p>
 * This class writes the metrics to a CSV file with the specified file path.
 * Each metric is represented as a key-value pair in the CSV file, with the metric name and value separated by a comma.
 * The metrics are written in two rows: the first row contains the metric names, and the second row contains the metric values.
 * </p>
 * Usage:
 * - Create an instance of CsvMetricsExporter.
 * - Call the `writeFile()` method, passing the metrics and the file path as parameters, to export the metrics to a CSV file.
 * Note: The file path should specify the desired location and name of the CSV file. The ".csv" extension will be appended automatically.
 */
class CsvMetricsExporter implements MetricsExporter {

    /**
     * Constructs a new CsvMetricsExporter object.
     */
    public CsvMetricsExporter() {

    }

    /**
     * Writes the metrics to a CSV file with the specified file path.
     *
     * @param metrics  a map containing the metrics (key-value pairs) to be exported
     * @param filepath the file path where the CSV file should be created
     */
    public void writeFile(Map<String, Integer> metrics, String filepath) {
        File outputFile = new File(filepath + ".csv");
        StringBuilder metricsNames = new StringBuilder();
        StringBuilder metricsValues = new StringBuilder();

        for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
            metricsNames.append(entry.getKey()).append(",");
            metricsValues.append(entry.getValue()).append(",");
        }

        try {
            FileWriter writer = new FileWriter(outputFile);
            writer.append(String.valueOf(metricsNames)).append("\n");
            writer.append(String.valueOf(metricsValues)).append("\n");
            writer.close();
            System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
