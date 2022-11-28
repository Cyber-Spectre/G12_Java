package Final_Project;

import java.util.Scanner;
import java.util.Random;

public class Minesweeper {
  public static Scanner scan1 = new Scanner(System.in);
  public static Random rand = new Random();
  
  public static void main(String[] args) {
    int input;

    System.out.println("Please select a difficulty:\n"
      + "1: Easy (8x8, 10 mines)\n"
      + "2: Medium (16x16, 40 mines)\n"
      + "3: Hard (16x30, 99 mines)\n");
    
    input = scan1.nextInt();

    int x, y;
    int mines;
    switch(input) {
      case 1:
        x = 8; y = 8;
        mines = 10;
        setup(x, y, mines);
        break;
      case 2:
        x = 16; y = 16;
        mines = 40;
        setup(x, y, mines);
        break;
      case 3:
        x = 16; y = 30;
        mines = 99;
        setup(x, y, mines);
        break;
    }
    do {
      
    } while(true);
  }

  public static void setup(int x, int y, int mines) {
    String[][] gameInfo = new String[x][y]; //store game information
    String[][] UI = new String[x][y]; //interface for user
    
    for(int a = 0; a <= x; a++) {
      for(int b = 0; b <= y; b++) {
        gameInfo[a][b] = " ";
        UI[a][b] = " ";
      }
    }

    for(int c = 0; c <= mines; c++) {
      int a = rand.nextInt(x);
      int b = rand.nextInt(y);
      if(gameInfo[a][b] == " ") {
        gameInfo[a][b] = "*";
      } else {
        c--;
      }
    }
  }

  public static void display() {
    
  }

}
