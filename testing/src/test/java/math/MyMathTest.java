package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * The MyMathTest class contains test cases for the MyMath class.
 *
 * @author arisfetzian
 * @version 1.0
 * @since 2023-05-16
 */
public class MyMathTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testFactorialValidInput() {
        // Test valid input and expected output
        int result1 = MyMath.factorial(0);
        Assert.assertEquals(1, result1);

        int result2 = MyMath.factorial(5);
        Assert.assertEquals(120, result2);

        int result3 = MyMath.factorial(12);
        Assert.assertEquals(479001600, result3);
    }

    @Test
    public void testFactorialNegativeInput() {
        // Test negative input, expect IllegalArgumentException
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Input should be between 0 and 12 (inclusive)");

        MyMath.factorial(-5);
    }

    @Test
    public void testFactorialLargeInput() {
        // Test input exceeding the allowed range, expect IllegalArgumentException
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Input should be between 0 and 12 (inclusive)");

        MyMath.factorial(15);
    }
}

