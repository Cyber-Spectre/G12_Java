package Lists;

public class LinkedList {

  protected Node first;
  protected Node last;
  protected int size;

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

  public void add(int ind, String data) { //?inserts an element at the index with set value
    if(first != null) {
      if(ind > size) {
        System.out.println("Index out of bounds");
        return;
      }
      Node temp = new Node(data);
      last.setNext(temp);
      temp.setPrev(last);
      last = temp;
      size++;

      int x = size - 1;
      temp = temp.getPrev();
      
      while(x > ind) {
        temp.getNext().setData(temp.getData());
        temp = temp.getPrev();
        x--;
      }
      temp.getNext().setData(temp.getData());
      temp.setData(data);
      return;
    } else {
      System.out.println("List is empty, use option 3 to add first element");
      return;
    }
  }

  public String toString() { //?returns the list forward
    String hold = "";
    if(first != null) {
      Node temp = first;
      while(temp != null) {
        hold = hold + (temp.getData() + " ");
        temp = temp.getNext();
      }
    } else {
      hold = "The list is empty";
    }
    return hold;
  }

  public String toStringBack() { //?returns the list backward
    String hold = "";
    if(first != null) {
      Node temp = last;
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
    if(first != null) {
      while(first.getNext() != null) {
        first = first.getNext();
        first.setPrev(null);
        size--;
      }
      first = null;
      last = null;
      size--;
    } else {
      System.out.println("Array is already clear");
    }
  }

  public String get(int ind) { //?gets element at list index
    if(first != null) {
      if(ind > size) {
        return "Index out of bounds";
      }
      Node temp = first;
      int x = 1;

      while(x != ind) {
        temp = temp.getNext();
        x++;
      }
      return "Index " + ind + ": " + temp.getData();
    } else {
      return "The list is empty";
    }
  }

  public void set(int ind, String data) { //?sets the element at list index
    if(first != null) {
      if(ind > size) {
        System.out.println("Index out of bounds");
      }
      Node temp = first;
      int x = 1;

      while(x != ind) {
        temp = temp.getNext();
        x++;
      }
      temp.setData(data);
    } else {
      System.out.println("The list is empty");
    }
  }

  public void remove(int ind) { //?removes element at list index
    if(first != null) {
      if(ind > size){
        System.out.println("Index out of bounds");
        return;
      }
      Node temp = first;

      int x = 1;

      if(size == 1) { //if list has a size of 1 (single)
        first = null;
        size--;
      } else if(ind == 1) { //if index is 1 (first)
        first = first.getNext();
        first.setPrev(null);
      } else if(ind == size) { //if index is same as size (last)
        last = last.getPrev();
        last.setNext(null);
      } else {
        while(x != ind) {
          temp = temp.getNext();
          x++;
        }
        temp.getNext().setPrev(temp.getPrev());
        temp.getPrev().setNext(temp.getNext());
      }
    } else {
      System.out.println("The list is empty");
    }
  }

  public void swap(int ind, int ind2) { //?swaps position of two nodes
    if(first != null) {
      if(ind > size) {
        System.out.println("Index out of bounds (ind > size)");
      } else if(ind <= 0) {
        System.out.println("Index out of bounds (ind <= 0)");
      } else if(ind2 > size) {
        System.out.println("Index out of bounds (ind2 > size)");
      } else if(ind2 <= 0) {
        System.out.println("Index out of bounds (ind2 <= 0)");
      } else {
        Node temp = first;
        Node hold = first;
        int x = 1;
        if(ind2 > ind) {
          while(x != ind2) {
            temp = temp.getNext();
            x++;
          }

        } else {
          while(x != ind) {
            temp = temp.getNext();
            x++;
          }
          while(x != ind2) {
            hold.setData(temp.getPrev().getData());
            temp.getPrev().setData(temp.getData());
            temp.setData(hold.getData());
            temp = temp.getPrev();
            x--;
          }
          temp.setData(hold.getData());
          temp = temp.getNext();
          x++;
          while(x != ind) {
            hold.setData(temp.getNext().getData());
            temp.getNext().setData(temp.getData());
            temp.setData(hold.getData());
            temp = temp.getNext();
            x++;
          }
        }
      }
    } else {
      System.out.println("The list is empty");
    }
  }

}