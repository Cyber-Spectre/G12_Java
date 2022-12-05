package Final_Project;

import java.util.Scanner;
import java.util.Random;

public class MinesweeperTextVer {
  public static Scanner scan1 = new Scanner(System.in);
  public static Random rand = new Random();
  
  public static void main(String[] args) {
    int input;
    String inputStr;

    System.out.println("Please select a difficulty:\n"
      + "1: Easy (8x8, 10 mines)\n"
      + "2: Medium (16x16, 40 mines)\n"
      + "3: Hard (16x30, 99 mines)\n");
    
    input = scan1.nextInt();

    int x = 0, y = 0;
    int mines = 0;
    switch(input) {
      case 1:
        y = 8; x = 8;
        mines = 10;
        break;
      case 2:
        y = 16; x = 16;
        mines = 40;
        break;
      case 3:
        y = 16; x = 30;
        mines = 99;
        break;
    }
    String[][] gameInfo = new String[x][y]; //store game information
    String[][] UI = new String[x][y]; //interface for user
    setup(x, y, mines, gameInfo, UI);
    System.out.println("Please check the rules so you know what the symbols mean and how to win");
    do { 
      int flagCount = 0;
      for(int c = 0; c < x; c++) {
        for(int d = 0; d < y; d++) {
          if(UI[c][d] == "F") {
            flagCount++;
          }
        }
      }
      if(flagCount == mines) {
        checkWin(x, y, flagCount, UI, gameInfo);
      }

      System.out.println("\n");
      if(mines - flagCount <= 0) {
        if(mines - flagCount <= -2) {
          System.out.println((mines - flagCount) + " mines left (at least " + (Math.abs(mines - flagCount) + 1) + " incorrect)");
        } else {
          System.out.println((mines - flagCount) + " mines left (at least 1 incorrect)");
        }
      } else {
        System.out.println((mines - flagCount) + " mines left");

      }
      displayUI(x, y, UI);
      display();
      input = scan1.nextInt();

      switch(input) {
        case 0: //exit
          System.exit(0);
          break;
        case 1: //reveal
          System.out.println("Input the cell you want to reveal:");
          inputStr = scan1.next();
          reveal(x, y, coordX(inputStr), coordY(inputStr), UI, gameInfo, true);
          break;
        case 2: //flag
          System.out.println("Input the cell you want to flag/unflag:");
          inputStr = scan1.next();
          flag(coordX(inputStr), coordY(inputStr), UI, true);
          break;
        case 3: //scan
          System.out.println("Input the cell you want to scan:");
          inputStr = scan1.next();
          scan(x, y, coordX(inputStr), coordY(inputStr), UI, gameInfo);
          break;
        case 4: //rules
          displayRules();
          break;
      }
    } while(true);
  }

