package math;

import org.junit.Assert;
import org.junit.rules.ExpectedException;
import org.junit.Test;
import org.junit.Rule;

/**
 * The ArithmeticOperationsTest class provides tests for the ArithmeticsOperationsClass
 * for division and multiplication.
 *
 * @author arisfetzian
 * @version 1.0
 * @since 2023-05-16
 */

public class ArithmeticOperationsTest {

    /**
     * Test case for the divide method.
     * Checks for valid division and division by zero scenarios.
     */
    @Test
    public void testDivide() {
        ArithmeticOperations operations = new ArithmeticOperations();

        // (1) Check for valid division
        double result1 = operations.divide(10, 2);
        Assert.assertEquals(5.0, result1, 0.0001); // Expected result: 5.0

        // (2) Check for division by zero
        try {
            operations.divide(10, 0);
            //This should throw exception
            Assert.fail("Expected ArithmeticException was not thrown.");
        } catch (ArithmeticException e) {
            //Now we check the exception message
            Assert.assertEquals("Cannot divide with zero", e.getMessage());
        }
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    /**
     * Test case for the multiply method.
     * Checks for valid multiplication, negative number, and product exceeding Integer variable's capacity scenarios.
     */
    @Test
    public void testMultiply() {
        ArithmeticOperations operations = new ArithmeticOperations();

        //(1) Check for valid multiplication
        int result1 = operations.multiply(5, 4);
        Assert.assertEquals(20, result1); // 5 * 4 = 20

        //(2) Check for negative number
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("x & y should be >= 0");
        operations.multiply(5, -4);

        //(3) Check if product exceeding Integer variable's capacity
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("The product does not fit in an Integer variable");
        operations.multiply(Integer.MAX_VALUE, 2);
    }
}
