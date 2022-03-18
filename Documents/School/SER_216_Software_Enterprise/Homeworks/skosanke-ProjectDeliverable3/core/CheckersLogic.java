package core;

/**
 * CheckersLogic Class creates, displays, and stores checks game.
 * @author Steven Kosanke
 * @version 1/22/2022
 */
public class CheckersLogic {
    private String[][] game;
    private int turn = 0;   //A value that keeps track of whose turn it is, 0-none, 1-x, 2-o

    /**
     * Constructor for Checkers Board.
     */
    public CheckersLogic() {
        game = new String [9][9];
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
              game[i][j] = "_";
            }
        }
        game[8][1] = "a"; game[8][2] = "b"; game[8][3] = "c"; game[8][4] = "d"; game[8][5] = "e"; game[8][6] = "f"; game[8][7] = "g"; game[8][8] = "h";
        game[0][0] = "8"; game[1][0] = "7"; game[2][0] = "6"; game[3][0] = "5"; game[4][0] = "4"; game[5][0] = "3"; game[6][0] = "2"; game[7][0] = "1";

        game[5][1] = "X"; game[5][3] = "X"; game[5][5] = "X"; game[5][7] = "X"; game[6][2] = "X"; game[6][4] = "X"; game[6][6] = "X"; game[6][8] = "X";
        game[7][1] = "X"; game[7][3] = "X"; game[7][5] = "X"; game[7][7] = "X"; game[0][2] = "O"; game[0][4] = "O"; game[0][6] = "O"; game[0][8] = "O";
        game[1][1] = "O"; game[1][3] = "O"; game[1][5] = "O"; game[1][7] = "O"; game[2][2] = "O"; game[2][4] = "O"; game[2][6] = "O"; game[2][8] = "O";

        turn = 1;
    }

    /**
     * A method that rturns the space of a given coordinate on game.
     * @param a y coordinate
     * @param b x coordinate
     * @return The value on the board "X,O,_"
     */
    public String getSpace(int a, int b) {
        String space = this.game[a][b];
        return space;
    }

    /**
     * A method that returns whose turn in the game it is.
     * @return X,O or none to show whos turn it is
     */
    public String getTurn() {
        if (this.turn == 1)
                return "X";
        if (this.turn == -1)
                return "O";
        else
            return "none";
    }

    /**
     * Main move command, converts input to a coordinate then checks to make sure move is legal.
     * @param input from "#a" to "-#b" i.e. 3a-4b
     * @return 1 if move has been accepted, or 0 if move is determined invalid
     */
    public int move(String input) {

    //convert string input to actual spaces on the board
    int toX=10; int toY=10; int fromX=10; int fromY=10; int checker=0;
    String a = input.substring(1, 2); String b = input.substring(0, 1);
    String c = input.substring(4, 5); String d = input.substring(3, 4);


    String ally = ""; String opponent = ""; int transY=0;

    if (a.equals("a"))
        fromX = 1;
    if (a.equals("b"))
        fromX = 2;
    if (a.equals("c"))
        fromX = 3;
    if (a.equals("d"))
        fromX = 4;
    if (a.equals("e"))
        fromX = 5;
    if (a.equals("f"))
        fromX = 6;
    if (a.equals("g"))
        fromX = 7;
    if (a.equals("h"))
        fromX = 8;
    if (c.equals("a"))
        toX = 1;
    if (c.equals("b"))
        toX = 2;
    if (c.equals("c"))
        toX = 3;
    if (c.equals("d"))
        toX = 4;
    if (c.equals("e"))
        toX = 5;
    if (c.equals("f"))
        toX = 6;
    if (c.equals("g"))
        toX = 7;
    if (c.equals("h"))
        toX = 8;
    if (b.equals("8"))
        fromY = 0;
    if (b.equals("7"))
        fromY = 1;
    if (b.equals("6"))
        fromY = 2;
    if (b.equals("5"))
        fromY =3;
    if (b.equals("4"))
        fromY = 4;
    if (b.equals("3"))
        fromY = 5;
    if (b.equals("2"))
        fromY = 6;
    if (b.equals("1"))
        fromY = 7;
    if (d.equals("8"))
        toY = 0;
    if (d.equals("7"))
        toY = 1;
    if (d.equals("6"))
        toY = 2;
    if (d.equals("5"))
        toY = 3;
    if (d.equals("4"))
        toY = 4;
    if (d.equals("3"))
        toY = 5;
    if (d.equals("2"))
        toY = 6;
    if (d.equals("1"))
        toY = 7;
    if (input.substring(2,3).equals("-"))
        checker = 1;

    if (fromX == 10 || toX == 10 || fromY == 10 || toY == 10 || checker == 0)
        return 0; //Task failed to register input

    if (this.turn==0) {
        return 0;
    }
    if (this.turn==1) {
        ally="X"; opponent="O"; transY=-1;
    }
    if (this.turn==-1) {
        ally="O"; opponent="X"; transY=1;
    }

    //Now we have the converted coordinates, we need to check that the move it valid
    //Requirements are that it is needs to start on ally, and must move either to _ space transY, +-1X away where
    //Now im going to check the from move
    if (game[fromY][fromX].equals(ally) && game[toY][toX].equals("_")) {

        if (fromY+transY == toY) { //Case where the desired move is one column away,, base case ??
            if(toX==(fromX-1)) {
            game[toY][toX] = ally; game[fromY][fromX] = "_";
            this.turn = -1*turn;
            return 1;
            }

            if ((toX==(fromX+1))) {
            game[toY][toX] = ally; game[fromY][fromX] = "_";
            this.turn = -1*turn;
            return 1;

            }
        }
        //Jump detected
        if ((2*transY+fromY) == toY) {
            if((fromX-2) == toX && game[fromY+transY][fromX-1].equals(opponent)) {
            game[toY][toX] = ally; game[fromY][fromX] = "_"; game[fromY+transY][fromX-1]="_";
            this.turn = -1*turn;
            return 1;
        }
        if ((fromX+2) ==toX && game[fromY+transY][fromX+1].equals(opponent)) {
            game[toY][toX] = ally; game[fromY][fromX] = "_"; game[fromY+transY][fromX+1]="_";
            this.turn = -1*turn;
            return 1;
            }
        }
        //Double jump
        if ((4*transY+fromY) == toY) {
            if((fromX-4) == toX && game[fromY+transY][fromX-1].equals(opponent) &&
                game[fromY+2*transY][fromX-2].equals("_") && game[fromY+3*transY][fromX-3].equals(opponent)) {
            game[toY][toX] = ally; game[fromY][fromX] = "_"; game[fromY+transY][fromX-1]="_";
            game[fromY+3*transY][fromX-3]="_";
            this.turn = -1*turn;
            return 1;
        }
        if ((fromX+4) ==toX && game[fromY+transY][fromX+1].equals(opponent) &&
                game[fromY+2*transY][fromX+2].equals("_") &&game[fromY+3*transY][fromX+3].equals(opponent)) {
            game[toY][toX] = ally; game[fromY][fromX] = "_"; game[fromY+transY][fromX+1]="_";
            game[fromY+3*transY][fromX+3]="_";
            this.turn = -1*turn;
            return 1;
            }
        if (fromX ==toX && game[fromY+transY][fromX+1].equals(opponent) &&
                game[fromY+2*transY][fromX+2].equals("_") &&game[fromY+3*transY][fromX+1].equals(opponent)) {
            game[toY][toX] = ally; game[fromY][fromX] = "_"; game[fromY+transY][fromX+1]="_";
            game[fromY+3*transY][fromX+1]="_";
            this.turn = -1*turn;
            return 1;
            }
        if((fromX) == toX && game[fromY+transY][fromX-1].equals(opponent) &&
                game[fromY+2*transY][fromX-2].equals("_") &&game[fromY+3*transY][fromX-1].equals(opponent)) {
            game[toY][toX] = ally; game[fromY][fromX] = "_"; game[fromY+transY][fromX-1]="_";
            game[fromY+3*transY][fromX-1]="_";
            this.turn = -1*turn;
            return 1;



            }
        }
        else
            return 0;
}
    return 0;
}

    /**
     * This method scans the board and counts number of movable pieces each player has.
     * @return 1 if X won, 2 if O won, 0 if game incomplete
     */
    public int winCheck() { //Return 1 if X won, 2 if O won, 0 if game is not complete
        int check=0;
        int a=0; int b=0; //a counts number of movable pieces of X
        int transYx = -1; int transYo = 1;




        for (int i=1; i<8; i++) {
            for (int j=1; j<8; j++){
                if (game[i][j].equals("O")) {
                    if (game[i+transYo][j+1].equals("_") || game[i+transYo][j-1].equals("_")) {
                        b++;
                    }
                }
                if (game[i][j].equals("X")) {
                    if (game[i+transYx][j+1].equals("_") || game[i+transYx][j-1].equals("_")) {
                        a++;
                    }
                }
            }
        }
    for (int i=2; i<7; i++) {
            for (int j=2; j<7; j++){
                if (game[i][j].equals("O")) {
                    if ((game[i+2*transYo][j+2].equals("_") && game[i+transYo][j+1].equals("X")) ||
                            (game[i+2*transYo][j-2].equals("_") && game[i+transYo][j-1].equals("X"))) {
                        b++;
                    }
                }
                if (game[i][j].equals("X")) {
                     if ((game[i+2*transYx][j+2].equals("_") && game[i+transYx][j+1].equals("O")) ||
                           (game[i+2*transYx][j-2].equals("_") && game[i+transYx][j-1].equals("O"))) {
                                 a++;
                    }
                }
            }
        }


    
        if (a==0) {
            check = 2;
        }
        if (b==0) {
            check = 1;
        }
        return check;
    }

    /**
     * Displays the text-ui formatted game array.
     * @return A string that shows formatted version of output
     */
    public String displayGame() {
        String currentBoard = "";
        for (int i=0; i<8; i++) {
            for (int j=0; j<9; j++) {
                currentBoard = currentBoard + this.getSpace(i,j) + " | ";
            }
            currentBoard = currentBoard + "\n";
        }
        currentBoard = currentBoard + "    a   b   c   d   e   f   g   h   ";
        return currentBoard;
    }
}
