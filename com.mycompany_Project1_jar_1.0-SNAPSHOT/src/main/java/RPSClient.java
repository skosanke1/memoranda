package application;
import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
/**
 * RPSClient Class is the class that users hosts Rock Paper Scissors games.
 *  Uses the RPSClient.java file and RPSConstants
 * @author Steven Kosanke, skosanke
 * @version 2/14/2022
 */

public class RPSClient extends Application
    implements RPSConstants {

  //Indicate whether player should move
  private boolean myTurn = false;

  //Button used to submit move to server
  Button SubmitButton = new Button("Submit");

  //Button used to submit move to server
  TextField input = new TextField();


  // Identify which player you are
  private Label PlayerID = new Label();

  //Holds score information
  private Label Score = new Label();

  //Current opponent move
  private Label oppMove = new Label();

  //Current my move
  private Label myMove = new Label();

  //Will hold information on how to proceed
  private Label Status = new Label();

  //Indicate selected move
  private int moveSelected;

  //Input and output streams from/ to server
  private DataInputStream fromServer;
  private DataOutputStream toServer;

  //Determines whether to continue or not
  private boolean continueToPlay = true;

  //Wait for the player to enter valid move
  private boolean waiting = true;

  //Host name/ ip
  private String host = "localhost";


  /**
   * Start the server Window
   */
  @Override
  public void start(Stage primaryStage) {
    Pane base = new Pane();

    oppMove.relocate(50, 80);
    myMove.relocate(50, 60);
    PlayerID.relocate(20,10);
    Score.relocate(200,10);
    Status.relocate(20,100);
    input.relocate(25,185);
    SubmitButton.relocate(340,185);
    SubmitButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
    base.getChildren().addAll(myMove, oppMove, PlayerID, Status, Score, input, SubmitButton);

    // Set up main Stage
    Scene scene = new Scene(base, 420, 220);
    primaryStage.setTitle("Rock_Paper_Scissors Client");
    primaryStage.setResizable(false);
    primaryStage.setScene(scene);
    primaryStage.show();

    //Connect to server
    connectToServer();
  }

  /**
   * Connect to two players and create new thread
   */
  private void connectToServer() {
    try {
      Socket socket = new Socket(host, 8000);
      fromServer = new DataInputStream(socket.getInputStream());
      toServer = new DataOutputStream(socket.getOutputStream());
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

    //Each game gets a new Thread
    new Thread(() -> {
      try {
        // Get notification from the server
        int player = fromServer.readInt();

        // Am I player 1 or 2?
        if (player == PLAYER1) {
        	PlayerID.setText("lblTitle You are Player 1");
        	Score.setText("lblScore Waiting for player 2 to join");

          // Wait till player2 has joined
    	  fromServer.readInt();
    	  PlayerID.setText("int read.player start");
          Platform.runLater(() ->
          Score.setText("lblScore Both players are ready."));
          myTurn = true;
        }
        else if (player == PLAYER2) {
        	PlayerID.setText("lblTitle You are Player 2");
        	Score.setText("Initializing game..");
        myTurn = true;
        Score.setText("lblScore Both players are ready.");
        }

        // Continue to play
        while (continueToPlay) {
                waitForPlayerAction(); // Wait for player 1 to move
                sendMove(); // Send the move to the server
                receiveInfoFromServer(); // Receive info from the server
            }
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }).start();
  }

  /**
   * Wait for the player input valid move
   */
  private void waitForPlayerAction() throws InterruptedException {
    while (waiting) {
      Thread.sleep(100);
    }

    waiting = true;
  }

  /**
   * Send this player's move to the server
   */
  private void sendMove() throws IOException {
    toServer.writeInt(moveSelected); //Send move
  }

  /**
   * Receive info from the server
   */
  private void receiveInfoFromServer() throws IOException {
    // Receive game status
	  //int(scorep1*1000+scorep2*100+status*10+move)
	  int status = fromServer.readInt();

	  if (status == ROCK) {
		  oppMove.setText("They chose rock.");
	  }
	  if (status == SCISSORS) {
		  oppMove.setText("They chose scissors.");
	  }
	  if (status == PAPER) {
		  oppMove.setText("They chose paper.");
	  }

	  Score.setText("Player 1:  Player 2: ");
	  /**
	   *
    if (status == PLAYER1_WON) {
      // Player 1 won, stop playing
      continueToPlay = false;
      if (myToken == '1') {
        Platform.runLater(() -> lblStatus.setText("Congratulations, you won!"));
      }
      else if (myToken == '2') {
        Platform.runLater(() ->
          lblStatus.setText("The other player has won."));
      }
    }
    else if (status == PLAYER2_WON) {
      // Player 2 won, stop playing
      continueToPlay = false;
      if (myToken == '2') {
        Platform.runLater(() -> lblStatus.setText("Congratulations, you won!"));
      }
      else if (myToken == '1') {
        Platform.runLater(() ->
          lblStatus.setText("The other player has won."));

      }
    }
  */
    //else { //play continues
      Platform.runLater(() -> Status.setText("My turn"));
      myTurn = true; //It is my turn
    //}
  }

  //Handle getting and determining the player's move
  EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
	   @Override
	   public void handle(MouseEvent e) {
		  if (myTurn) {
			   String myinput = input.getText();
				  if (myinput.equals("R") || myinput.equals("r") || myinput.equals("rock")) {
					  myTurn = false;
					  try {
						toServer.writeInt(ROCK);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  myMove.setText("You chose rock.");
					  oppMove.setText("Waiting on opponent move...");
					  waiting = false;
				  }
				  else if (myinput.equals("S") || myinput.equals("s") || myinput.equals("scissors")) {
					  myTurn = false;
					  try {
						toServer.writeInt(SCISSORS);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  myMove.setText("You chose scissors.");
					  oppMove.setText("Waiting on opponent move...");
					  waiting = false;
				  }
				  else if (myinput.equals("P") || myinput.equals("p") || myinput.equals("paper")) {
					  myTurn = false;
					  try {
						toServer.writeInt(PAPER);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  myMove.setText("You chose paper.");
					  oppMove.setText("Waiting on opponent move...");
					  waiting = false;
				  }
				  else {
					  Status.setText("Invalid input. Enter 'r' for rock, 'p' for paper, or 's' for scissors.");
				  }
		  }

		  input.setText("");
	   }

  };
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}