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
    Node temp = new Node(data);

    if(first == null) {
      first = temp;
    } else {
      last.setNext(temp);
    }
    temp.setPrev(last);
    last = temp;
    size++;
  }

  public void display() {
    String hold = "";
    if(first != null) {
      Node temp = first;
      while(temp != null) {
        hold = hold + (temp.getData() + " ");
        temp = temp.getNext();
      }
      System.out.println(hold + "\n");
      hold = "";
      temp = last;
      while(temp != null) {
        hold = hold + (temp.getData() + " ");
        temp = temp.getPrev();
      }
      System.out.println(hold + "\n");
    }
  }

}
