package codeanalyzer;

/**
 * Factory class for creating MetricsExporter objects based on the output type.
 * <p>
 * This class provides a method to create an instance of MetricsExporter based on the specified output type.
 * </p>
 * Usage:
 * - Create an instance of MetricsExporterFactory.
 * - Call the `getExporter()` method, passing the desired output type as a parameter, to obtain the appropriate MetricsExporter object.
 * - The supported output types are "csv".
 * Note: If an unsupported output type is requested, an IllegalArgumentException will be thrown.
 */
public class MetricsExporterFactory {

    /**
     * Returns an instance of MetricsExporter based on the specified output type.
     *
     * @param outputType the output type of the MetricsExporter to create
     * @return a MetricsExporter object based on the specified output type
     * @throws IllegalArgumentException if the specified output type is not supported
     */
    public MetricsExporter getExporter(String outputType) {
        if (outputType == null) {
            throw new IllegalArgumentException("No outpput type given");
        }
        if (outputType.equals("csv")) {
            return new CsvMetricsExporter();
        }
        throw new IllegalArgumentException("The output type requested is not available");
    }
}

