package com.company;
import java.util.*;

public class Main {

    static String[][] board = new String[8][8];
    private static int x;
    private static int y;
    private static int score;


    public static void main(String[] args) {
        //sets the players scores to 0 and sets up board and add the treasure in the grid
        score = 0;

        setUpBoard();

        addTreasure();

        //gives the user 5 guesses and loops the method 5 times before displaying their score
        for (int i = 0; i < 5; i++) {

            coordinateGuess();

            checkForTreasure();
        }
        System.out.println("Your final haul is: "+score);



    }

    private static void setUpBoard() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                board[x][y] = "[  ]";
            }
        }
    }

    //uses for loops to print the 8 x 8 board
    private static void printBoard() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

    //generates random amount of treasure and stores it in random positions in the array store
    private static void addTreasure() {
        Random random = new Random();

        int amountOfTreasure = random.nextInt((75 - 25) + 1) + 25;

        for (int i = 0; i < amountOfTreasure; i++) {
            board[random.nextInt(8)][random.nextInt(8)] = "[" + (random.nextInt((99 - 10) + 1) + 10) + "]";


        }
    }

    // Gets user to enter a set of coordinates and guess where the treasure is located
    private static void coordinateGuess() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Please enter a X coordinate (any number between 0 and 8): ");
                x = scanner.nextInt();

                System.out.println("Please enter a Y coordinate (any number between 0 and 8): ");
                y = scanner.nextInt();

                //if a number greater than 8 or words are entered it will loop back because it only matches values that match the board size
                if (x >= 0 && x <= 8 && y >= 0 && y <= 8) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
                System.out.println("please enter only numbers between 0 and 8");
            }
        }
    }

    //it tells the user if they found treasure and if so it adds it to their total also it prints out their score regardless
    private static void checkForTreasure() {
        if (!board[x][y].substring(1, 3).equals(" ")) {
            score = score + Integer.parseInt(board[x][y].substring(1, 3));
            System.out.println("Congrats you found treasure! Your score is now " + score);
        } else {
            System.out.println("No treasure unfortunately. Your score is " + score);
        }
    }
}