import java.util.Random;
import java.util.Scanner;

public class CrapsGame {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        String playAgain;

        do {

            System.out.println("\n===== CRAPS GAME =====");

            // Roll two dice
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;

            int sum = die1 + die2;

            System.out.println("\nFirst Roll:");
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Sum: " + sum);

            // Check the initial roll
            if (sum == 2 || sum == 3 || sum == 12) {

                System.out.println("CRAPS! You lose!");

            }
            else if (sum == 7 || sum == 11) {

                System.out.println("NATURAL! You win!");

            }
            else {

                // Establish the point
                int point = sum;

                System.out.println("The point is: " + point);

                boolean gameOver = false;

                // Continue rolling until point or 7
                while (!gameOver) {

                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;

                    sum = die1 + die2;

                    System.out.println("\nNext Roll:");
                    System.out.println("Die 1: " + die1);
                    System.out.println("Die 2: " + die2);
                    System.out.println("Sum: " + sum);

                    if (sum == point) {

                        System.out.println("MADE POINT! YOU WIN!");
                        gameOver = true;

                    }
                    else if (sum == 7) {

                        System.out.println("ROLLED A 7! YOU LOSE!");
                        gameOver = true;

                    }
                    else {

                        System.out.println("Trying for point: " + point);

                    }

                }

            }

            // Ask the user to play again
            System.out.print("\nWould you like to play again? (Y/N): ");

            playAgain = in.nextLine();

            while (!playAgain.equalsIgnoreCase("Y") &&
                    !playAgain.equalsIgnoreCase("N")) {

                System.out.print("Please enter Y or N: ");
                playAgain = in.nextLine();

            }

        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("\nThanks for playing Craps!");

        in.close();

    }
}