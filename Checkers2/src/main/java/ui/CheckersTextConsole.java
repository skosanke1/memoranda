/**
 * @author Matt Tanner
 * @version 1.2
 */
package ui;

import static core.CheckersLogic.gameboard;


/**
 * Displays the board after every move
 */
public class CheckersTextConsole {


    public static void displayBoard()
    {
        //displays board in console
        for (int i=0 ; i<8 ; ++i)
        {
            System.out.print("   " + i) ;
        }
        System.out.print("\n  ") ;
        for (int i=0 ; i<8 ; ++i)
            System.out.print("+---") ;
        System.out.print("+\n") ;
        for (int i=0 ; i<8 ; ++i) {
            System.out.print((i) + " ") ;
            for (int j=0 ; j<8 ; ++j){
                System.out.print("| " + gameboard[i][j] + " ") ;
            }
            System.out.print("|\n  ") ;
            for (int k=0 ; k<8 ; ++k)
                System.out.print("+---") ;
            System.out.print("+\n") ;
        }
    }

}
