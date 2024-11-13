import java.util.Scanner;

public class TicTacToeGame {
    static Scanner sc = new Scanner(System.in);

    public static void printBoard(char[][] board) {
        System.out.println(".---.---.---.");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println(".---.---.---.");
        }
    }

    public static boolean haveWon(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static boolean isDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static int r() {
        int row = sc.nextInt();
        if (row < 0 || row > 2) {
            System.out.println("Invalid Row Value! Please try again..");
            return r();
        }
        return row;
    }

    public static int c() {
        int col = sc.nextInt();
        if (col < 0 || col > 2) {
            System.out.println("Invalid Column Value! Please try again..");
            return c();
        }
        return col;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " enter : ");
            System.out.println("===============================================================");
            System.out.println("Enter the row value : ");
            int row = r();
            System.out.println("===============================================================");
            System.out.println("Enter the column value : ");
            int col = c();
            if (board[row][col] == ' ') {
                board[row][col] = player;
                if (haveWon(board, player)) {
                    printBoard(board);
                    System.out.print("***************************************************************\n");
                    System.out.println(player + " has won!!");
                    System.out.print("***************************************************************\n");
                    gameOver = true;
                } else if (isDraw(board)) {
                    printBoard(board);
                    System.out.print("***************************************************************\n");
                    System.out.println("It's a draw!!");
                    System.out.print("***************************************************************\n");
                    gameOver = true;
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move!! Please try again...");
            }
        }
        System.out.println("Do you want to play again? (y/n)");
        String input = sc.next().toLowerCase();
        if (input.equals("y")) {
            main(args);
        }
    }
}


