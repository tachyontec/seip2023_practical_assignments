package math;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The TestSuite class is a test suite that groups the MyMathTest and FactorialTest classes.
 * It runs both test simultaneously
 *
 * @author arisfetzian
 * @version 1.0
 * @since 2023-05-16
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MyMathTest.class, FactorialTest.class})
public class TestSuite {
    // This class has no code
    // But only the annotations above combining the two test classes
}
