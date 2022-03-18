/**
 * @author Matt Tanner
 * @version 1.2
 */
package core;


import java.lang.reflect.Array;
import java.util.Scanner;



import static ui.CheckersTextConsole.displayBoard;

/**
 * Logic for gameplay
 */
public class CheckersLogic {
    public static char[][] gameboard = new char[8][8];
    public static char moveTracker = 'X';
    public static int redCount;
    public static int blackCount;
    static int turnCount = 1;
    public static int aiFlag;

    public static void main(String[] args) {
        redCount = 12;
        blackCount = 12;


        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j)
                gameboard[i][j] = ' ';
        }


        Scanner scanner = new Scanner(System.in);


            System.out.println("Would you like to play against the computer? Y/N");
            char oppChoice = scanner.next(".").charAt(0);
            if (oppChoice == 'y' || oppChoice == 'Y') {
                aiFlag = 1;
            } else {
                aiFlag = 0;
            }

        /*
        set pieces on board
         */
            setStartBoard();


            displayBoard();
            System.out.println("Checkers!");

            gameplay();

        }
    

    /**
     * Repeats til there is a winner
     */
    public static void gameplay() {

        while (!redWin() && !blackWin()) {
           // turnTracker();


            if (moveTracker == 'X') {
                System.out.println("It is black's turn (X)");
            } else {
                System.out.println("It is red's turn (O)");
            }


            if((moveTracker == 'X'&& aiFlag ==1) || aiFlag == 0) {

                Scanner scan = new Scanner(System.in);
                System.out.println("Move your checker. Use 'row column'. Ex: 1 2 2 3 moves row 1 column 2 checker to row 2 column 3");
                int rowSelect = scan.nextInt();
                int columnSelect = scan.nextInt();
                int rowEnd = scan.nextInt();
                int colEnd = scan.nextInt();



                while (!isColor(rowSelect, columnSelect) || !moveability(rowSelect, columnSelect) || (rowEnd != rowSelect + 1 && colEnd != columnSelect + 1)) {
                    System.out.println("Please enter a valid move.");
                    System.out.println("Move your checker. Use 'row column'. Ex: 1 2 2 3 moves row 1 column 2 checker to row 2 column 3");

                    rowSelect = scan.nextInt();
                    columnSelect = scan.nextInt();
                    rowEnd = scan.nextInt();
                    colEnd = scan.nextInt();
                }


                movePiece(rowSelect, columnSelect, rowEnd, colEnd);

            }else if(moveTracker == 'O' && aiFlag == 1){
                CheckersComputerPlayer.aiMove();
            }

            turnCount++;
            displayBoard();
            turnTracker();
        }

        if (blackWin() && blackCount < 12){
            System.out.println("Black Wins.");
        }else if (blackWin() && blackCount == 12){
            System.out.println("BLack Wins. FLawless Victory.");
        }else if (redWin() && redCount < 12){
            System.out.println("Red Wins.");
        }else if (redWin() && redCount == 12){
            System.out.println("Red Wins. Flawless Victory");
        }

    }

    /**
     *
     * @param startR row of piece to be moved
     * @param startC column of piece to be moved
     * @param targR row of where piece is moving
     * @param targC column of where piece is moving
     */
    public static void movePiece(int startR, int startC, int targR, int targC) {


        if(isCapturable(startR, startC, targR, targC)){
            capturePiece(startR,startC, targR, targC);
        }else {

            char move = gameboard[startR][startC];



            gameboard[targR][targC] = move;
            gameboard[startR][startC] = ' ';
        }
    }


    /**
     *
     * @param moveRow row of moving piece
     * @param moveCol column of moving piece
     * @param captureRow row of piece being captured
     * @param captureCol column of piece being captured
     */
    public static void capturePiece(int moveRow, int moveCol, int captureRow, int captureCol) {

        char move;
        int endRow = 0, endCol = 0;
        if (captureRow > moveRow){
            if(captureCol > moveCol){
                endRow = captureRow+1;
                endCol = captureCol+1;
                move = gameboard[moveRow][moveCol];
                gameboard[captureRow+1][captureCol+1] = move;
                gameboard[moveRow][moveCol] = ' ';
                gameboard[captureRow][captureCol] = ' ';
            }else{
                endRow = captureRow+1;
                endCol = captureCol -1;
                move = gameboard[moveRow][moveCol];
                gameboard[captureRow+1][captureCol-1] = move;
                gameboard[moveRow][moveCol] = ' ';
                gameboard[captureRow][captureCol] = ' ';
            }
        }else if(captureRow < moveRow){
            if(captureCol > moveCol){
                endRow = captureRow -1;
                endCol = captureCol +1;
                move = gameboard[moveRow][moveCol];
                gameboard[captureRow-1][captureCol+1] = move;
                gameboard[moveRow][moveCol] = ' ';
                gameboard[captureRow][captureCol]= ' ';
            }else{
                endRow= captureRow -1;
                endCol = captureCol -1;
                move = gameboard[moveRow][moveCol];

                gameboard[captureRow-1][captureCol-1] = move;
                gameboard[moveRow][moveCol] = ' ';
                gameboard[captureRow][captureCol] = ' ';
            }
        }


        if (moveTracker == 'X'){
            --redCount;
        }else{
            --blackCount;
        }

        autoChain(endRow,endCol);
    }

    /**
     *
     * @param originRow row of piece that just captured opponent piece
     * @param originCol column of piece that just captured opponent piece
     */
    private static void autoChain(int originRow, int originCol) {


        if(moveTracker == 'X'){
            if(isCapturable(originRow, originCol, originRow-1, originCol+1)){
                capturePiece(originRow,originCol, originRow-1, originCol+1);
            }else if(isCapturable(originRow, originCol, originRow-1,originCol-1)){
                capturePiece(originRow,originCol,originRow-1,originCol-1);
            }
        }else if(moveTracker == 'O'){
            if(isCapturable(originRow,originCol, originRow+1,originCol-1)){
                capturePiece(originRow, originCol,originRow+1,originCol-1);
            }else if(isCapturable(originRow,originCol,originRow+1,originCol+1)){
                capturePiece(originRow,originCol,originRow+1,originCol+1);
            }
        }
    }



    /**
     *
     * @param x row of piece to be checked
     * @param y column of piece to be checked
     * @return true if checked piece has a valid move, false if it does not
     */
    static boolean moveability(int x, int y)  {

        if (moveTracker == 'X') {
            try {
                if (gameboard[x - 1][y + 1] == ' ' || gameboard[x - 1][y - 1] == ' ') {
                    return true;
                } else if (isCapturable(x, y, x - 1, y + 1) || isCapturable(x, y, x - 1, y - 1)) {
                    return true;
                }
            }catch (Exception e){
                return false;
            }

        } else if (moveTracker == 'O') {
            try {
                if (gameboard[x + 1][y + 1] == ' ' || gameboard[x + 1][y - 1] == ' ') {
                    return true;
                } else if (isCapturable(x, y, x + 1, y + 1) || isCapturable(x, y, x + 1, y - 1)) {
                    return true;
                }
            }catch (Exception e){
                return false;
            }

        }
        return false;
    }





    private static boolean blackWin() {
        if (redCount == 0)
            return true;

        for(int i =0; i <8; i++){
            int numOfMoves=0;
            for(int j = 0; j <8; j++){
                if (gameboard[i][j] == 'O'){
                    if(moveability(i, j)){
                        numOfMoves ++;
                        if(numOfMoves == 0){
                            return true;
                        }else return false;
                    }
                }numOfMoves = 0;
            }
        }return false;
    }

    private static boolean redWin() {
        if (blackCount == 0) {
            return true;
        }
        for(int i =0; i <8; i++) {
            int numOfMoves = 0;
            for (int j = 0; j < 8; j++) {
                if (gameboard[i][j] == 'X') {
                    if (moveability(i, j)) {
                        numOfMoves++;
                        if (numOfMoves == 0){
                            return true;
                        }else return false;
                    }
                }numOfMoves = 0;

            }
        }return false;

    }

    private static void setStartBoard() {
        gameboard[0][1] = 'O';
        gameboard[0][3] = 'O';
        gameboard[0][5] = 'O';
        gameboard[0][7] = 'O';
        gameboard[1][0] = 'O';
        gameboard[1][2] = 'O';
        gameboard[1][4] = 'O';
        gameboard[1][6] = 'O';
        gameboard[2][1] = 'O';
        gameboard[2][3] = 'O';
        gameboard[2][5] = 'O';
        gameboard[2][7] = 'O';
        gameboard[5][0] = 'X';
        gameboard[5][2] = 'X';
        gameboard[5][4] = 'X';
        gameboard[5][6] = 'X';
        gameboard[6][1] = 'X';
        gameboard[6][3] = 'X';
        gameboard[6][5] = 'X';
        gameboard[6][7] = 'X';
        gameboard[7][0] = 'X';
        gameboard[7][2] = 'X';
        gameboard[7][4] = 'X';
        gameboard[7][6] = 'X';
    }

    /**
     *
     * @param x row of piece being checked
     * @param y column of piece being checked
     * @return true if checked piece is same color as moveChecker.
     * Ensures players can only move their respective pieces
     */
    private static boolean isColor(int x, int y) {

        if (getColor(x, y) == moveTracker) {

            return true;
        } else return false;
    }

    /**
     *
     * @param x row of piece checked
     * @param y column of piece checked
     * @return returns color (char) of the piece at x row y column
     */
    public static char getColor(int x, int y) {
        char color = gameboard[x][y];
        return color;
    }

    private static void turnTracker() {
        if (turnCount % 2 == 0) {
            moveTracker = 'O';
        } else {
            moveTracker = 'X';
        }
    }

    /**
     *
     * @param originRow row of piece making the move
     * @param originCol column of piece making the move
     * @param targetRow row of piece to captured
     * @param targetCol column of piece to be captured
     * @return true if the piece (targetRow targetCol) can be captured by (originRow originCol)
     * Returns false if it cannot.
     */
    static boolean isCapturable(int originRow, int originCol, int targetRow, int targetCol) {

        if(targetRow <= 0 || targetRow >= 7||  targetCol <=0|| targetCol >=7) {
            return false;
        }
        if(gameboard[targetRow][targetCol] == moveTracker) {
            return false;
        }
        if((Math.abs(originRow-targetRow)!= 1)||(Math.abs(originCol-targetCol)!=1)){
            return false;
        }
        if(gameboard[targetRow][targetCol] == ' '){
            return false;
        }

        if(moveTracker == 'X'){
            if(gameboard[targetRow][targetCol]=='O') {
                if (targetCol > originCol && gameboard[targetRow - 1][targetCol + 1] != ' ') {

                    return false;
                }
                if (targetCol < originCol && gameboard[targetRow - 1][targetCol - 1] != ' ') {
                    return false;
                }
            }return true;

        }return true;

    }


}