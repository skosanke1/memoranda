/**
 * @author Matt Tanner
 * @version 1.2
 */
package core;

import java.util.ArrayList;

import java.util.Random;


/**
 * Logic for AI
 */
public class CheckersComputerPlayer extends CheckersLogic {


    static ArrayList<CheckersAIMove> moveList = new ArrayList<CheckersAIMove>();

    static void aiMove() throws ArrayIndexOutOfBoundsException {

        int moveCount = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (gameboard[x][y] == 'O') {

                    if (CheckersLogic.moveability(x, y)) {
                        moveList.add(new CheckersAIMove(x, y));

                        moveCount++;

                    }
                }
            }
        }



        Random r = new Random();
        int move = r.nextInt(moveCount);

        moveMaker(moveList.get(move).getRow(), moveList.get(move).getCol());

    }

    /**
     *
     * @param i Row of checker to be moved
     * @param j Column of checker to be moved
     */
    public static void moveMaker(int i, int j) {
        char start = gameboard[i][j];
        char posEnd = gameboard[i+1][j+1];
        char negEnd = gameboard[i+1][j-1];

        try {
            if (start != posEnd) {
                CheckersLogic.movePiece(i, j, i + 1, j + 1);

            } else if (start != negEnd) {
                CheckersLogic.movePiece(i, j, i + 1, j - 1);
            }

        } catch (Exception e) {


        }
    }
}


