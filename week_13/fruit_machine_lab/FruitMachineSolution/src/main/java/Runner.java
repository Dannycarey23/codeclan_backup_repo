import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.playGame();
    }

    public void playGame() {
        Scanner input = new Scanner(System.in);
        int winningsTotal = 0;

        //Get number of coins to play with (game multiplier)
        try {
            System.out.println("Please enter an amount of coins: ");
            int numberOfCoins = input.nextInt();

            if (numberOfCoins < 1) {
                throw new Exception("Sorry you cant play with 0 or less coins");
            }

            //Only create the Fruit Machine instance object if the coins are valid
            FruitMachine slotMachine = new FruitMachine();
            //Allow for 10 spins of the wheel
            for (int t = 0; t < 10; t++) {
                int result = slotMachine.spin(); //Get Result

                System.out.println("Result For Spin: " + result);

                if (result > 0) {
                    winningsTotal += (result * numberOfCoins);
                    System.out.println("You Win! " + (result * numberOfCoins)
                            + " Your total winnings is " + winningsTotal);
                }
            }
            if (winningsTotal == 0) {
                System.out.println("No wins this round");
            }
        }
        catch(InputMismatchException ime) {
            System.out.printf("Please enter a valid integer for the number of coins!");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            //Below is useful for testing or logging location of error
            //exception.printStackTrace();
        }
    }
}
