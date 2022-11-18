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
    String hold = "{";
    if(first != null) {
      Node temp = first;
      hold = hold + (temp.getData());
      temp = temp.getNext();
      while(temp != null) {
        hold = hold + (", " + temp.getData());
        temp = temp.getNext();
      }
      hold = hold + "}";
    } else {
      hold = "The list is empty";
    }
    return hold;
  }

  public String toStringBack() { //?returns the list backward
    String hold = "{";
    if(first != null) {
      Node temp = last;
      hold = hold + (temp.getData());
      temp = temp.getPrev();
      while(temp != null) {
        hold = hold + (", " + temp.getData());
        temp = temp.getPrev();
      }
      hold = hold + "}";
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
      System.out.println("List is already clear");
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

  public void prime(int ind, int ind2) { //?adds all prime numbers between two numbers to list
    if(ind > ind2) { //if user inputs larger number first
      int hold = ind2;
      ind2 = ind;
      ind = hold;
    }
    boolean isPrime;
    for(int x = ind; x < ind2; x++) {
      isPrime = true;
      for(int y = x / 2; y > 1; y--) {
        if(x % y == 0) {
          isPrime = false;
          y = 1;
        }
      }
      if(isPrime) {
        add(String.valueOf(x));
      }
    }
  }

  public void swap(int ind, int ind2) { //?swaps position of two nodes
    if(first != null) {
      boolean ifError = false;
      if(ind > size) { //I
        System.out.println("Index out of bounds (ind > size)");
        ifError = true;
      } if(ind <= 0) { //need
        System.out.println("Index out of bounds (ind <= 0)");
        ifError = true;
      } if(ind2 > size) { //so
        System.out.println("Index out of bounds (ind2 > size)");
        ifError = true;
      } if(ind2 <= 0) { //many
        System.out.println("Index out of bounds (ind2 <= 0)");
        ifError = true;
      } if(ind == ind2){ //if
        System.out.println("Indexes are the same");
        ifError = true;
      } if(!ifError) { //statements
        Node temp = first;
        add("please work I lose braincells for every line of code I rewrite in an attempt to fix this"); //placeholder node
        Node hold = last; //holds elements
        int x = 1;

        if(ind > ind2) { //if user inputs higher index first
          int holdInd = ind2;
          ind2 = ind;
          ind = holdInd;
        }
        while(x != ind2) {
          temp = temp.getNext();
          x++;
        }
        while(x != ind) {
          hold.setData(temp.getPrev().getData());
          temp.getPrev().setData(temp.getData());
          temp = temp.getPrev();
          temp.getNext().setData(hold.getData());
          x--;
        }
        temp = temp.getNext();
        x++;
        while(x != ind2) {
          hold.setData(temp.getNext().getData());
          temp.getNext().setData(temp.getData());
          temp = temp.getNext();
          temp.getPrev().setData(hold.getData());
          x++;
        }
        remove(size); //removes placeholder node
      }
    } else {
      System.out.println("The list is empty");
    }
  }

}