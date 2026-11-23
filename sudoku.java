package Sudoku;

//Risolutore di Sudoku
import java.util.Scanner;

public class Sudokua {
    public static void main(String[] args) {
        int[][] board = new int[9][9];
        Scanner sc = new Scanner(System.in);
        // inizializzazione
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;// Non è possibile utilizzare spazi
            }
        }

        System.out.println("Sudoku:");
        printBoard(board);

        // Inserimento numeri del Sudoku (abbandonare il ciclo while e utilizzare il
        // ciclo for per inserire i numeri del Sudoku)
        /*
         * while (true) {
         * System.out.println("Inserisci la riga (0-8) o -1 stop:");
         * int row = sc.nextInt();
         * if (row == -1) {
         * break;
         * }
         *
         * System.out.println("Inserisci la colonna (0-8):");
         * int col = sc.nextInt();
         *
         * if (row < 0 || row > 8 || col < 0 || col > 8) {
         * System.out.println("Riga o colonna non valida!");
         * continue;
         * }
         *
         * System.out.println("Inserisci il numero (1-9):");
         * int num = sc.nextInt();
         *
         * if (isValid(board, row, col, num)) {
         * board[row][col] = num;
         * } else {
         * System.out.println("Mossa non valida!");
         * }
         * printBoard(board);
         * }
         */

        // inserimento numeri del Sudoku(for)
        for (int i = 0; i < 9;) {
            System.out.println("Inserisci la colonna (0-8) o Vai alla riga successiva (-1):");
            int col = sc.nextInt();
            if (col == -1) {
                i++;
                printBoard(board);
                continue;
            }
            System.err.println("Riga corrente: " + i);
            System.out.println("Inserisci il numero (1-9):");
            if (col < 0 || col > 8) {
                System.out.println("Colonna non valida!");
                continue;
            }
            int num = sc.nextInt();
            if (num < 1 || num > 9) {
                System.out.println("Numero non valido!");
                continue;
            }
            if (isValid(board, i, col, num)) {
                board[i][col] = num;
            } else {
                System.out.println("Mossa non valida!");
            }
        }
        // Produzione finale Sudoku
        System.out.println("Sudoku finale:");
        printBoard(board);

        // Risolvi inserendo automaticamente i numeri
        if (solve(board)) {
            System.out.println("Sudoku risolto:");
            printBoard(board);
        } else {
            System.out.println("Nessuna soluzione trovata.");
        }

    }

    // Utilizzato per determinare se sia possibile inserire dei numeri in un Sudoku.
    public static boolean isValid(int[][] board, int row, int col, int num) {

        if (num < 1 || num > 9) {
            return false;
        }

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 box
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Stampa Sudoku
    public static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print("|" + board[i][j] + "|");
                if (j % 3 == 2) {
                    System.out.print(" ");
                }
            }
            if (i % 3 == 2) {
                System.out.println();
            }
            System.out.println();
        }
    }

    // Risolvi Sudoku
    public static boolean solve(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) { // se il campo è vuoto
                    for (int num = 1; num <= 9; num++) {

                        if (isValid(board, i, j, num)) {
                            board[i][j] = num; //inserisci il numero
                            //ricorsione
                            if (solve(board)) { //Non avrei mai immaginato che un metodo potesse richiamare se stesso!
                                return true;
                            }
                            board[i][j] = 0; // backtrack
                        }
                    }
                    return false; /* Si potrebbe definire un "ritorno sui
                                    propri passi": questa strada non ha portato a nulla,
                                    quindi torno indietro di un passo per provarne un'altra.*/
                }
            }
        }
        return true; // Sudoku solved
    }
}
