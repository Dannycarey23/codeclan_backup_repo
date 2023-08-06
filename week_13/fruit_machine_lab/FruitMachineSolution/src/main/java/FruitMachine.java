import java.util.Random;

class FruitMachine {
    public Symbol getRandomSymbol(){
        Random random = new Random();
        int n = random.nextInt(Symbol.values().length);

        Symbol values[] = Symbol.values();
        return values[n];
    }

    public int spin(){
        Symbol results[] = new Symbol[3];

        for(int i=0; i<=2; i++){
            results[i] = getRandomSymbol();
        }

        if(results[0] == results[1] && results[1] == results[2]){
            // Winner! Get the winnings value from the Enum value
            return results[0].getWinnings();
        }

        // You didn't win - return 0 :(
        return 0;
    }
}