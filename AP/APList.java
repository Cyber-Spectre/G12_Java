package AP;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class APList {
  public static Scanner scan1 = new Scanner(System.in);
  public static Random rand = new Random();
  public static void main(String[] args) {

    ArrayList<String> friends = new ArrayList<String>();
    System.out.println("Please enter your friends' first names, enter \"d\" when you are done:");
    String input;
    boolean rerun = true;
    while(rerun) {
      input = scan1.next();
      if(input.equals("d")) {
        rerun = false;
      } else {
        friends.add(input);
      }
    }
    System.out.println("\nYou have entered " + friends.size() + " friends:");
    for(int x = 0; x < friends.size(); x++) {
      System.out.println((x + 1) + ": " + friends.get(x));
    }

    ArrayList<String> movies = new ArrayList<String>();
    System.out.println("\nThe two friends chosen to go to the movies with you are:");
    for(int x = 1; x <= 2; x++) {
      if(x == 1) {
        movies.add(friends.get(rand.nextInt(friends.size())));
      } else {
        int hold = rand.nextInt(friends.size());
        if(movies.get(0).equals(friends.get(hold))) {
          x--;
        } else {
          movies.add(friends.get(hold));
        }
      }
    }
    System.out.println(movies.get(0) + "\n" + movies.get(1));

    boolean[] isBest = new boolean[friends.size()];
    ArrayList<String> best = new ArrayList<String>();
    System.out.println("What friends would you like to add to your best friends list? Input their number value and enter 0 when done:");
    int inputInt;
    rerun = true;
    while(rerun) {
      inputInt = scan1.nextInt();
      if(inputInt == 0) {
        rerun = false;
      } else {
        isBest[inputInt] = true;
        best.add(friends.get(inputInt - 1));
      }
    }
    for(int x = 0; x <= best.size(); x++) {

    }
  }

}
