package math;

import io.FileIO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertArrayEquals;

public class ArrayOperationsTest {

    @Mock
    private FileIO mockFileIO;

    @Mock
    private MyMath mockMyMath;

    private ArrayOperations arrayOperations;

    @Before
    public void setUp() {
        arrayOperations = new ArrayOperations();
        mockFileIO = Mockito.mock(FileIO.class);
        mockMyMath = Mockito.mock(MyMath.class);
    }

    @Test
    public void testFindPrimesInFile() {
        int[] numbers = {2, 3, 4, 5, 6, 7};
        String filepath = "arrayoperationstest.txt";
        int[] expectedPrimes = {2, 3, 5, 7};

        Mockito.when(mockFileIO.readFile(filepath)).thenReturn(numbers);
        Mockito.when(mockMyMath.isPrime(2)).thenReturn(true);
        Mockito.when(mockMyMath.isPrime(3)).thenReturn(true);
        Mockito.when(mockMyMath.isPrime(4)).thenReturn(false);
        Mockito.when(mockMyMath.isPrime(5)).thenReturn(true);
        Mockito.when(mockMyMath.isPrime(7)).thenReturn(true);

        int[] primes = arrayOperations.findPrimesInFile(mockFileIO, filepath, mockMyMath);

        assertArrayEquals(expectedPrimes, primes);
    }
}
