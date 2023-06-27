

# MetricsExporter

The `MetricsExporter` interface defines the contract for exporting (writing) metrics to a specified output. It provides a single method, `writeFile()`, which takes a map of metrics and a filepath as parameters and writes the metrics to the specified output.

<B>
The factory pattern is used in the MetricsExporterFactory class to provide a centralized way of creating instances of the MetricsExporter interface. It encapsulates the creation logic and allows the client code to create a specific type of MetricsExporter without being aware of the concrete implementation.

For now, the only MetricsExporter is the CsvMetricsExporter, but this format make it easier for more types of metrics exporters to be added.

By using the factory pattern, the MetricsExporterFactory class provides a level of abstraction and flexibility. It abstracts the process of creating a MetricsExporter object from the client code, making it easier to manage and extend the system with new types of exporters in the future.</B>



## Methods

### `writeFile(Map<String, Integer> metrics, String filepath)`

Writes the metrics to the specified output location.

- `metrics`: A map containing the metrics to be exported, where the keys are metric names and the values are integers representing the metric values.
- `filepath`: The path of the output file where the metrics will be written.

# CsvMetricsExporter

The `CsvMetricsExporter` class is an implementation of the `MetricsExporter` interface. It exports metrics to a CSV (Comma-Separated Values) file format.

## Constructors

### `CsvMetricsExporter()`

Creates a new instance of the `CsvMetricsExporter` class.

## Methods

### `writeFile(Map<String, Integer> metrics, String filepath)`

Overrides the `writeFile()` method from the `MetricsExporter` interface. Writes the metrics to a CSV file at the specified output location.

- `metrics`: A map containing the metrics to be exported, where the keys are metric names and the values are integers representing the metric values.
- `filepath`: The path of the output file where the metrics will be written.

# MetricsExporterFactory

The `MetricsExporterFactory` class is a factory class that creates instances of `MetricsExporter` based on the specified output type.

## Methods

### `getExporter(String outputType)`

Returns an instance of `MetricsExporter` based on the specified output type.

- `outputType`: The desired output type for the `MetricsExporter`. Currently, only "csv" is supported.
- Returns: An instance of `MetricsExporter` that corresponds to the specified output type.
- Throws: `IllegalArgumentException` if the specified output type is not supported.

## Usage

1. Create an instance of `MetricsExporterFactory`.
2. Call the `getExporter()` method on the factory instance, passing the desired output type as a parameter.
3. The method will return an instance of `MetricsExporter` based on the specified output type.
4. Use the returned `MetricsExporter` object to export metrics to the desired output.

---


## SourceCodeAnalyzer

The `SourceCodeAnalyzer` class is an abstract class that serves as the base for specific source code analyzer implementations. It provides methods to calculate LOC, NOM, and NOC based on the analysis requirements. This class supports two types of source code analysis: Regex and StrComp. It requires its own reader functionality to read source code files.

### Usage

- Extend this class to create a specific SourceCodeAnalyzer implementation.
- Implement the `calculateLOC()`, `calculateNOM()`, and `calculateNOC()` methods based on the analysis requirements.
- Use the `SourceFileReaderFacade` to read source code files and retrieve their contents.

## SourceCodeAnalyzerFactory

The `SourceCodeAnalyzerFactory` class is a factory class responsible for creating instances of `SourceCodeAnalyzer` based on the requested analyzer type. It provides a method `getAnalyzer()` that takes the analyzer type as a parameter and returns the corresponding analyzer instance.

### Usage

- Call the `getAnalyzer()` method of the factory class, providing the desired analyzer type ("regex" or "strcomp").
- The factory will return an instance of `SourceCodeAnalyzer` based on the analyzer type.

## RegexAnalyzer

The `RegexAnalyzer` class is a concrete implementation of `SourceCodeAnalyzer` that performs source code analysis using the "regex" method. It calculates LOC, NOM, and NOC metrics based on regular expressions. It utilizes the `SourceFileReaderFacade` for file reading operations.

### Usage

- Create an instance of `RegexAnalyzer`.
- Use the `calculateLOC()`, `calculateNOM()`, and `calculateNOC()` methods to analyze source code files.

## StrCompAnalyzer

The `StrCompAnalyzer` class is another concrete implementation of `SourceCodeAnalyzer` that performs source code analysis using the string comparison method ("strcomp"). It calculates LOC, NOM, and NOC metrics by comparing strings. It also utilizes the `SourceFileReaderFacade` for file reading operations.

### Usage

- Create an instance of `StrCompAnalyzer`.
- Use the `calculateLOC()`, `calculateNOM()`, and `calculateNOC()` methods to analyze source code files.

---





# Source File Reader Classes

The `codeanalyzer` package offers a set of classes designed to simplify the process of reading source files in Java projects. These classes employ the **Facade pattern** to abstract away complexities and provide a streamlined interface.
Here we use the Facade pattern.
## Facade Pattern: Simplifying Complexity

The Facade pattern serves as a means to simplify intricate operations. In this context, the `SourceFileReaderFacade` class acts as a facilitator, allowing convenient access to file reading functionality while shielding users from underlying complexities.

## `ToStringSourceFileReader`

The `ToStringSourceFileReader` class serves as a capable tool for retrieving the contents of a source file and representing them as a single string. It provides a straightforward mechanism for transforming file contents into usable text format.

## `ToListSourceFileReader`

With the `ToListSourceFileReader` class, the focus is on organization. It enables the retrieval of source file contents as a list of strings, facilitating the handling of individual lines or segments within the file.

## `SourceFileReaderFacade`

The true hero of the package, the `SourceFileReaderFacade` class, acts as the main facade for reading source files. By encapsulating complex file reading operations, it presents a simplified interface for users to obtain file contents effortlessly.

The `SourceFileReaderFacade` class provides the following advantages:
- Streamlined utilization of file reading functionality.
- Abstraction of implementation details of file reading classes.
- Improved code maintainability and organization.
- Flexibility for future enhancements and addition of new file reading capabilities.

These source file reader classes serve as a convenient solution for reading and accessing source file contents in Java projects. Whether processing the file's contents, performing analysis, or any other relevant tasks, these classes offer an efficient approach to working with source files.

# BufferSourceFile

The `BufferSourceFile` class provides a utility method to create a `BufferedReader` for reading a file from either a local path or a URL.

## Usage

To use the `BufferSourceFile` class, follow these steps:

1. Call the static method `createBufferedReader()` to obtain a `BufferedReader` for the requested file.
    - The `filepath` parameter should be a valid file path or URL.
    - The `type` parameter should be either "web" or "local" to indicate the file's location.
2. Handle the returned `BufferedReader` to read the contents of the file.

This class is used so we can read the input file in a different class, avoiding previous code repetitions.