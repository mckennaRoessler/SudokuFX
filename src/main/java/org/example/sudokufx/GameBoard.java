package org.example.sudokufx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Scanner;

import java.io.IOException;

public class GameBoard extends Application
{
    private static final int BOARD_SIZE = 81;
    private static final int TILE_SIZE = 9;

    @Override
    public void start(Stage stage) throws IOException
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Select difficulty: ");
        System.out.println("1 = easy, 2 = medium, 3 = hard");
        int difficulty = userInput.nextInt();

        if (difficulty < 1 || difficulty > 3)
        {
            throw new IOException("Difficulty level invalid.");
        }

        calculateBoardNumbers(difficulty);
    }

    private void calculateBoardNumbers(int difficulty)
    {
        int[][] nums = new int[9][9];
        int givenNums;
        if (difficulty == 1) {givenNums = 40;}
        if (difficulty == 2) {givenNums = 30;}
        if (difficulty == 3) {givenNums = 20;}

        generateBoard(nums);
    }

    public void generateBoard(int[][] nums)
    {
        GridPane board = new GridPane();
        for (int row = 0; row < BOARD_SIZE; row++)
        {
            for (int col = 0; col < BOARD_SIZE; col++)
            {
                Cell cell = new Cell(nums[row][col], nums[row][col], false);
                //Fill with invisible number values that can be 1-9, takes user input and determines if correct.

                board.add(cell, col, row);
            }
        }

        Scene scene = new Scene(board, BOARD_SIZE * TILE_SIZE, BOARD_SIZE * TILE_SIZE);
        stage.setTitle("Sudoku");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}