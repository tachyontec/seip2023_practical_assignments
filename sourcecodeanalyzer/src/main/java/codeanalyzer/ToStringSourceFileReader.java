package codeanalyzer;

import java.io.BufferedReader;
import java.io.IOException;

import static codeanalyzer.BufferSourceFile.createBufferedReader;

/**
 * This class provides a method to read a source file and return its contents as a single string.
 * It supports reading files from different locations specified by the location type.
 *
 * @author arisfetzian
 */
class ToStringSourceFileReader {

    /**
     * Constructs a ToStringSourceFileReader object.
     * Just an empty constructor since we don't need arguments.
     */
    protected ToStringSourceFileReader() {
    }

    /**
     * Reads a source file and returns its contents as a single string.
     *
     * @param filepath     the path or URL of the file
     * @param locationType the location type of the file ("local" for locally stored files, "web" for files stored on the web)
     * @return a string containing the contents of the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    protected String read(String filepath, String locationType) throws IOException {
        BufferedReader reader = createBufferedReader(filepath, locationType);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }
}

