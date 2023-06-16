package codeanalyzer;

import java.io.IOException;

/**
 * Analyzes the contents of a Java source code file and calculates the following metrics:
 * - LOC: Lines of Code
 * - NOM: Number of Methods
 * - NOC: Number of Classes
 * <p>
 * This class supports two types of source code analysis:
 * - Regex: Analysis using regular expressions
 * - StrComp: Analysis using string comparison
 * <p>
 * This class is designed as an abstract class instead of an interface because all SourceCodeAnalyzers
 * require their own reader functionality.
 * <p>
 * Usage:
 * - Extend this class to create a specific SourceCodeAnalyzer implementation.
 * - Implement the calculateLOC(), calculateNOM(), and calculateNOC() methods based on the analysis requirements.
 * - Use the SourceFileReaderFacade to read source code files and retrieve their contents.
 *
 * @author arisfetzian
 */
public abstract class SourceCodeAnalyzer {

    SourceFileReaderFacade sourceFileReaderFacade;

    /**
     * Creates a new instance of the SourceCodeAnalyzer class.
     * Initializes the SourceFileReaderFacade for reading source code files.
     */
    public SourceCodeAnalyzer() {
        this.sourceFileReaderFacade = new SourceFileReaderFacade();
    }

    /**
     * Calculates the number of lines of code (LOC) in the specified source code file.
     *
     * @param filepath     The path or URL of the source code file.
     * @param locationType The type of location for the source code file (local or web).
     * @return The number of lines of code in the source code file.
     * @throws IOException if an I/O error occurs while reading the file.
     */
    public abstract int calculateLOC(String filepath, String locationType) throws IOException;

    /**
     * Calculates the number of methods (NOM) in the specified source code file.
     *
     * @param filepath     The path or URL of the source code file.
     * @param locationType The type of location for the source code file (local or web).
     * @return The number of methods in the source code file.
     * @throws IOException if an I/O error occurs while reading the file.
     */
    public abstract int calculateNOM(String filepath, String locationType) throws IOException;

    /**
     * Calculates the number of classes (NOC) in the specified source code file.
     *
     * @param filepath     The path or URL of the source code file.
     * @param locationType The type of location for the source code file (local or web).
     * @return The number of classes in the source code file.
     * @throws IOException if an I/O error occurs while reading the file.
     */
    public abstract int calculateNOC(String filepath, String locationType) throws IOException;
}
