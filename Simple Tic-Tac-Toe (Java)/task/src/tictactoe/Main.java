package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        start();
    }

    static Scanner scanner = new Scanner(System.in);
    static char[][] grid = new char[3][3];
    static String turn = "X";

    public static void start() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = ' ';
            }
        }
        paintGrid(grid);
        next(grid);
    }

    private static void paintGrid(char[][] grid) {
        System.out.println("---------");
        System.out.println("| " + grid[0][0] + " " + grid[0][1] + " " + grid[0][2] + " |");
        System.out.println("| " + grid[1][0] + " " + grid[1][1] + " " + grid[1][2] + " |");
        System.out.println("| " + grid[2][0] + " " + grid[2][1] + " " + grid[2][2] + " |");
        System.out.println("---------");
    }

    private static void next(char[][] grid) {
    /*
    Prompt the user to make a move. The user should input 2 coordinate numbers that represent the cell where
    they want to place their X, for example, 1 1.
    */

        System.out.print("- Turn " + turn + " - Introduce coordinates: ");
        String input = scanner.nextLine();
        String[] coordinates = input.split(" ");
        int row;
        int column;

        if (!input.matches("\\d+( \\d+)*")) {
            System.out.println("You should enter numbers!");
            next(grid);
        } else if (!input.matches("^[1-3] [1-3]$")) {
            System.out.println("Coordinates should be from 1 to 3!");
            next(grid);
        } else {
            row = Integer.parseInt(coordinates[0]) - 1;
            column = Integer.parseInt(coordinates[1]) - 1;

            switch (turn) {
                case "X":
                    if (grid[row][column] != ' ' || grid[row][column] == 'O') {
                        System.out.println("This cell is occupied! Choose another one!");
                        next(grid);
                    } else {
                        turn = "O";
                        grid[row][column] = 'X';
                        paintGrid(grid);
                        analyze(grid);
                    }
                    break;

                case "O":
                    if (grid[row][column] != ' ' || grid[row][column] == 'X') {
                        System.out.println("This cell is occupied! Choose another one!");
                        next(grid);
                    } else {
                        turn = "X";
                        grid[row][column] = 'O';
                        paintGrid(grid);
                        analyze(grid);
                    }
                    break;
            }
        }
    }

    private static void analyze(char[][] grid) {
        int empty = 0;
        char winner = ' ';
        int nWinners = 0;

        int[][] combinations = {
                {0, 0, 0, 1, 0, 2},
                {1, 0, 1, 1, 1, 2},
                {2, 0, 2, 1, 2, 2},
                {0, 0, 1, 0, 2, 0},
                {0, 1, 1, 1, 2, 1},
                {0, 2, 1, 2, 2, 2},
                {0, 0, 1, 1, 2, 2},
                {0, 2, 1, 1, 2, 0},
        };

        for (int[] combination : combinations) {
            if (grid[combination[0]][combination[1]] == grid[combination[2]][combination[3]] &&
                    grid[combination[2]][combination[3]] == grid[combination[4]][combination[5]]) {
                winner = grid[combination[0]][combination[1]];
                nWinners = (winner == ' ') ? 0 : 1;
                break;
            }
        }

        for (char[] chars : grid) {
            for (char aChar : chars) {
                if (aChar == ' ' && empty == 0) {
                    empty++;
                }
            }
            if (empty != 0){
                break;
            }
        }

        if (nWinners == 0 && empty != 0) {
            next(grid);
        } else if (nWinners == 0) {
            System.out.println("Draw");
        } else {
            System.out.println(winner + " wins");
        }
    }
}

