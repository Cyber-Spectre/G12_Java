package AP;

import java.util.Scanner;
public class AP3 {
  public static Scanner scan1 = new Scanner(System.in);

  public static void main(String[] args){
    int choice;
    int n;
    int r;

    do{
      display();
      choice = scan1.nextInt();

      switch(choice){
        case 0:
          System.exit(0);
          break;
        case 1:
          System.out.println("\nInput a number (1 - 12 inclusive)");
          n = scan1.nextInt();
            if(n >= 1 && n <= 12){
              System.out.println("The factorial of " + n + " is " + factorial(n));
            }
          break;
        case 2:
          System.out.println("\nInput a value for r (objects, 1 - 12 inclusive)");
          r = scan1.nextInt();
          System.out.println("\nInput a value for n (choices, 1 - 12 inclusive)");
          n = scan1.nextInt();
          numComb(n, r);
          break;
      }
    }
    while(choice != 0);
  }

  public static void display(){
    System.out.println("Select an option: \n"
    + "0: Exit \n"
    + "1: Find a number's factorial \n"
    + "2: Find the amount of combinations possible from r objects and n choices \n");
  }

  public static int factorial(int n){
    //?finds the factorial of a number
      if(n > 1){
        n = n * factorial(n - 1);
      }
      return n;
  }

  public static void numComb(int n, int r){
    //?finds how many combinations can be made from r objects and n choices
    //*c = n! / r!(n - r)!
    int c;
    if(r < n){
      if(n >= 1 && n <= 12){
        if(r >= 1 && r <= 12){
          c = (factorial(n) / (factorial(r) * factorial(n - r)));
          System.out.println("\nThere are " + c + " combinations\n");
        }
        else{
          System.out.println("\nr value out of range\n");
          return;
        }
      }
      else{
        System.out.println("\nn value out of range\n");
        return;
      }
    }
    else{
      System.out.println("\nThere are 0 combinations (r > n)\n");
      return;
    }
  }
    
}