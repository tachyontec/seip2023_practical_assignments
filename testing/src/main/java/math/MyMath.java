package math;

/**
 * The MyMath class provides mathematical operations.
 * It includes a factorial method to calculate the factorial of a number.
 *
 * @author arisfetzian
 * @version 1.0
 * @since 2023-05-16
 */
public class MyMath {

    /**
     * Calculates and returns the factorial of a given number.
     *
     * @param n the number for which to calculate the factorial
     * @return the factorial of the given number
     * @throws IllegalArgumentException if n is less than 0 or greater than 12
     */
    public int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("Input should be between 0 and 12 (inclusive)");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * @param n the number which will be checked if prime or not
     * @return boolean value true/false -> determines if it is prime
     * @throws IllegalArgumentException if the number is less than 2
     */
    public boolean isPrime(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("Number must be greater than or equal to 2");
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

}
