/**
 * @author Matt Tanner
 * @version 1.2
 */
package core;

/**
 * Creates an object of moveable checkers for AI
 */
public class CheckersAIMove extends CheckersComputerPlayer {
    private int startRow;
    private int startCol;

    /**
     *
     * @param row Start row of move object created
     * @param col Start column of move object created
     */
    public CheckersAIMove(int row, int col) {
        this.startRow = row;
        this.startCol = col;

    }
    public int getRow(){
        return startRow;
    }
    public int getCol(){
        return startCol;
    }
}
