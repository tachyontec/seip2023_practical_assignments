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
    public static int factorial(int n) {
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
}
