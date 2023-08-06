import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp()  {
        calculator = new Calculator();
    }

    @Test
    public void canAdd() {
        assertEquals(10, calculator.add(5, 5));
    }

    @Test
    public void canSubtract(){
        assertEquals(3, calculator.subtract(8, 5));
    }

    @Test
    public void canMultiply(){
        assertEquals(15, calculator.multiply(5, 3));
    }

    @Test
    public void canDivide(){
        assertEquals(3.33, calculator.divide(100, 30), 0.01);
    }
}
