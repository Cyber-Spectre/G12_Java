package G12_Java.AP;

import java.util.Scanner;
public class AP {
  public static Scanner scan1 = new Scanner(System.in);

  public static void main(String[] args) {

    while(true){
        System.out.println("Please specify the amount of numbers you want to input:");
        int length = 1 + scan1.nextInt();
        int [] arr = new int [length];
  
        for(int x = 1; x < length; x++){
            System.out.println("Value " + x + ":");
            arr[x] = scan1.nextInt();
        }

        System.out.println("\n");
        for(int x = 1; x < length; x++){
            System.out.println("Value " + x + ": " + arr[x]);
        }

      double hold = 0;
      for(int x = 1; x < length; x++){
        hold = hold + arr[x];
      }
      double ave = hold / (length - 1);
      System.out.println("Average: " + ave + "\n");
      System.out.println("Rerun? (0: no, 1: yes)");
      int stop = scan1.nextInt();
      if(stop == 0){
        System.exit(0);
      }
    }
  }
}