import java.util.*;
//This class creates the gameboard for the program, as well as creates/implements methods that are used in the client class
public class Board {
    private String[][] board;
    private String player1 = "X";
    private String player2 = "O";
    private String currentPlayer = player1;
    private boolean tie = false;
    private String loser;
    private int totalTurns = 0;

    public Board() {
        board = new String[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
    }

    public String printBoard() {
        String returnString = "";
        returnString += "\n";
        for (int i = 0; i < 3; i++) {
            returnString += "|";
            for (int j = 0; j < 3; j++) {
                returnString += String.format("%-10s|", board[i][j]);
            }
            returnString += "\n";
            returnString += "\n";
        }
        returnString += "Current Player is: " + currentPlayer;
        return returnString;
    }

    public String printBoardWithoutPlayer() {
        String returnString = "";
        returnString += "\n";
        for (int i = 0; i < 3; i++) {
            returnString += "|";
            for (int j = 0; j < 3; j++) {
                returnString += String.format("%-10s|", board[i][j]);
            }
            returnString += "\n";
            returnString += "\n";
        }
        return returnString;
    }

    public boolean makeMove(String s) {
        if(s.length() != 6 || !(s.substring(0, 1).equals("[")) || !(s.substring(2, 4).equals("][")) || !(s.substring(5).equals("]"))) {
            System.out.println("Incorrect Format, Please Try Again.");
            return false;
        }
        String tempX = s.substring(1, 2);
        String tempY = s.substring(4, 5);
        boolean xGood = true;
        boolean yGood = true;
        try {
            int d = Integer.parseInt(tempX);
        } catch (NumberFormatException nfe) {
            xGood = false;
        }
        try {
            int d = Integer.parseInt(tempY);
        } catch (NumberFormatException nfe) {
            yGood = false;
        }

        if(xGood == false || yGood == false) {
            System.out.println("Invalid input for x or y. Please Try Again");
        }
        else {
            int x = Integer.parseInt(s.substring(1, 2));
            int y = Integer.parseInt(s.substring(4, 5));
            if(x > 2 || y > 2) {
                System.out.println("Invalid input for x or y. Please Try Again");
                return false;
            }
            if(!board[x][y].equals("")) {
                System.out.println("Cannot Place Here, Spot Already Taken");
                System.out.println(this.printBoard());
            }
            else {
                board[x][y] = String.format("%5s", currentPlayer);
                switchPlayer();
                totalTurns++;
            }
            return true;
        }
        return true;
    }

    public void switchPlayer() {
        if(currentPlayer.equals(player1)) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }

    public boolean checkWin() {
        //these 3 check rows
        if(!board[0][0].equals("") && board[0][0].equals(board[0][1]) && !board[0][1].equals("") && board[0][1].equals(board[0][2]) && !board[0][2].equals("")) {
            if(board[0][0].contains(player1)) {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 1 \"" + player1 + "\" is the Winner!");
                loser = player2;
            }
            else {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 2 \"" + player2 + "\" is the Winner!");
                loser = player1;
            }
            return true;
        }
        if(!board[1][0].equals("") && board[1][0].equals(board[1][1]) && !board[1][1].equals("") && board[1][1].equals(board[1][2]) && !board[1][2].equals("")) {
            if(board[1][0].contains(player1)) {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 1 \"" + player1 + "\" is the Winner!");
                loser = player2;
            }
            else {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 2 \"" + player2 + "\" is the Winner!");
                loser = player1;
            }
            return true;
        }
        if(!board[2][0].equals("") && board[2][0].equals(board[2][1]) && !board[2][1].equals("") && board[2][1].equals(board[2][2]) && !board[2][2].equals("")) {
            if(board[2][0].contains(player1)) {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 1 \"" + player1 + "\" is the Winner!");
                loser = player2;
            }
            else {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 2 \"" + player2 + "\" is the Winner!");
                loser = player1;
            }
            return true;
        }

        //these 3 check columns
        if(!board[0][0].equals("") && board[0][0].equals(board[1][0]) && !board[1][0].equals("") && board[1][0].equals(board[2][0]) && !board[2][0].equals("")) {
            if(board[0][0].contains(player1)) {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 1 \"" + player1 + "\" is the Winner!");
                loser = player2;
            }
            else {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 2 \"" + player2 + "\" is the Winner!");
                loser = player1;
            }
            return true;
        }
        if(!board[0][1].equals("") && board[0][1].equals(board[1][1]) && !board[1][1].equals("") && board[1][1].equals(board[2][1]) && !board[2][1].equals("")) {
            if(board[0][1].contains(player1)) {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 1 \"" + player1 + "\" is the Winner!");
                loser = player2;
            }
            else {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 2 \"" + player2 + "\" is the Winner!");
                loser = player1;
            }
            return true;
        }
        if(!board[0][2].equals("") && board[0][2].equals(board[1][2]) && !board[1][2].equals("") && board[1][2].equals(board[2][2]) && !board[2][2].equals("")) {
            if(board[0][2].contains(player1)) {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 1 \"" + player1 + "\" is the Winner!");
                loser = player2;
            }
            else {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 2 \"" + player2 + "\" is the Winner!");
                loser = player1;
            }
            return true;
        }

        //these 2 check diagonals
        if(!board[0][0].equals("") && board[0][0].equals(board[1][1]) && !board[1][1].equals("") && board[1][1].equals(board[2][2]) && !board[2][2].equals("")) {
            if(board[0][0].contains(player1)) {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 1 \"" + player1 + "\" is the Winner!");
                loser = player2;
            }
            else {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 2 \"" + player2 + "\" is the Winner!");
                loser = player1;
            }
            return true;
        }
        if(!board[2][0].equals("") && board[2][0].equals(board[1][1]) && !board[1][1].equals("") && board[1][1].equals(board[0][2]) && !board[0][2].equals("")) {
            if(board[2][0].contains(player1)) {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 1 \"" + player1 + "\" is the Winner!");
                loser = player2;
            }
            else {
                System.out.println(printBoardWithoutPlayer());
                System.out.println("Player 2 \"" + player2 + "\" is the Winner!");
                loser = player1;
            }
            return true;
        }
        return false;
    }

    public int getTotalTurns() {
        return totalTurns;
    }

    public boolean gameOver() {
        if(checkWin()) {
            return true;
        }
        if(totalTurns == 9) {
            System.out.println(printBoardWithoutPlayer());
            tie = true;
            System.out.println("It's a tie!");
            loser = currentPlayer;
            return true;
        }
        System.out.println(printBoard());
        return false;
    }

    public void clearBoardReset() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
        tie = false;
        currentPlayer = loser;
        totalTurns = 0;
        System.out.println(printBoard());
    }

    public boolean getTie() {
        return tie;
    }

}
