import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("===============================================================");
            System.out.println("Enter your choice  (rock/paper/scissors) or 'quit' to exit:");
            System.out.println("===============================================================");
            String userChoice = sc.nextLine().toLowerCase();

            if (userChoice.equals("quit")) {
                break;
            }

            if (!isValidChoice(userChoice)) {
                System.out.println("===============================================================");
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            String computerChoice = getComputerChoice(random);
            System.out.println("===============================================================");
            System.out.println("Computer chose: " + computerChoice);

            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);
        }
        sc.close();
    }

    private static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }

    private static String getComputerChoice(Random random) {
        String[] choices = {"rock", "paper", "scissors"};
        return choices[random.nextInt(choices.length)];
    }

    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        }

        switch (userChoice) {
            case "rock":
                return computerChoice.equals("scissors") ? "Rock crushes scissors. You win!" : "Paper covers rock. Computer wins!";
            case "paper":
                return computerChoice.equals("rock") ? "Paper covers rock. You win!" : "Scissors cuts paper. Computer wins!";
            case "scissors":
                return computerChoice.equals("paper") ? "Scissors cuts paper. You win!" : "Rock crushes scissors. Computer wins!";
            default:
                return "";
        }
    }
}