  public static void setup(int x, int y, int mines, String[][] gameInfo, String[][] UI) { //?sets up arrays
    int a, b, a1, a2, b1, b2;
    for(a = 0; a < x; a++) { //prepares UI
      for(b = 0; b < y; b++) {
        UI[a][b] = "■";
      }
    }

    displayUI(x, y, UI);

    System.out.println("\nChoose a cell to start in (ex: C08(letter can be lowercase)):");
    String inputStr = scan1.next();
    int borderX = coordX(inputStr);
    int borderY = coordY(inputStr);
    for(a = 0; a < x; a++) { //sets safe zone around starting point
      for(b = 0; b < y; b++) {
        if((a >= (borderX - 1) && a <= (borderX + 1)) && (b >= (borderY - 1) && b <= (borderY + 1))) {
          gameInfo[a][b] = "X";
        }
      }
    }

    for(a = 0; a < x; a++) { //prepares gameInfo
      for(b = 0; b < y; b++) {
        if(gameInfo[a][b] != "X") {
          gameInfo[a][b] = " ";
        }
      }
    }

    for(int c = 0; c < mines; c++) { //places mines
      a = rand.nextInt(x);
      b = rand.nextInt(y);
      if(gameInfo[a][b] == " ") {
        gameInfo[a][b] = "*";
      } else {
        c--;
      }
    }
    
    for(a = 0; a < x; a++) { //places number values
      for(b = 0; b < y; b++) {
        if(gameInfo[a][b] != "*") {
          if(a == 0) {
            a1 = 0;
          } else {
            a1 = a - 1;
          } 
          if(b == 0) {
            b1 = 0;
          } else {
            b1 = b - 1;
          } 
          if(a == x - 1) {
            a2 = x - 1;
          } else {
            a2 = a + 1;
          } 
          if(b == y - 1) {
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
    reveal(x, y, borderX, borderY, UI, gameInfo, false);
  }

  public static void setStart(int a1, int a2, int b1, int b2, String[][] gameInfo) { //?sets up gameInfo to ensure start area is safe
    for (int x = a1; x <= a2; x++) {
      for (int y = b1; x <= b2; y++) {
        gameInfo[x][y] = "X";
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

  public static int coordX(String input) { //?returns X coordinate
    int xInt = Integer.valueOf(input.substring(1, 3));
    return xInt - 1;
  }

  public static int coordY(String input) { //?returns Y coordinate
    input = input.toUpperCase();
    char yChar = input.charAt(0);

    if(yChar == 'A') {
      return 0;
    } else if(yChar == 'B') {
      return 1;
    } else if(yChar == 'C') {
      return 2;
    } else if(yChar == 'D') {
      return 3;
    } else if(yChar == 'E') {
      return 4;
    } else if(yChar == 'F') {
      return 5;
    } else if(yChar == 'G') {
      return 6;
    } else if(yChar == 'H') {
      return 7;
    } else if(yChar == 'I') {
      return 8;
    } else if(yChar == 'J') {
      return 9;
    } else if(yChar == 'K') {
      return 10;
    } else if(yChar == 'L') {
      return 11;
    } else if(yChar == 'M') {
      return 12;
    } else if(yChar == 'N') {
      return 13;
    } else if(yChar == 'O') {
      return 14;
    } else { //'P'
      return 15;
    } 
  }

  public static void reveal(int x, int y, int a, int b, String[][] UI, String[][] gameInfo, boolean userRun) { //?reveals cell, if empty, reveal surrounding cells, if mine, run gameOver as false
    if(UI[a][b] == "■") {
      UI[a][b] = gameInfo[a][b];
      if(gameInfo[a][b] == "*") {
        gameOver(false, x, y, UI, gameInfo);
      }
      if(gameInfo[a][b] == " ") {
        for(int c = 0; c < x; c++) {
          for(int d = 0; d < y; d++) {
            if((c >= (a - 1) && c <= (a + 1)) && (d >= (b - 1) && d <= (b + 1))) {
              reveal(x, y, c, d, UI, gameInfo, false);
            }
          }
        }
      }
    } else if(userRun) {
      if(UI[a][b] == "F") {
        System.out.println("You cannot reveal a flagged cell");
      } else {
        System.out.println("That cell is already revealed");
      }
    }
  }

  public static void flag(int x, int y, String[][] UI, boolean userRun) { //?flags a cell for scanning and to prevent revealing, if already a flag, unflag
    if(UI[x][y] == "■") {
      UI[x][y] = "F";
    } else if(UI[x][y] == "F") {
      UI[x][y] = "■";
    } else {
      if(userRun) {
        System.out.println("You cannot flag revealed cells");
      }
    }
  }

  public static void scan(int x, int y, int a, int b, String[][] UI, String[][] gameInfo) { //?scans surrounding cells and reveals if flags or remaining cells match cell value
    int cellCount = 0;
    int flagCount = 0;
    int totalCount = 0;
    if((UI[a][b] != "■") && (UI[a][b] != "F") && (UI[a][b] != " ")) {
      for(int c = 0; c < x; c++) {
        for(int d = 0; d < y; d++) {
          if((c >= (a - 1) && c <= (a + 1)) && (d >= (b - 1) && d <= (b + 1))) {
            if(UI[c][d] == "F") {
              flagCount++;
              totalCount++;
            } else if(UI[c][d] == "■") {
              cellCount++;
              totalCount++;
            }
          }
        }
      }
      if(Integer.valueOf(UI[a][b]) == totalCount) {
        for(int c = 0; c < x; c++) {
          for(int d = 0; d < y; d++) {
            if((c >= (a - 1) && c <= (a + 1)) && (d >= (b - 1) && d <= (b + 1))) {
              if(UI[c][d] == "■") {
                flag(c, d, UI, false);
              }
            }
          }
        }
      } else if(Integer.valueOf(UI[a][b]) == flagCount) {
        for(int c = 0; c < x; c++) {
          for(int d = 0; d < y; d++) {
            if((c >= (a - 1) && c <= (a + 1)) && (d >= (b - 1) && d <= (b + 1))) {
              if(UI[c][d] == "■") {
                reveal(x, y, c, d, UI, gameInfo, false);
              }
            }
          }
        }
      } else if(Integer.valueOf(UI[a][b]) == cellCount) {
        for(int c = 0; c < x; c++) {
          for(int d = 0; d < y; d++) {
            if((c >= (a - 1) && c <= (a + 1)) && (d >= (b - 1) && d <= (b + 1))) {
              if(UI[c][d] == "■") {
                flag(c, d, UI, false);
              }
            }
          }
        }
      } else {
        System.out.println("Scan inconclusive");
      }
    } else {
      if(UI[a][b] == " ") {
        System.out.println("This cell has no number value");
      } else {
        System.out.println("You can only scan revealed cells");
      }
      
    }
  }

  public static void display() {
    System.out.println("\n"
      + "Please select an option:\n"
      + "0: Exit game\n"
      + "1: Reveal cell\n"
      + "2: Flag/unflag cell\n"
      + "3: Scan cell\n"
      + "4: Game rules");
  }

  public static void displayUI(int x, int y, String[][] UI) { //? displays User Interface
    if(y == 8) {
      System.out.println("   A B C D E F G H");
    } else if (y == 16) {
      System.out.println("   A B C D E F G H I J K L M N O P");
    }
    for(int a = 0; a < x; a++) {
      String print = "";
      if(a < 9) {
        print = "0" + (a + 1) + " ";
      } else {
        print = (a + 1) + " ";
      }
      for(int b = 0; b < y; b++) {
        print = print + UI[a][b] + " ";
      }
      System.out.println(print);
    }
  }

  public static void checkWin(int x, int y, int flagCount, String[][] UI, String[][] gameInfo) {
    int correctFlags = 0;
    for(int c = 0; c < x; c++) {
      for(int d = 0; d < y; d++) {
        if(UI[c][d] == "F") {
          if(gameInfo[c][d] == "*") {
            correctFlags++;
          }
        }
      }
    }
    if(correctFlags == flagCount) {
      gameOver(true, x, y, UI, gameInfo);
    }
  }

  public static void gameOver(boolean didWin, int x, int y, String[][] UI, String[][] gameInfo) { //?runs when player hits a bomb or flags all bombs
    if(didWin) { //if won
      System.out.println("\nYou have flagged all mines and have won!");
      displayUI(x, y, UI);
      System.exit(0);
    } else { //if lost
      int correctFlags = 0;
      for(int c = 0; c < x; c++) {
        for(int d = 0; d < y; d++) {
          if(UI[c][d] == "■") {
            if(gameInfo[c][d] == "*") {
              UI[c][d] = gameInfo[c][d];
            }
          } else if(UI[c][d] == "F") {
            if(gameInfo[c][d] == "*") {
              UI[c][d] = "+";
              correctFlags++;
            } else {
              UI[c][d] = "-";
            }
          }
        }
      }
      System.out.println("You hit a mine and lost!\n"
        + "You got " + correctFlags + " flags correct");
        displayUI(x, y, UI);
        System.exit(0);
    }
  }

  public static void displayRules() { //?displays a legend explaining the meaning of game symbols
      System.out.println("\nGame Rules:\n"
        + "To win, you need to flag every bomb, if you have the correct number of flags but you don't win, at least 1 flag is incorrect. If you reveal a mine, you lose, and all mines will reveal and flags will tell you if you were correct.\n"
        + "Icon Legend:\n"
        + "|■: Hidden cell\n"
        + "|*: Mine\n"
        + "|F: Flag\n"
        + "End Game Legend:\n"
        + "|+: Correct Flag\n"
        + "|-: Incorrect Flag");
    }

  public static void displayInfo(int x, int y, String[][] gameInfo) { //!displays gameInfo (testing only)
    if(y == 8) {
      System.out.println("   A B C D E F G H");
    } else if (y == 16) {
      System.out.println("   A B C D E F G H I J K L M N O P");
    }
    for(int a = 0; a < x; a++) {
      String print = "";
      if(a < 9) {
        print = "0" + (a + 1) + " ";
      } else {
        print = (a + 1) + " ";
      }
      for(int b = 0; b < y; b++) {
        print = print + gameInfo[a][b] + " ";
      }
      System.out.println(print);
    }

  }

}