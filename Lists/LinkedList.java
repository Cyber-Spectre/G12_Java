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

  public void add(String data) { //?inserts an element at the end of the list with a set value
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

  public void add(int ind, String data) {

  }

  public String toString() { //?displays the list forward and backward
    String hold = "";
    if(first != null) {
      Node temp = first;
      while(temp != null) {
        hold = hold + (temp.getData() + " ");
        temp = temp.getNext();
      }
      hold = hold + "\n \n";
      temp = last;
      while(temp != null) {
        hold = hold + (temp.getData() + " ");
        temp = temp.getPrev();
      }
    } else {
      hold = "The list is empty";
    }
    return hold;
  }

  public int size() {
    if(first != null) {
      int size = 0;
      Node temp = first;
      while(temp != null) {
        size++;
        temp = temp.getNext();
      }
      return size;
    } else {
      return -1;
    }
  }

}
