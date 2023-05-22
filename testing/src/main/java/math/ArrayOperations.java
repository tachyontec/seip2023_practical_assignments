package math;

import java.util.ArrayList;
import java.util.List;
import io.FileIO;

/**
 * The ArrayOperations class provides operations on arrays of numbers.
 * It includes a method to find prime numbers in an array using FileIO and MyMath classes.
 *
 * @author arisfetzian
 * @version 1.0
 * @since 2023-5-20
 */
public class ArrayOperations {

    /**
     * Finds the prime numbers in an array of numbers read from a file.
     *
     * @param fileIo the FileIO object to read the file
     * @param filepath the path of the file to read
     * @param myMath the MyMath object to check if a number is prime
     * @return an array containing the prime numbers from the file
     */
    public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
        int[] numbers = fileIo.readFile(filepath);
        List<Integer> primeNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (myMath.isPrime(number)) {
                primeNumbers.add(number);
            }
        }

        return primeNumbers.stream().mapToInt(Integer::intValue).toArray();
    }
}

