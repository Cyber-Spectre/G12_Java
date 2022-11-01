package G12_Java.Lists;

import java.util.Scanner;

import org.xml.sax.InputSource;

public class Skill1 {
  public static Scanner scan1 = new Scanner(System.in);

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    int input;
    do {
      display();

      input = scan1.nextInt();

      switch(input) {
        case 0:
          System.exit(0);
          break;
        case 1:
          System.out.println(list.toString());
          break;
        case 2:
        System.out.println("The list has a size of " + list.size());
          break;
        case 3:
          System.out.println("\nInput the element you want to add:");
          String data = scan1.next();
          list.add(data);
          break;
        case 4:
          break;
        case 5:
          System.out.println("\nInput the index you want to remove:");
          input = scan1.nextInt();
          list.remove(input);
          break;
        case 6:
          list.clear();
          break;
        case 7:
          System.out.println("\nInput the index you want the element of:");
          input = scan1.nextInt();
          System.out.println(list.get(input));
          break;
        case 8:
          break;
      }
    }
    while(true);
  }

  public static void display() {
    System.out.println("\n Please select an option: \n"
      + "0: Exit \n"
      + "1: Display list (forward and backward)\n"
      + "2: List size \n"
      + "3: Add element to list \n"
      + "4: Add element at index \n"
      + "5: Remove element at index \n"
      + "6: Clear list \n"
      + "7: Get element at index \n"
      + "8: Set element at index \n");
  }
  
}
