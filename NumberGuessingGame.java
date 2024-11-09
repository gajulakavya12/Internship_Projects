import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("===============================================================");
        System.out.print("Enter the maximum number: ");
        int max = sc.nextInt();
        
        if (max <= 0) {
            System.out.println("===============================================================");
            System.out.print("Please enter a number greater than zero.");
            sc.close();
            return;
        }
        
        int random = (int) (Math.random() * max) + 1;
        System.out.println("===============================================================");
        System.out.print("Guess the number (or enter 0 to quit):");
        
        
        while (true) {
            int guess = sc.nextInt();
            
            if (guess == 0) {
                System.out.print("***************************************************************\n");
                System.out.println("User has quit the game :(");
                System.out.print("***************************************************************\n");
                break;
            }
            
            if (guess == random) {
                System.out.print("***************************************************************\n");
                System.out.println("You are right! Congrats!!");
                System.out.print("***************************************************************\n");
                break;
            } else if (guess < random) {
                System.out.println("===============================================================");
                System.out.println("Hint: Your guess was too small, please try again.");
                System.out.println("===============================================================");
            } else {
                System.out.println("===============================================================");
                System.out.println("Hint: Your guess was too big, please try again.");
                System.out.println("===============================================================");
            }
            
            System.out.print("Enter your next guess (or enter 0 to quit): ");
        }
        
        sc.close();
    }
}

