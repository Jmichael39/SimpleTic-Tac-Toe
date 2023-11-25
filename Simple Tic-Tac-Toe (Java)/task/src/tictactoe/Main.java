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
//Prompt the user to make a move. The user should input 2 coordinate numbers that represent the cell where
// they want to place their X, for example, 1 1.
        System.out.println("- Turn " + turn + " - Introduce coordinates: ");
        String input = scanner.nextLine();
        String[] coordinates = input.split(" ");
        int coor1 = 0;
        int coor2 = 0;

        if (!input.matches("\\d+( \\d+)*")) {
            System.out.println("You should enter numbers!");
            next(grid);
        } else if (!input.matches("^[1-3] [1-3]$")) {
            System.out.println("Coordinates should be from 1 to 3!");
            next(grid);
        } else {
            coor1 = Integer.parseInt(coordinates[0]) - 1;
            coor2 = Integer.parseInt(coordinates[1]) - 1;
        }

        switch (turn) {
            case "X":
                if (grid[coor1][coor2] != ' ' || grid[coor1][coor2] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    next(grid);
                } else {
                    turn = "O";
                    grid[coor1][coor2] = 'X';
                    paintGrid(grid);
                    analyze(grid);
                }
                break;

            case "O":
                if (grid[coor1][coor2] != ' ' || grid[coor1][coor2] == 'X') {
                    System.out.println("This cell is occupied! Choose another one!");
                    next(grid);
                } else {
                    turn = "X";
                    grid[coor1][coor2] = 'O';
                    paintGrid(grid);
                    analyze(grid);
                }
                break;
        }
    }

    private static void analyze(char[][] grid) {

        char winner = ' ';

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

        int i = 0;
        while (i< combinations.length) {
            int[] combination = combinations[i];
            if (grid[combination[0]][combination[1]] == grid[combination[2]][combination[3]] &&
                    grid[combination[2]][combination[3]] == grid[combination[4]][combination[5]]) {
                winner = grid[combination[0]][combination[1]];
                break;
            }
            i++;
        }

        if (winner == ' '){
            next(grid);
        }else{
            System.out.println(winner + " wins");
            System.exit(0);
        }
    }
}
