package G12_Java.Lists;

public class Skill1 {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("p");
    list.add("o");
    list.add("t");
    list.add("a");
    list.add("t");
    list.add("o");
    System.out.println(list.toString());
    if(list.size() != -1) {
      System.out.println("The list has a size of " + list.size());
    } else {
      System.out.println("The list is empty");
    }
  }
  
}
