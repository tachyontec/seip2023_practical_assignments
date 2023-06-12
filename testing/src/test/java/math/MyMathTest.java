package math;

import org.junit.Assert;
import org.junit.Test;

public class MyMathTest {
    private MyMath myMath = new MyMath();

    @Test
    public void testFactorial_Zero() {
        int n = 0;
        int expectedFactorial = 1;
        int actualFactorial = myMath.factorial(n);
        Assert.assertEquals(expectedFactorial, actualFactorial);
    }

    @Test
    public void testFactorial_PositiveNumber() {
        int n = 5;
        int expectedFactorial = 120;
        int actualFactorial = myMath.factorial(n);
        Assert.assertEquals(expectedFactorial, actualFactorial);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorial_NegativeNumber() {
        int n = -3;
        myMath.factorial(n);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorial_LargeNumber() {
        int n = 15;
        myMath.factorial(n);
    }

    @Test
    public void testIsPrime_PrimeNumber() {
        int primeNumber = 13;
        boolean result = myMath.isPrime(primeNumber);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsPrime_NonPrimeNumber() {
        int nonPrimeNumber = 15;
        boolean result = myMath.isPrime(nonPrimeNumber);
        Assert.assertFalse(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsPrime_NumberLessThanTwo() {
        int numberLessThanTwo = 1;
        myMath.isPrime(numberLessThanTwo);
    }
}