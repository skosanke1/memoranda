package ui;
import core.CheckersLogic;
import java.util.Scanner;
/**
 * CheckersTextConsole Class is the class that users interact with CheckersLogic.
 * @author Steven Kosanke
 * @version 1/22/2022
 */

public class CheckersTextConsole {

    /**
     * Main method to run.  Loops a new checkers game until it determines a win has occured.
     * @param args
     */
    public static void main(String[] args) {
       CheckersLogic match = new CheckersLogic();
       System.out.println(match.displayGame());
       System.out.print("Begin Game.");
       Scanner scan = new Scanner(System.in);
       String nextMove; Integer winflag=0;

      while (winflag==0) {
          System.out.print("Player " + match.getTurn());
          System.out.println(" – your turn. ");
          System.out.println("Choose a cell position of piece to be moved and the new position. e.g., 3a-4b");
          nextMove = scan.nextLine();
          int check = match.move(nextMove);
          if (check == 0) {
              System.out.println("Invalid move, please try again");
          }
          else {
              System.out.println(match.displayGame());
              if (match.winCheck() == 0) {
                  winflag=0;
              }
              if (match.winCheck() == 1) {
                  winflag=1;
                  System.out.println("Player X won the game");
              }
              if (match.winCheck() == 2) {
                  winflag=2;
                  System.out.println("Player O won the game");
              }
          }
       }
    }
}
