package G12_Java.Lists;

public class LinkedList {

  private Node first;
  private Node last;
  private int size;

  public LinkedList() {
    first = null;
    last = null;
    size = 0;
  }

  public void push(int data) {
    Node temp = new Node();

    if(first == null) {
      first = temp;
    } else {
      last.setNext(temp);
    }
    last.setPrev(last);
    last = temp;
    size++;
  }

  public void display() {
    
  }

}
