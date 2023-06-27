package codeanalyzer;

import java.io.IOException;
import java.util.List;

/**
 * This class implements the SourceCodeAnalyzer interface to analyze the contents of a Java source code file
 * using the string comparison method ("strcomp").
 * It calculates the following metrics: LOC (lines of code), NOM (number of methods), and NOC (number of classes).
 * It utilizes the SourceFileReaderFacade for file reading operations.
 * <p>
 * Note: This class extends the SourceCodeAnalyzer abstract class and provides implementations for the abstract methods.
 * The main purpose of this class is to analyze source code using the string comparison method.
 * </p>
 * <p>
 * Usage:
 * - Create an instance of StrCompAnalyzer.
 * - Call the calculateLOC() method to calculate the lines of code metric.
 * - Call the calculateNOM() method to calculate the number of methods metric.
 * - Call the calculateNOC() method to calculate the number of classes metric.
 * </p>
 */
public class StrCompAnalyzer extends SourceCodeAnalyzer {

    /**
     * Constructs a StrCompAnalyzer object.
     */
    public StrCompAnalyzer() {

    }

    /**
     * Calculates the lines of code (LOC) metric for a given source code file.
     *
     * @param filepath      the path or URL of the source code file
     * @param locationType  the location type of the file (local or web)
     * @return the lines of code metric
     * @throws IOException if an I/O error occurs while reading the file
     */
    public int calculateLOC(String filepath, String locationType) throws IOException {
        List<String> sourceCodeList = sourceFileReaderFacade.readFileIntoList(filepath, locationType);
        int nonCodeLinesCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); // clear all leading and trailing white spaces
            if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
                nonCodeLinesCounter++;
        }
        int loc = sourceCodeList.size() - nonCodeLinesCounter;
        return loc;
    }

    /**
     * Calculates the number of methods (NOM) metric for a given source code file.
     *
     * @param filepath      the path or URL of the source code file
     * @param locationType  the location type of the file (local or web)
     * @return the number of methods metric
     * @throws IOException if an I/O error occurs while reading the file
     */
    public int calculateNOM(String filepath, String locationType) throws IOException {
        List<String> sourceCodeList = sourceFileReaderFacade.readFileIntoList(filepath, locationType);
        int methodCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); // clear all leading and trailing white spaces
            if (((line.contains("public") || line.contains("private") || line.contains("protected"))
                    || line.contains("void") || line.contains("int") || line.contains("String"))
                    && line.contains("(") && line.contains(")") && line.contains("{"))
                methodCounter++;
        }
        return methodCounter;
    }

    /**
     * Calculates the number of classes (NOC) metric for a given source code file.
     *
     * @param filepath      the path or URL of the source code file
     * @param locationType  the location type of the file (local or web)
     * @return the number of classes metric
     * @throws IOException if an I/O error occurs while reading the file
     */
    public int calculateNOC(String filepath, String locationType) throws IOException {
        List<String> sourceCodeList = sourceFileReaderFacade.readFileIntoList(filepath, locationType);
        int classCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); // remove leading and trailing white spaces
            if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
                classCounter++;
            }
        }
        return classCounter;
    }
}
