/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author steve
 */
public class CheckersGUI extends Application{
    CheckersBoard board;
    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage primaryStage) {
        Button SubmitButton;
        TextField inputText;
        Label label;

        label = new Label("Enter ‘P’ if you want to play against another player; enter ‘c’ to play against computer.");
        SubmitButton = new Button("Submit");
        inputText = new TextField();

        board = new CheckersBoard();
        SubmitButton.setOnAction( e -> board.doNextMove() );

        board.relocate(20,20);
        SubmitButton.relocate(20, 120);
        label.relocate(20, 370);

        SubmitButton.setManaged(false);
        SubmitButton.resize(90,25);

        Pane base = new Pane();

        base.setPrefWidth(500);
        base.setPrefHeight(420);
        base.getChildren().addAll(board, SubmitButton, label);
        base.setStyle("-fx-background-color: darkgreen; "
                           + "-fx-border-color: darkred; -fx-border-width:3");
        Scene scene = new Scene(base);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Checkers!");
        primaryStage.show();

    }

    private class CheckersBoard extends Canvas {

        CheckersBoard board; // The data for the checkers board is kept here.
                            //    This board is also responsible for generating
                            //    lists of legal moves.

        boolean gameInProgress; // Is a game currently in progress?

        /* The next three variables are valid only when the game is in progress. */

        int currentPlayer;
        int fromX, fromY, toX, toY;


        CheckersBoard() {
            super(420,420);  // canvas is 324-by-324 pixels
            board = new CheckersData();
            board.setup();   // Set up the pieces.
            currentPlayer = 1;  // RED moves first.
            label.setText("Choose a cell position of piece to be moved and the new position. e.g., 3a-4b");
            gameInProgress = true;
            drawBoard();
        }

        public void drawBoard() {
            GraphicsContext g = getGraphicsContext2D();
            g.setFont( Font.font(18) );






    }

