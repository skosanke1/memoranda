package ui;
import core.CheckersLogic;
import core.CheckersComputerPlayer;
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
       System.out.println("Begin Game.");
       Scanner scan = new Scanner(System.in);
       String nextMove; Integer winflag=0;

       System.out.println("Enter '1' for simple board, enter '2' for JavaFX board.");
       String boardchoice = scan.nextLine();
       if (boardchoice.equals("1")) {

       System.out.println("Enter ‘P’ if you want to play against another player; enter ‘c’ to play against computer.");
       String choice = scan.nextLine();
       if (choice.equals("p") || choice.equals("P")) {
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

       if (choice.equals("c") || choice.equals("C")) {
           System.out.println("Start game against computer. You are Player X and Computer is Player O. ");
           while (winflag==0) {
               if (match.getTurn().equals("X")) {
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
               //end of player turn half

               if (match.getTurn().equals("O")) {
                   System.out.println();
                   System.out.println("Computer move. Please wait.");
                   System.out.println();
                   String nextComputerMove;
                   CheckersComputerPlayer computer = new CheckersComputerPlayer(match);
                   nextComputerMove=computer.getNextMove();
                  int check = match.move(nextComputerMove);
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
               }//End computer turn
           }//end while
       }
       else {
           System.out.println("Invalid choice, please try again. Exiting game.");
       }
    }

        if (boardchoice.equals("2")) {
            CheckersGUI game = new CheckersGUI();
        }
    }
}
