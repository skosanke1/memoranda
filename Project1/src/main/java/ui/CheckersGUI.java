
package ui;
import core.CheckersComputerPlayer;
import core.CheckersLogic;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * CheckersTextConsole Class is the class that users interact with CheckersLogic.
 * @author Steven Kosanke, skosanke
 * @version 2/07/2022
 */
public class CheckersGUI extends Application{
    Integer winflag=0;
	CheckersLogic match;
    Label label;
    Button SubmitButton;
    TextField inputText;
    GridPane boardspaces;
    Pane base;
    int gametype = 1;
    /**
     * Launches gui args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start method is the first method that runs the GUI
     */
    @Override public void start(Stage primaryStage) {
    	match = new CheckersLogic();
        label = new Label("Enter �P� if you want to play against another player; enter �c� to play against computer.");
        Label xLabel =new Label( "a             b             c             d              e             f             g             h"); xLabel.relocate(80,429);
        Label yLabel1 = new Label("8"); yLabel1.relocate(67,60);
        Label yLabel2 = new Label("7"); yLabel2.relocate(67,110);
        Label yLabel3 = new Label("6"); yLabel3.relocate(67,160);
        Label yLabel4 = new Label("5"); yLabel4.relocate(67,210);
        Label yLabel5 = new Label("4"); yLabel5.relocate(67,260);
        Label yLabel6 = new Label("3"); yLabel6.relocate(67,310);
        Label yLabel7 = new Label("2"); yLabel7.relocate(67,360);
        Label yLabel8 = new Label("1"); yLabel8.relocate(67,410);

        SubmitButton = new Button("Submit");
        inputText = new TextField();
        boardspaces = new GridPane();

        SubmitButton.relocate(390,450);
        label.relocate(50,10);
        inputText.relocate(220, 450);

        SubmitButton.setManaged(false);
        SubmitButton.resize(90,25);
        SubmitButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        boardspaces.relocate(75, 30);
        int count = 0;
        double size = 50; // Space size
        for (int i=0; i<8; i++) {
          count++;
          for (int j=0; j<8; j++) {
            Rectangle r = new Rectangle(size, size, size, size);
            Circle checker = new Circle(size/3);
            if (i%2 != j%2)
                r.setFill(Color.DARKGREEN);
              else {
              	r.setFill(Color.WHITE);

            }
            boardspaces.add(r, j, i);
            if (count<27 && count%2 == 1) {
            	checker.setFill(Color.RED);
            	boardspaces.add(checker,j,i);
        	}
        	if (count>43 && count%2 == 1) {
        		checker.setFill(Color.BLACK);
        		boardspaces.add(checker,j,i);
        	}
            count++;
          }
        }

        base = new Pane();

        base.setPrefWidth(550);
        base.setPrefHeight(500);
        base.getChildren().addAll(boardspaces, SubmitButton, label, inputText,yLabel1, yLabel2, yLabel3, yLabel4, yLabel5, yLabel6, yLabel7, yLabel8, xLabel);
        base.setStyle("-fx-background-color:white; "
                           + "-fx-border-color:black; -fx-border-width:10");
        Scene scene = new Scene(base);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Checkers!");
        primaryStage.show();

    }

    /**
     * Draws a new GridPane onto the primaryStage representing the currentBoard.
     *
     *
     */
    public void redrawBoard() {
    	char red = 'X'; char black = 'O';
    	this.boardspaces = new GridPane();
        boardspaces.relocate(75, 30);

    	String displayString = match.GUIdisplay();

        int count = 0;
        double size = 50; // Space size
        for (int i=0; i<8; i++) {
          for (int j=0; j<8; j++) {
            Rectangle r = new Rectangle(size, size, size, size);
            Circle checker = new Circle(size/3);
            if (i%2 != j%2)
              r.setFill(Color.WHITE);
            else {
            	r.setFill(Color.DARKGREEN);

            }
            boardspaces.add(r,j,i);

            if (displayString.charAt(count) == red && i%2 != j%2) {
            	checker.setFill(Color.RED);
            	boardspaces.add(checker,j,i);
        	}
        	if (displayString.charAt(count) == black && i%2 != j%2) {
        		checker.setFill(Color.BLACK);
        		boardspaces.add(checker,j,i);
        	}

        	count++;
          }

        }
        base.getChildren().addAll(boardspaces);







    }

    /**
     * Handles how the events are handled,
		Inputing c or p will start a new one or two player game
		If a 5 digit string is input, then the code will check the validity of the move
		Then update the new board.
		The submit button must be pressed in order for the input string to be read.
     */
    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
    	   @Override
    	   public void handle(MouseEvent e) {
    		  String input = inputText.getText();
    		  String pee = "P";
    		  String cee = "C";
    	      inputText.clear();
    	      if (input.equalsIgnoreCase(cee)) {
    	    	  gametype = 1; winflag =0;
    	    	  match = new CheckersLogic();
    	    	  label.setText("Start game against computer. You are Red and Computer is Black");
    	    	  redrawBoard() ;
    	      }
    	      if (input.equalsIgnoreCase(pee)) {
    	    	  gametype = 0;  winflag =0;
    	    	  match = new CheckersLogic();
    	    	  label.setText("Start 2 player game. Red goes first." );
    	    	  redrawBoard() ;
    	      }

    	      if (winflag ==0) {
    	    	  int check = -1;
        	      if (input.length() == 5) {

        	    	  if (gametype == 1) {
        	    		  check = match.move(input);
        	    		  //

        	    		  if (match.winCheck() == 0) {
                              winflag=0;
                          }
                          if (match.winCheck() == 1) {
                              winflag=1;
                              label.setText("Red Player won the game");

                          }
                          if (match.winCheck() == 2) {
                              winflag=2;
                              label.setText("Black Player won the game");

                          }
                          //
        	    		  label.setText("Computer move. Please wait.");

        	    		  CheckersComputerPlayer computer = new CheckersComputerPlayer(match);
        	    		  String compMove =computer.getNextMove();
        	    		  check = match.move(compMove);
        	    	  }


        	    	  if (gametype == 0) {
        	    		  check = match.move(input);
        	    	  }
        	    	  if (check == 0) {
        	    		  label.setText("Invalid move, please try something like '3a-4b'.");
        	          }
        	    	  redrawBoard() ;
        	    	  if (match.getTurn().equals("X")) {
        	    		  label.setText("Red Player � your turn. ");
        	    	  }
        	    	  if (match.getTurn().equals("O")) {
        	    		  label.setText("Black Player � your turn. ");
        	    	  }

        	    	  if (match.winCheck() == 0) {
                          winflag=0;
                      }
                      if (match.winCheck() == 1) {
                          winflag=1;
                          label.setText("Red Player won the game");

                      }
                      if (match.winCheck() == 2) {
                          winflag=2;
                          label.setText("Black Player won the game");

                      }

        	   }
    	      }

    	   }
    	};
   }



