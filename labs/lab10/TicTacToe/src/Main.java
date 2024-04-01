import java.util.Scanner;

public class Main {
  private static final int ROW = 3;
  private static final int COL = 3;
  private static final String[][] board = new String[ROW][COL];

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Clear the board and set the player to X
    clearBoard();
    String player = "X";

    System.out.println("Welcome to Tic Tac Toe!");

    display();

    boolean over = false;

    while (!over) {
      System.out.println("Player " + player + " make a move");

      int row = -1;
      int col = -1;
      while (!isValidMove(row, col)) {
        if (row > -1 && col > -1) {
          System.out.println("Invalid move! Try again");
        }
        
        row = SafeInput.getRangedInt(scanner, "Enter row", 1, ROW) - 1;
        col = SafeInput.getRangedInt(scanner, "Enter column", 1, COL) - 1;
      }

      board[row][col] = player;

      display();

      if (isWin(player)) {
        System.out.println("Player " + player + " wins!");
        over = true;
      }
      else if (isTie()) {
        System.out.println("It's a tie!");
        over = true;
      }

      if (over) {
        if (SafeInput.getYNConfirm(scanner, "Play again? (y/n)")) {
          over = false;
          System.out.println("New Game!");
          player = "X";
          clearBoard();
          display();
        }
        else {
          System.out.println("Thanks for playing!");
        }
      }
      else
        player = (player.equals("X")) ? "O" : "X";
    }
  }

  private static void clearBoard() { // sets all the board elements to space
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COL; j++) {
        board[i][j] = " ";
      }
    }
  }

  private static void display() {
    System.out.println("-------------");
    for (int i = 0; i < ROW; i++) {
      System.out.print("| ");
      for (int j = 0; j < COL; j++) {
      System.out.print(board[i][j] + " | ");
      }
      System.out.println();
      System.out.println("-------------");
    }
  }

  private static boolean isValidMove(int row, int col) {
    return (row >= 0 && row < ROW && col >= 0 && col < COL && board[row][col].equals(" "));
  }

  private static boolean isWin(String player) {
    return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
  }

  private static boolean isRowWin(String player) {
    // use a for loop to check if all the elements in a row are the same
    for (int i = 0; i < ROW; i++) {
      boolean win = true;
      for (int j = 0; j < COL && win; j++) {
        if (!board[i][j].equals(player)) {
          win = false;
        }
      }

      if (win) return true;
    }

    return false;
  }

  private static boolean isColWin(String player) {
    // use a for loop to check if all the elements in a column are the same
    for (int i = 0; i < COL; i++) {
      boolean win = true;
      for (int j = 0; j < ROW; j++) { 
        if (!board[j][i].equals(player)) {
          win = false;
        }
      }
      if (win) return true;
    }
    
    return false;
  }

  private static boolean isDiagonalWin(String player) {
    for (int i = 0; i < ROW; i++) {
      if (!board[i][i].equals(player)) {
        return false;
      }
    }

    return true;
  }

  private static boolean isTie() {
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COL; j++) {
        if (board[i][j].equals(" ")) {
          return false;
        }
      }
    }
    return true;
  }
}
