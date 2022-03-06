package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    public static Character[][] board;
    public Board(Character[][] matrix) {
        this.board = matrix;


        /**
         * 3 x 3
         * {[X,X,0]}
         * {[O,O,O]}
         * {[O,0,X]}
         * X wins if X is in all the following positions
         * Diagonal Wins:
         * [0][0],[1][1],[2][2] or ,[0][2],[1][1],[2][0]
         * Horizontal Wins:
         * [0][0],[0][1],[0][2] or [1][0],[1][1],[1][2] or [2][0],[2][1],[2][2]
         * Vertical Wins:
         * [0][1],[1][0],[2][0] or [0][1],[1][1],[2][1] or [0][2],[1][2],[2][2]
         */
    }
//    Character[][] y =
//            {
//                    {'X', 'O', 'X'},
//                    {'X', 'O', 'O'},
//                    {'X', 'X', 'O'},
//            };


    public Boolean diagonalWin(char c){
        if(board[0][0].equals(c) && board[1][1].equals(c) && board[2][2].equals(c)){
            return true;
        } else if (board[0][2].equals(c) && board[1][1].equals(c) && board[2][0].equals(c)){
            return true;
        } else {
            return false;
        }
    }


    public Boolean horWin(char c){
        //Hor1
        if(board[0][0].equals(c) && board[0][1].equals(c) && board[0][2].equals(c)){
            return true;
        } else if (board[1][0].equals(c) && board[1][1].equals(c) && board[1][2].equals(c)){
            return true;
        } else if (board[2][0].equals(c) && board[2][1].equals(c) && board[2][2].equals(c)){
            return true;
        } else {
            return false;
        }
    }

    public Boolean vertWin(char c){
        Character.toLowerCase(c);
        //Vert1
        if(board[0][1].equals(c) && board[1][0].equals(c) && board[2][0].equals(c)){
            return true;
        } else if (board[0][1].equals(c) && board[1][1].equals(c) && board[1][2].equals(c)){
            return true;
        } else if (board[0][2].equals(c) && board[1][2].equals(c) && board[2][2].equals(c)){
            return true;
        } else {
            return false;
        }
    }

    public Boolean isInFavorOfX() {


        if(vertWin('X') || horWin('X') || diagonalWin('X')){
            return true;

        }

        return false;
    }

    public Boolean isInFavorOfO() {
        if(vertWin('O') || horWin('O') || diagonalWin('O')){
            return true;

        }

        return false;
    }

    public Boolean isTie() {
        if(!isInFavorOfO() && !isInFavorOfX()){
            return true;
        }
        return false;
    }

    public String getWinner() {
        if(isTie()){
            return("It was a tie!");
        }
        if (isInFavorOfO()){
            return("O");
        }else if (isInFavorOfX()){
            return ("X");
        }
        return null;
    }

}
