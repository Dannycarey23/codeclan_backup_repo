import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FruitMachineTest {
    FruitMachine fruitMachine;
    FruitMachine spyFruitMachine;

    @BeforeEach
    public void before(){
        fruitMachine = new FruitMachine();
        spyFruitMachine = Mockito.spy(fruitMachine);
    }

    @Test
    public void testSpin() {
        // Whenever the fruit machine gets a random symbol, return Symbol.JACKPOT instead
        Mockito.when(spyFruitMachine.getRandomSymbol()).thenReturn(Symbol.JACKPOT);

        // Now our spyFruitMachine should always roll a jackpot!
        assertEquals(10, spyFruitMachine.spin());
    }
}