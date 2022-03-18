/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author steve
 */
public class CheckersGUI extends Application{
    @Override public void start(Stage primaryStage) {
        primaryStage.setTitle("Checkers Game");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField inputText = new TextField();
        Button submit = new Button();

        Scene scene = new Scene(submit,200,250);
        primaryStage.setScene(scene);
    }


    private static class piece {

        public piece() {
        }
    }



    public static void main(String[] args) {
        CheckersGUI game = new CheckersGUI();
    }
}
