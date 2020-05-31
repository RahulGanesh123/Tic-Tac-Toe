import java.util.*;

public class Client {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe! In this game, you will choose a certain piece: X or O.");
        System.out.println("Player 1 is X");
        System.out.println("Player 2 is O");
        System.out.println("You must enter your spot in the form of [x][y].");
        System.out.println("0 based indexing for 2-D arrays is used so review that to play!");
        System.out.println("The x value controls the rows from 0 to 2 and the y value controls the columns from 0 to 2.");
        System.out.println("Ex: The top-left corner would be [0][0].\nThe top-right corner would be [0][2].");
        Board temp = new Board();
        System.out.println(temp.printBoard());
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a spot in the form [x][y] or type quit to stop the game.");
        String s = input.nextLine();
        while(!s.equalsIgnoreCase("quit")) {
            temp.makeMove(s);
            if(temp.gameOver()) {
                if(temp.getTie()) {
                    System.out.println("Would you like to play again? (Yes/No).");
                    s = input.nextLine();
                }
                else {
                    System.out.println("Would you like to play again? (Yes/No). The loser will start first.");
                    s = input.nextLine();
                }
                if(s.equalsIgnoreCase("Yes")) {
                    temp.clearBoardReset();
                }
                else {
                    break;
                }
            }
            System.out.println("Enter a spot in the form [x][y] or type quit to stop the game.");
            s = input.nextLine();
        }
    }
}