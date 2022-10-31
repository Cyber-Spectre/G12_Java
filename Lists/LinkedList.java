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

  public String toString() { //?returns the list forward and backward
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

  public int size() { //?returns the size of the list
    if(first != null) {
      size = 0;
      Node temp = first;
      while(temp != null) {
        size++;
        temp = temp.getNext();
      }
      return size;
    } else {
      return 0;
    }
  }

  public void clear() { //?clears the list

  }

  public String get(int ind) { //?gets element at list index

  }

  public void set(int ind, String data) { //?sets the element at list index
    if(first != null) {
      Node temp = first;

      int x = 1;
      while(x != (ind)) {
        temp = temp.getNext();
        x++;
      }

    }
  }

  public void remove(int ind) { //?removes element at list index
    if(first != null) {
      if(ind > list.size()){
        System.out.println("Index out of bounds");
        break;
      }
      Node temp = first;

      int x = 1;
      while(x != (ind)) {
        temp = temp.getNext();
        x++;
      }
      temp.getNext().setPrev(temp.getPrev());
      temp.getPrev().setNext(temp.getNext());
    }
  }

}
