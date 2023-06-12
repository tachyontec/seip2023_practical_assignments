package math;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * The FactorialTest class contains parameterized tests for the factorial method of the MyMath class.
 * It tests the factorial method with different input values and verifies the expected results.
 *
 * <p>Author: Your Name
 *
 * @author arisfetzian
 * @version 1.0
 * @since 2023-05-16
 */
@RunWith(Parameterized.class)
public class FactorialTest {

    private final int input;
    private final int expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 1},   // n = 0, factorial = 1
                {1, 1},   // n = 1, factorial = 1
                {2, 2},   // n = 2, factorial = 2
                {12, 479001600}  // n = 12, factorial = 479,001,600
        });
    }

    /**
     * Constructs a FactorialTest object with the given input and expected values.
     *
     * @param input    the input value for factorial calculation
     * @param expected the expected factorial result for the given input
     */
    public FactorialTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    /**
     * Test case for the factorial method.
     * Verifies that the factorial method returns the expected result for the given input.
     */
    @Test
    public void testFactorial() {
        MyMath myMath = new MyMath();
        int result = myMath.factorial(input);
        Assert.assertEquals(expected, result);
    }
}
