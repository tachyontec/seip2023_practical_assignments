package codeanalyzer;

import java.io.IOException;
import java.util.List;

/**
 * This class retrieves (reads) the contents of a given file.
 * The file can be stored locally or exist on the web.
 * It provides methods to read the file into a list of strings
 * or a single string.
 * <p>
 * All actions for reading source files will be done here using the Facade pattern,
 * hiding the {@link ToListSourceFileReader} and {@link ToStringSourceFileReader} from
 * outside the package.
 * </p>
 *
 * @author arisfetzian
 */
class SourceFileReaderFacade {

    ToListSourceFileReader toListSourceFileReader;
    ToStringSourceFileReader toStringSourceFileReader;

    /**
     * Constructs a new SourceFileReaderFacade object.
     * Initializes the internal instances of ToListSourceFileReader and ToStringSourceFileReader.
     */
    public SourceFileReaderFacade() {
        this.toListSourceFileReader = new ToListSourceFileReader();
        this.toStringSourceFileReader = new ToStringSourceFileReader();
    }

    /**
     * Reads a file and returns its content as a list of strings.
     *
     * @param filepath     the path or URL of the file
     * @param locationType the type of location where the file is stored (e.g., "local" or "web").
     * @return a list of strings containing the file's contents,
     *         or an empty list if the file is empty or cannot be read
     * @throws IOException if an I/O error occurs while reading the file
     */
    public List<String> readFileIntoList(String filepath, String locationType) throws IOException {
        ToListSourceFileReader toListSourceFileReader = new ToListSourceFileReader();
        return toListSourceFileReader.read(filepath, locationType);
    }

    /**
     * Reads a file and returns its content as a single string.
     *
     * @param filepath     the path or URL of the file
     * @param locationType the type of location where the file is stored (e.g., "local" or "web").
     * @return a string containing the file's contents,
     *         or an empty string if the file is empty or cannot be read
     * @throws IOException if an I/O error occurs while reading the file
     */
    public String readFileIntoString(String filepath, String locationType) throws IOException {
        ToStringSourceFileReader toStringSourceFileReader = new ToStringSourceFileReader();
        return toStringSourceFileReader.read(filepath, locationType);
    }
}
