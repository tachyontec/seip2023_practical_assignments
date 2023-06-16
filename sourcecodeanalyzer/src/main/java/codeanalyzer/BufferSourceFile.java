package codeanalyzer;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Provides a utility method to create a BufferedReader for reading a file from either a local path or a URL.
 * <p>
 * This class contains a static method that creates a BufferedReader based on the provided file path and type.
 * The type can be either "web" or "local", indicating whether the file will be read from a URL or a local path.
 * </p>
 * Usage:
 * - Call the static method `createBufferedReader()` to obtain a BufferedReader for the requested file.
 * Note: The provided file path should be a valid path or URL, and the type should be either "web" or "local".
 *
 * @author arisfetzian
 */
public class BufferSourceFile {

    /**
     * Creates a BufferedReader for reading a file from the provided file path or URL.
     *
     * @param filepath The path or URL of the file to read.
     * @param type     The type of file location, either "web" or "local".
     * @return A BufferedReader for the requested file.
     * @throws IOException              if an I/O error occurs while opening the file or URL.
     * @throws IllegalArgumentException if the file location type is not recognized or the file cannot be opened.
     */
    public static BufferedReader createBufferedReader(String filepath, String type) throws IOException {
        if (type.equals("web")) {
            try {
                URL url = new URL(filepath);
                return new BufferedReader(new InputStreamReader(url.openStream()));
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException("The URL of the file is invalid or the file cannot be opened");
            }
        } else if (type.equals("local")) {
            File file = new File(filepath);
            return new BufferedReader(new FileReader(file));
        } else {
            throw new IllegalArgumentException("The file location should be either 'web' or 'local'");
        }
    }
}
