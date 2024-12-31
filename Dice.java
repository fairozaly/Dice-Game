import java.util.Scanner;

public class Dice {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) { // Loop to allow replay
            System.out.println("""
                     HOW TO PLAY
                
            Guess the numbers on the dice and roll. 
            To win, you must complete one of the following:
                1. Roll a sum of 6
                2. Roll the same number on both dice
                3. Guess either number correctly

            You have 3 rounds. 
                      GOOD LUCK!

                """);

            boolean playerWon = false; // Track if the player wins

            for (int round = 1; round <= 3; round++) {
                System.out.println("ROUND " + round);
                System.out.println();

                System.out.println("What's your first guess? ");
                int guess1 = input.nextInt();
                System.out.println("And your second? ");
                int guess2 = input.nextInt();

                int die1 = (int) (Math.random() * 6) + 1;
                int die2 = (int) (Math.random() * 6) + 1;
                int total = die1 + die2;

                System.out.println("The first die comes up " + die1);
                System.out.println("The second die comes up " + die2);
                System.out.println("Your total roll is " + total);

                // Check win conditions
                if (guess1 == die1 || guess2 == die2) {
                    System.out.println("You guessed a number correctly. You win!");
                    playerWon = true;
                    break;
                } else if (die1 == die2) {
                    System.out.println("You rolled the same number on both dice. You win!");
                    playerWon = true;
                    break;
                } else if (total == 6) {
                    System.out.println("You rolled a sum of 6. You win!");
                    playerWon = true;
                    break;
                }

                System.out.println(); // Add a blank line for better readability
            }

            if (!playerWon) {
                System.out.println("You didn't win this time. Better luck next time!");
            }

            // Ask if the user wants to play again
            System.out.println("\nWould you like to play again? Press Enter to continue or type 'exit' to stop.");
            input.nextLine(); // Consume leftover newline
            String response = input.nextLine().trim().toLowerCase();

            if (response.equals("exit")) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }
        }

        input.close();
    }
}
