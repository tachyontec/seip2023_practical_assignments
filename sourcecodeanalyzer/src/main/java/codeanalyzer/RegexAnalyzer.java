package codeanalyzer;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The RegexAnalyzer class is used for source code analysis using the "regex" method.
 * It extends the abstract class SourceCodeAnalyzer and implements the required methods.
 * Usage:
 * - Create an instance of RegexAnalyzer.
 * - Use the calculateLOC(), calculateNOM(), and calculateNOC() methods to analyze source code files.
 */
public class RegexAnalyzer extends SourceCodeAnalyzer {

    /**
     * Creates a new instance of the RegexAnalyzer class.
     * Just an empty constructor since we don't need arguments.
     */
    public RegexAnalyzer() {
    }

    /**
     * Calculates the number of Lines of Code (LOC) in the given source code file.
     *
     * @param filepath     The path or URL of the source code file.
     * @param locationType The location type of the file (e.g., "local" or "web").
     * @return The number of Lines of Code (LOC) in the source code file.
     * @throws IOException if an I/O error occurs while reading the file.
     */
    public int calculateLOC(String filepath, String locationType) throws IOException {
        String sourceCode = sourceFileReaderFacade.readFileIntoString(filepath, locationType);
        Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

        int nonCodeLinesCounter = 0;
        while (nonCodeLinesMatcher.find()) {
            nonCodeLinesCounter++;
        }

        int sourceFileLength = sourceCode.split("\n").length;
        int loc = sourceFileLength - nonCodeLinesCounter;

        return loc;
    }

    /**
     * Calculates the number of Methods (NOM) in the given source code file.
     *
     * @param filepath     The path or URL of the source code file.
     * @param locationType The location type of the file (e.g., "local" or "web").
     * @return The number of Methods (NOM) in the source code file.
     * @throws IOException if an I/O error occurs while reading the file.
     */
    public int calculateNOM(String filepath, String locationType) throws IOException {
        String sourceCode = sourceFileReaderFacade.readFileIntoString(filepath, locationType);
        Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*");
        Matcher methodSignatures = pattern.matcher(sourceCode);

        int methodCounter = 0;
        while (methodSignatures.find()) {
            methodCounter++;
        }
        return methodCounter;
    }

    /**
     * Calculates the number of Classes (NOC) in the given source code file.
     *
     * @param filepath     The path or URL of the source code file.
     * @param locationType The location type of the file (e.g., "local" or "web").
     * @return The number of Classes (NOC) in the source code file.
     * @throws IOException if an I/O error occurs while reading the file.
     */
    public int calculateNOC(String filepath, String locationType) throws IOException {
        String sourceCode = sourceFileReaderFacade.readFileIntoString(filepath, locationType);
        Pattern pattern = Pattern.compile("(?<![/\\*])\\b(class)\\s+\\w+\\s*(<(?:[^<>]|<(?:[^<>]|[^<>]*?)*>)*>)?(?:\\s+(?:extends|implements)\\s+\\w+\\s*(?:<(?:[^<>]|<(?:[^<>]|[^<>]*?)*>)*>)?)*\\s*\\{");        Matcher classSignatures = pattern.matcher(sourceCode);

        int classCounter = 0;
        while (classSignatures.find()) {
            classCounter++;
        }
        return classCounter;
    }
}
