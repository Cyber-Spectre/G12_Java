package AP;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class APList {
  public static Scanner scan1 = new Scanner(System.in);
  public static Random rand = new Random();
  public static void main(String[] args) {
    ArrayList<String> friends = new ArrayList<String>();
    System.out.println("Please enter your friends' first names, enter \"d\" when you are done.");
    String input;
    do {
      input = scan1.next();
      if(input != "d") {
        friends.add(input);
      }
    } while(input != "d");
    System.out.println("done");
  }
}
