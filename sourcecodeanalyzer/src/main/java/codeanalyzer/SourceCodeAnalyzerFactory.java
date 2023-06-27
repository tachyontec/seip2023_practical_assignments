package codeanalyzer;

/**
 * This class represents a factory for creating instances of {@link SourceCodeAnalyzer}.
 * It provides a method to get an analyzer based on the requested analyzer type.
 */
public class SourceCodeAnalyzerFactory {

    /**
     * Returns an instance of {@link SourceCodeAnalyzer} based on the provided analyzer type.
     *
     * @param sourceCodeAnalyzerType the type of source code analyzer to get
     * @return an instance of {@link SourceCodeAnalyzer} based on the analyzer type
     * @throws IllegalArgumentException if the source code analyzer type is null or not recognized
     */
    public SourceCodeAnalyzer getAnalyzer(String sourceCodeAnalyzerType) {
        if (sourceCodeAnalyzerType == null) {
            throw new IllegalArgumentException("No source code analyzer type was given");
        }
        if (sourceCodeAnalyzerType.equals("regex")) {
            return new RegexAnalyzer();
        } else if (sourceCodeAnalyzerType.equals("strcomp")) {
            return new StrCompAnalyzer();
        }
        throw new IllegalArgumentException("The analyzer type requested is not available");
    }
}
