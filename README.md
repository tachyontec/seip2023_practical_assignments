![Workflow Status](https://github.com/tachyontec/seip2023_practical_assignments/actions/workflows/maven.yml/badge.svg)


# lab_software_tech
Repository used for the lab of the "Applied Software Engineering" course

seip2023_practical_assignments
=

This is a parent project containing other maven modules
<ol>


<h1><li>gradeshistogram</li></h1>

Usage:

Navigate to the module directory:
    
    cd seip2023_practical_assignments/gradeshistogram
    
Build & run:
    
    mvn package
    java -jar target/gradeshistogram-1.0-SNAPSHOT.jar <argument>

Where argument can be the absolute or relative path of the input file


<h1><li>testing</li></h1>



For specific details and instructions, please refer to the [Individual README](testing/testing-readme.md) file.

<h1><li>sourcecodeanalyzer</li></h1>

# Java Code Metrics Calculator

This software system reads a Java source code file, calculates the Lines of Code (LOC), Number of Classes (NOC), and Number of Methods (NOM) metrics, and exports these metrics to an output file.

## Features

- Calculates the Lines of Code (LOC) metric for a Java source code file.
- Calculates the Number of Classes (NOC) metric for a Java source code file.
- Calculates the Number of Methods (NOM) metric for a Java source code file.
- Supports both local and web-based Java source code files.
- Exports the calculated metrics to an output file.

## Prerequisites

- Java Development Kit (JDK) version X or higher
- Apache Maven build tool version X or higher

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/java-code-metrics-calculator.git

2. Build the project using Maven:

   ```bash
   cd java-code-metrics-calculator
   mvn clean install

3. Run:

   ```bash
   java -jar "jar-with-dependencies" arg0 arg1 arg2 arg3 arg4

Where:

- `arg0`: "JavaSourceCodeInputFile" (e.g., `src/test/resources/TestClass.java`)
- `arg1`: "sourceCodeAnalyzerType" \[regex|strcomp\]
- `arg2`: "SourceCodeLocationType" \[local|web\]
- `arg3`: "OutputFilePath" (e.g., `../output_metrics_file`)
- `arg4`: "OutputFileType" \[csv|json\]

For specific details and instructions, please refer to the [Individual README](sourcecodeanalyzer/sourcecodeanalyzer-readme.md) file.
