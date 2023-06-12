package io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;

import java.net.URL;

import static org.junit.Assert.assertArrayEquals;

public class FileIOTest {

    private FileIO fileIO;

    @Before
    public void setUp() {
        fileIO = new FileIO();
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testReadFile_NormalCase() {
        String filepath = getResourcePath("numbers.txt");
        int[] expectedNumbers = {1, 2, 3, 4, 5};

        int[] actualNumbers = fileIO.readFile(filepath);

        assertArrayEquals(expectedNumbers, actualNumbers);
    }

    @Test
    public void testReadFile_EmptyFile() {
        String filepath = getResourcePath("empty.txt");
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Given file is empty");

        fileIO.readFile(filepath);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReadFile_NonExistent() {
        fileIO.readFile("nonexistent");
        exceptionRule.expectMessage("Input file does not exist");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testInvalidEntries() {
        fileIO.readFile("invalid_entries.txt");
        exceptionRule.expectMessage("Given file does not contain valid integer numbers");
    }

    @Test
    public void testReadFile_InvalidEntry() {
        String filepath = getResourcePath("invalid_entries.txt");
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Given file does not contain valid integer numbers");

        fileIO.readFile(filepath);
    }


    private String getResourcePath(String fileName) {
        URL resourceUrl = getClass().getClassLoader().getResource(fileName);
        if (resourceUrl != null) {
            return resourceUrl.getPath();
        }
        return null;
    }

}
