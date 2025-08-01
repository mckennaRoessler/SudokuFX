package org.example.sudokufx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class GameBoard extends Application
{
    private static final int BOARD_SIZE = 9;
    private static final int TILE_SIZE = 20;
    @Override
    public void start(Stage stage) throws IOException
    {
        GridPane board = new GridPane();

    for (int row = 0; row < BOARD_SIZE; row++)
    {
        for (int col = 0; col < BOARD_SIZE; col++)
        {
            Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
            //Fill with invisible number values that can be 1-9, takes user input and determines if correct.
            // Not necessarily one right answer so nums are not predetermined
            //Placeholder (alternating colors):
            if ((row + col) % 2 == 0)
            {
                tile.setFill(Color.YELLOW);
            }
            else
            {
                tile.setFill(Color.BLACK);
            }
            board.add(tile, col, row);
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