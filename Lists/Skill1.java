package G12_Java.Lists;

import java.util.Scanner;

public class Skill1 {
  public static Scanner scan1 = new Scanner(System.in);

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    do {
      display();

      int input = scan1.nextInt();

      switch(input) {
        case 0:
          System.exit(0);
          break;
        case 1:
          System.out.println(list.toString());
          break;
        case 2:
          System.out.println(list.toStringBack());
          break;
        case 3:
        System.out.println("The list has a size of " + list.size());
          break;
        case 4:
          System.out.println("\nInput the element you want to add:");
          String data = scan1.next();
          list.add(data);
          break;
        case 5:
          break;
        case 6:
          System.out.println("\nInput the index you want to remove:");
          int ind = scan1.nextInt();
          list.remove(ind);
          break;
        case 7:
          break;
        case 8:
          break;
        case 9:
          break;
      }
    }
    while(true);
  }

  public static void display() {
    System.out.println("\nPlease select an option: \n"
      + "0: Exit \n"
      + "1: Display list\n"
      + "2: Display list (backwards)\n"
      + "3: List size \n"
      + "4: Add element to list \n"
      + "5: Add element at index \n"
      + "6: Remove element at index \n"
      + "7: Clear list \n"
      + "8: Get element at index \n"
      + "9: Set element at index \n");
  }
  
}