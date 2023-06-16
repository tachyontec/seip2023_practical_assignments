package codeanalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static codeanalyzer.BufferSourceFile.createBufferedReader;

/**
 * This class provides a method to read a source file and return its contents as a list of strings.
 * It supports reading files from different locations specified by the location type.
 * <p>
 * By creating an instance of this we can read multiple files either from web or local machine,
 * but the instance will only return a List of Strings
 *</p>
 *
 * @author arisfetzian
 */
class ToListSourceFileReader {

    /**
     * Constructs a ToListSourceFileReader object.
     * Just creating the needed instances of other
     */
    public ToListSourceFileReader() {
    }

    /**
     * Reads a source file and returns its contents as a list of strings.
     *
     * @param filepath     the path or URL of the file
     * @param locationType the location type of the file ("local" for locally stored files, "web" for files stored on the web)
     * @return a list of strings containing the contents of the file
     * @throws IOException if an I/O error occurs while reading the file
     */

    protected List<String> read(String filepath, String locationType) throws IOException {
        BufferedReader reader = createBufferedReader(filepath, locationType);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }
}

