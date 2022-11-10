package G12_Java.Lists;

public class Prime {
  
  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    boolean isPrime;
    list.add("1,");
    for(int x = 3; x < 10000; x++) {
      isPrime = true;
      for(int y = x - 1; y > 1; y--) {
        if(x % y == 0) {
          isPrime = false;
        }
      }
      if(isPrime) {
        list.add(String.valueOf(x) + ",");
      }
    }
    System.out.println(list.toString());
  }

}
