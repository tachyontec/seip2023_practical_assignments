package codeanalyzer;

import java.util.Map;

/**
 * Exports (writes) the metrics to a given output.
 * The output can be CSV or JSON files.
 *<p>
 * This interface defines a method to write the metrics to a file. The metrics are represented as a Map
 * with metric names as keys and corresponding integer values.
 * Implementations of this interface should handle the logic for writing the metrics to the specified output file.
 *</p>
 * <p>
 * Usage:
 * - Implement this interface to create a custom metrics exporter.
 * - Override the `writeFile()` method to define the logic for writing the metrics.
 * - Use the implemented exporter to export metrics to a file.
 * </p>
 *
 *
 * <p>
 * Implementing classes should handle the format of the output file (CSV, JSON, etc.) and ensure that
 * the metrics are written correctly according to the chosen format.
 *</p>
 * @author arisfetzian
 */
public interface MetricsExporter {

    /**
     * Writes the metrics to a given output file.
     *
     * @param metrics   The metrics to be written. It is represented as a Map with metric names as keys
     *                  and corresponding integer values.
     * @param filepath  The path or name of the output file.
     *                  The format of the file (e.g., CSV, JSON) should be determined by the implementing class.
     */
    void writeFile(Map<String, Integer> metrics, String filepath);
}

