package demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import codeanalyzer.*;

public class DemoClient {

    public static void main(String[] args) throws IOException {
        String filepath = "src/main/resources/TestClass.java";
        String sourceCodeAnalyzerType = "regex";
        String sourceFileLocation = "local";
        String outputFilePath = "output_metrics";
        String outputFileType = "csv";

        if (args.length == 5) {
            filepath = args[0];
            sourceCodeAnalyzerType = args[1];
            sourceFileLocation = args[2];
            outputFilePath = args[3];
            outputFileType = args[4];
        } else if (args.length != 0) {
            System.out.println("Incorrect number of arguments.");
            System.exit(1);
        }

        SourceCodeAnalyzerFactory sourceCodeAnalyzerFactory = new SourceCodeAnalyzerFactory();
        // RegexAnalyzer/StrCompAnalyzer
        SourceCodeAnalyzer analyzer = sourceCodeAnalyzerFactory.getAnalyzer(sourceCodeAnalyzerType);
        //Now we have chose the analyzer that will do regex or strcomp

        //To this analyzer we need to specify if we want to pass local or web file
        int loc = analyzer.calculateLOC(filepath,sourceFileLocation);
        int nom = analyzer.calculateNOM(filepath,sourceFileLocation);
        int noc = analyzer.calculateNOC(filepath,sourceFileLocation);

        Map<String, Integer> metrics = new HashMap<>();
        metrics.put("loc", loc);
        metrics.put("nom", nom);
        metrics.put("noc", noc);

        MetricsExporterFactory exporterFactory = new MetricsExporterFactory();
        MetricsExporter metricsExporter = exporterFactory.getExporter(outputFileType); //get the needed exporter type
        metricsExporter.writeFile(metrics, outputFilePath); //finally write metrics
    }

}
