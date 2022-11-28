package Final_Project;

import java.util.Scanner;
import java.util.Random;

public class MinesweeperTextVer {
  public static Scanner scan1 = new Scanner(System.in);
  public static Random rand = new Random();
  
  public static void main(String[] args) {
    int input;

    System.out.println("Please select a difficulty:\n"
      + "1: Easy (8x8, 10 mines)\n"
      + "2: Medium (16x16, 40 mines)\n"
      + "3: Hard (16x30, 99 mines)\n");
    
    input = scan1.nextInt();

    int x = 0, y = 0;
    int mines = 0;
    switch(input) {
      case 1:
        x = 8; y = 8;
        mines = 10;
        break;
      case 2:
        x = 16; y = 16;
        mines = 40;
        break;
      case 3:
        x = 16; y = 30;
        mines = 99;
        break;
    }
    String[][] gameInfo = new String[x][y]; //store game information
    String[][] UI = new String[x][y]; //interface for user
    setup(x, y, mines, gameInfo, UI);
    displayInfo(x, y, gameInfo);
    /*do {
      
    } while(true);*/
  }

  public static void setup(int x, int y, int mines, String[][] gameInfo, String[][] UI) { //?sets up gameInfo array
    for(int a = 0; a < x; a++) { //prepares arrays
      for(int b = 0; b < y; b++) {
        gameInfo[a][b] = " ";
        UI[a][b] = " ";
      }
    }

    for(int c = 0; c < mines; c++) { //places mines
      int a = rand.nextInt(x);
      int b = rand.nextInt(y);
      if(gameInfo[a][b] == " ") {
        gameInfo[a][b] = "*";
      } else {
        c--;
      }
    }
    
    for(int a = 0; a < x; a++) { //places number values
      for(int b = 0; b < y; b++) {
        if(gameInfo[a][b] != "*") {
          int a1, b1, a2, b2;
          if(a == 0) {
            a1 = 0;
          } else {
            a1 = a - 1;
          } if(b == 0) {
            b1 = 0;
          } else {
            b1 = b - 1;
          } if(a == x - 1) {
            a2 = x - 1;
          } else {
            a2 = a + 1;
          } if(b == y - 1) {
            b2 = y - 1;
          } else {
            b2 = b + 1;
          }
          String countHold;
          if(bombCount(a1, a2, b1, b2, gameInfo) == 0) {
            countHold = " ";
          } else {
            countHold = String.valueOf(bombCount(a1, a2, b1, b2, gameInfo));
          }
          gameInfo[a][b] = countHold;
        }
      }
    }
  }

  public static int bombCount(int a1, int a2, int b1, int b2, String[][] gameInfo) { //?counts the amount of bombs around a cell and returns the int
    int count = 0;
    for(int x = a1; x <= a2; x++) {
      for(int y = b1; y <= b2; y++) {
        if(gameInfo[x][y] == "*") {
          count++;
        }
      }
    }
    return count;
  }

  public static void display() {
    
  }

  public static void displayInfo(int x, int y, String[][] gameInfo) { //!displays gameInfo (testing only)
    for(int a = 0; a < x; a++) {
      String print = "";
      for(int b = 0; b < y; b++) {
        print = print + gameInfo[a][b] + " ";
      }
      System.out.println(print);
    }
  }

}