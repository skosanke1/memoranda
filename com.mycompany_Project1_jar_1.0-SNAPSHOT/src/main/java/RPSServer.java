package application;
import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
/**
 * RPSServer Class is the class that users hosts Rock Paper Scissors games.
 *  Uses the RPSClient.java file and RPSConstants
 * @author Steven Kosanke, skosanke
 * @version 2/22/2022
 */
public class RPSServer extends Application
    implements RPSConstants {
  private int sessionNo = 1; // Number a session


  @Override
  public void start(Stage primaryStage) {
    TextArea taLog = new TextArea();

    // Create the main scene for server
    Scene scene = new Scene(new ScrollPane(taLog), 450, 200);
    primaryStage.setTitle("Rock_Paper_Scissors_Server"); // Set title
    primaryStage.setScene(scene);
    primaryStage.show();

    new Thread( () -> {
      try {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8000);
        Platform.runLater(() -> taLog.appendText(new Date() +
          ": Server started at socket 8000\n"));

        // Ready to create a session for two players
        while (true) {

          Platform.runLater(()-> taLog.appendText(new Date() +
            ": Wait for players to join session " + sessionNo + '\n'));
          Socket player1 = serverSocket.accept();
          //add player1
          Platform.runLater(() -> {
            taLog.appendText(new Date() + ": Player 1 joined session "
              + sessionNo + '\n');
            taLog.appendText("Player 1's IP address" +
              player1.getInetAddress().getHostAddress() + '\n');
          });

          // Notify that the player is Player 1
          new DataOutputStream(
            player1.getOutputStream()).writeInt(PLAYER1);

          // Connect to player 2
          Socket player2 = serverSocket.accept();

          Platform.runLater(() -> {
            taLog.appendText(new Date() +
              ": Player 2 joined session " + sessionNo + '\n');
            taLog.appendText("Player 2's IP address" +
              player2.getInetAddress().getHostAddress() + '\n');
          });

          // Notify that the player is Player 2
          new DataOutputStream(
            player2.getOutputStream()).writeInt(PLAYER2);

          // Display this session and increment session number
          Platform.runLater(() ->
            taLog.appendText(new Date() +
              ": Start a thread for session " + sessionNo++ + '\n'));

          // Launch a new thread for this session of two players
          new Thread(new HandleASession(player1, player2)).start();
        }
      }
      catch(IOException ex) {
        ex.printStackTrace();
      }
    }).start();
  }

  // Define the thread class for handling a new session for two players
  class HandleASession implements Runnable, RPSConstants {
    private Socket player1;
    private Socket player2;

    // Create Win Log
    private int[] winLog = new int[2]; //First indicates P1 wins, 2nd indicates P2 wins

    private DataInputStream fromPlayer1;
    private DataOutputStream toPlayer1;
    private DataInputStream fromPlayer2;
    private DataOutputStream toPlayer2;

    // Continue to play
    private boolean continueToPlay = true;

    /** Construct a thread session */
    public HandleASession(Socket player1, Socket player2) {
      this.player1 = player1;
      this.player2 = player2;
      winLog[0] = 0; winLog[1] = 0;
    }

    /** Implement the run() method for the thread */
    public void run() {
      try {
        // Create data input and output streams
        DataInputStream fromPlayer1 = new DataInputStream(
          player1.getInputStream());
        DataOutputStream toPlayer1 = new DataOutputStream(
          player1.getOutputStream());
        DataInputStream fromPlayer2 = new DataInputStream(
          player2.getInputStream());
        DataOutputStream toPlayer2 = new DataOutputStream(
          player2.getOutputStream());

        // Write anything to notify player 1 to start
        // This is just to let player 1 know to start
        toPlayer1.writeInt(1);

        // Continuously serve the players and determine and report
        // the game status to the players
        while (true) {
          // Receive a move from player 1
          int P1move = fromPlayer1.readInt();
          int P2move = fromPlayer2.readInt();

          Platform.runLater(() -> {
          //Add move to win
          if ((P1move==SCISSORS && P2move==PAPER) ||
        		  (P1move==ROCK && P2move==SCISSORS) ||
          			(P1move==PAPER && P2move==ROCK)) {
        	  //this means that p1 wins
        	  winLog[0] = winLog[0] +1;
          }
          else if ((P2move==SCISSORS && P1move==PAPER) ||
        		  (P2move==ROCK && P1move==SCISSORS) ||
          			(P2move==PAPER && P1move==ROCK)) {
        	  //this means that p2 wins
        	  winLog[1] = winLog[1] +1;
          }
          else if (P2move == P1move) {
        	  //draw case
          }
          });
          sendMove(toPlayer1, P2move);
          sendMove(toPlayer2, P1move);
          //Updating the scores

          if (isWon(0)) {
            toPlayer1.writeInt(PLAYER1_WON);
            toPlayer2.writeInt(PLAYER1_WON);
            //sendMove(toPlayer2, row, column);
            break; // Break the loop
          }
          else if (isWon(1)) {
              toPlayer1.writeInt(PLAYER2_WON);
              toPlayer2.writeInt(PLAYER2_WON);
              //sendMove(toPlayer2, row, column);
              break; // Break the loop
            }

          else {
            // Notify player 2 to take the turn
        	toPlayer1.writeInt(CONTINUE);
            toPlayer2.writeInt(CONTINUE);
            //UPDATE THE SCORE VALUES
          }
        }
      }
      catch(IOException ex) {
        ex.printStackTrace();
      }
    }

    /** Send the move to other player */
    private void sendMove(DataOutputStream out, int move)
        throws IOException {
      out.writeInt(move); // Send move
    }

    /** Determine if the player with the specified token wins */
    private boolean isWon(int i) {
    	if (winLog[i] >= 5) {
    		return true;
    	}
      return false;
    }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}