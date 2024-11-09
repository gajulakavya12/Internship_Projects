import java.util.Scanner;

public class Calci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char continueChoice;

        do {
            System.out.println("===============================================================");
            System.out.print("Enter the first number: ");
            double num1 = sc.nextDouble();

            System.out.println("===============================================================");
            System.out.print("Enter the second number: ");
            double num2 = sc.nextDouble();

            System.out.println("===============================================================");
            System.out.print("Choose an operation (+, -, *, /): ");
            char operation = sc.next().charAt(0);

            double result = calculate(num1, num2, operation);

            if (!Double.isNaN(result)) {
                System.out.print("***************************************************************\n");
                System.out.printf("The result is: %.2f\n", result);
                System.out.print("***************************************************************\n");
            }

            System.out.print("Would you like to perform another calculation? (y/n): ");
            continueChoice = sc.next().toLowerCase().charAt(0);

        } while (continueChoice == 'y');
        System.out.print("***************************************************************\n");
        System.out.println("Thank you for using this calculator. Goodbye!");
        System.out.print("***************************************************************\n");
        sc.close();
    }

    //method for calculation logic
    public static double calculate(double num1, double num2, char operation) {
        double result = 0;
        boolean validOperation = true;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is undefined.");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Invalid operation. Please select from +, -, *, or /.");
                validOperation = false;
                break;
        }

        return validOperation ? result : Double.NaN;
    }
}
