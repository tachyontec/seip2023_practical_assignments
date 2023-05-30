package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testDivide_ValidDivision() {
        ArithmeticOperations operations = new ArithmeticOperations();

        double result = operations.divide(10, 2);
        Assert.assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testDivide_DivisionByZero() {
        ArithmeticOperations operations = new ArithmeticOperations();

        exceptionRule.expect(ArithmeticException.class);
        exceptionRule.expectMessage("Cannot divide with zero");

        operations.divide(10, 0);
    }

    @Test
    public void testMultiply_ValidMultiplication() {
        ArithmeticOperations operations = new ArithmeticOperations();

        int result = operations.multiply(5, 4);
        Assert.assertEquals(20, result);
    }

    @Test
    public void testMultiply_NegativeNumbers() {
        ArithmeticOperations operations = new ArithmeticOperations();

        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("x & y should be >= 0");

        operations.multiply(5, -4);
    }

    @Test
    public void testMultiply_ProductExceedsIntegerCapacity() {
        ArithmeticOperations operations = new ArithmeticOperations();

        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("The product does not fit in an Integer variable");

        operations.multiply(Integer.MAX_VALUE, 2);
    }

    @Test
    public void testMultiplyWithNegativeInput() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        int x = -5;
        int y = 10;

        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("x & y should be >= 0");

        arithmeticOperations.multiply(x, y);
    }
}
