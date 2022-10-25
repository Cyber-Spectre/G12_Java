package G12_Java.Main;

import java.util.Random;
import java.util.Scanner;

class CS30 {
  public static Scanner scan1 = new Scanner(System.in);
  public static Random rand = new Random();

  public static void main(String[] args) {
    int[] arr = new int[100];
    int hi, lo;
    do {
      display();

      int input = scan1.nextInt();

      switch (input) {
        case 0:
          System.exit(0);
          break;
        case 1:
          popSeq(arr);
          break;
        case 2:
          popRand(arr);
          break;
        case 3:
          sortChek(arr);
          break;
        case 4:
          displayArr(arr);
          break;
        case 5:
          shuf(arr);
          break;
        case 6:
          findLin(arr);
          break;
        case 7:
          for (int x = 0; x < arr.length - 1; x++) {
            // checks if the array is sorted
            if (arr[x] > arr[(x + 1)]) {
              System.out.println("Array is not sorted");
              break;
            }
          }
          System.out.println("\nEnter the number you want to find:");
          int key = scan1.nextInt();
          hi = arr.length; // holds the highest possible position of input
          lo = 0; // holds the lowest possible position of input
          int pos = findBin(arr, key, hi, lo);
          if (pos != -1) {
            System.out.println("\nPosition " + (pos) + ": " + arr[pos]);
          }
          break;
        case 8:
          bubSort(arr);
          break;
        case 9:
          insSort(arr);
          break;
        case 10:
          selSort(arr);
          break;
        case 11:
          quikSort(arr, 0, arr.length - 1);
          break;
        case 12:
          radSort(arr);
          break;
        case 13:
          mergeSort(arr, 0, arr.length - 1);
          break;
      }
    } while (true);

  }

  public static void display() {
    //?this method displays a menu
    System.out.println("\n Please select an option: \n"
        + "0: Exit \n"
        + "1: Populate Sequentially \n"
        + "2: Populate Randomly \n"
        + "3: Check if array is sorted \n"
        + "4: Display array \n"
        + "5: Shuffle array \n"
        + "6: Linear Search \n"
        + "7: Binary Search \n"
        + "8: Bubble Sort \n"
        + "9: Insertion Sort \n"
        + "10: Selection Sort \n"
        + "11: QuickSort \n"
        + "12: Radix Sort \n"
        + "13: Merge Sort \n");
  }

  public static int[] popSeq(int[] arr) {
    //?populates arr[] sequentially from 0-99
    for (int x = 0; x < arr.length; x++) {
      arr[x] = (x);
    }
    return arr;
  }

  public static int[] popRand(int[] arr) {
    //?populates arr[] randomly
    for (int x = 0; x < arr.length; x++) {
      arr[x] = rand.nextInt(100);
    }
    return arr;
  }

  public static void sortChek(int[] arr) {
    //?checks if arr[] is sorted in ascending order
    for (int x = 0; x < arr.length - 1; x++) {
      if (arr[x] > arr[x + 1]) {
        System.out.println("Array is not sorted");
        return;
      }
    }
    System.out.println("Array is sorted");
  }

  public static void displayArr(int[] arr) {
    //?displays arr[] in rows of 10
    for (int x = 0; x < 10; x++) {
      String row = x + "X: ";
      for (int y = 0; y < 10; y++) {
        row = row + arr[((x * 10) + y)] + ", ";
      }
      System.out.println(row);
    }
  }

  public static int[] shuf(int[] arr) {
    //?shuffles the array randomly
    for (int x = 0; x < arr.length; x++) {
      int temp = arr[x];
      int random = rand.nextInt(99) + 1;
      arr[x] = arr[random];
      arr[random] = temp;
    }
    return arr;
  }

  public static void findLin(int[] arr) {
    //?finds an inputted number in arr[] with linear search
    System.out.println("Enter the number you want to find:");
    int key = scan1.nextInt();
    for (int x = 0; x < arr.length; x++) {
      if (arr[x] == key) {
        System.out.println("Position " + (x) + ": " + arr[x]);
        return;
      }
    }
    System.out.println("That number is not in the array");
  }

  public static int findBin(int[] arr, int key, int hi, int lo) {
    //?finds an inputted number in arr[] with recursive binary search
    if (lo <= hi) {
      int mid = (hi + lo) / 2; //holds the position between hi and lo
      if (arr[mid] < key) {
        return findBin(arr, key, hi, mid + 1);
      } else if (arr[mid] == key) {
        while(true) {
          if (arr[mid - 1] == key) {
            mid--;
          } else {
            return mid;
          }
        }
      } else {
        return findBin(arr, key, mid - 1, lo);
      }
    } else {
      System.out.println("That number is not in the array");
      return -1;
    }
  }

  public static void bubSort(int[] arr) {
    //?sorts arr[] using Bubble Sort
    for (int x = 0; x < arr.length - 1; x++) {
      boolean done = true; //checks if a full loop is completed without sorting
      for (int y = 0; y < arr.length - 1; y++) {
        if (arr[y] > arr[y + 1]) {
          done = false;
          int hold = arr[y];
          arr[y] = arr[y + 1];
          arr[y + 1] = hold;
        }
      }
      if (done) {
        System.out.println("Sorted after " + x + " loops");
        return;
      }
    }
    System.out.println("Array has been sorted");
  }

  public static void insSort(int[] arr) {
    //?sorts arr[] using Insertion Sort
    int stepBack = 1;
    //holds the value that the sort steps back while sorting to step forward later
    for (int x = 0; x < arr.length - 1;) {
      if (arr[x] > arr[x + 1]) {
        int hold = arr[x];
        arr[x] = arr[x + 1];
        arr[x + 1] = hold;
        if (x > 0) {
          stepBack++;
          x--;
        }
      } else {
        x = x + stepBack;
        stepBack = 1;
      }
    }
    System.out.println("Array has been sorted");
  }

  public static void selSort(int[] arr) {
    //?sorts arr[] using Selection Sort
    for (int x = 0; x < arr.length; x++) {
      int lo = 2147483647; //holds the lowest value after the current value
        //!starting value is the largest possible 32-bit signed integer, therefore any possible starting number is either equal or smaller
      int loLoc = 0; //holds the location of the lowest value

      for (int y = x + 1; y < arr.length; y++) {
        if (arr[y] < lo) {
          lo = arr[y];
          loLoc = y;
        }
      }
      if (lo < arr[x]) {
        int hold = arr[x];
        arr[x] = lo;
        arr[loLoc] = hold;
      }
    }

    System.out.println("Array has been sorted");
  }

  public static void quikSort(int[] arr, int lo, int hi) {
    //?sorts arr[] using QuickSort
    if (lo < hi) {
      int piv = arr[hi]; //pivot to sort values from
      int ind = lo - 1; //index of next position in sorted array

      for (int x = lo; x <= hi - 1; x++) {
        if (arr[x] < piv) {
          ind++;
          int temp = arr[ind];
          arr[ind] = arr[x];
          arr[x] = temp;
        }
      }
      int temp = arr[ind + 1];
      arr[ind + 1] = arr[hi];
      arr[hi] = temp;

      int part = ind + 1;

      quikSort(arr, lo, part - 1); //*recurs lower group of values
      quikSort(arr, part + 1, hi); //*recurs higher group of values
    }
  }

  public static void radSort(int[] arr) {
    //?sorts arr[] using Radix Sort
    int[] output = new int[arr.length + 1];
    int max = arr[0];
    for (int x = 0; x < arr.length; x++) {
      if (arr[x] > max) {
        max = arr[x];
      }
    }
    for (int place = 1; max / place > 0; place *= 10) {
      int[] count = new int[max + 1];
      for (int x = 0; x < max; x++) {
        count[x] = 0;
      }
      for (int x = 1; x < arr.length; x++) {
        count[(arr[x] / place) % 10]++;
      }
      for (int x = 1; x < 10; x++) {
        count[x] += count[x - 1];
      }
      for (int x = arr.length - 1; x >= 0; x--) {
        output[count[(arr[x] / place) % 10]] = arr[x];
        count[(arr[x] / place) % 10]--;
      }
      for (int x = 0; x < arr.length; x++) {
        arr[x] = output[x];
      }
    }
  }

  public static void mergeSort(int[] arr, int l, int h) {
    //?sorts arr[] using Merge Sort
    if(l < h) {
      int m = l + (h - 1) / 2; //middle value

      mergeSort(arr, l, m); //*recurs lower half of range
      mergeSort(arr, m + 1, h); //*recurs higher half of range

      int lS = m - l + 1; //lower group size
      int hS = h - m; //higher group size
      int[] lArr = new int[lS], hArr = new int[hS];

      for (int x = 0; x < lS; x++) {
        lArr[x] = arr[l + x];
      }
      for (int y = 0; y < hS; y++) {
        hArr[y] = arr[m + 1 + y];
      }
      int x = 0, y = 0, z = l; //index of subarrays (x, y) and sorted array (z)

      while (x < lS && y < hS) {
        if (lArr[x] <= hArr[y]) {
          arr[z] = lArr[x];
          x++;
        } else {
          arr[z] = hArr[y];
          y++;
        }
        z++;
      }

      while (x < lS) { //*if any values remain in lArr[]
        arr[z] = lArr[x];
        x++;
        z++;
      }

      while (y < hS) { //*if any values remain in hArr[]
        arr[z] = hArr[y];
        y++;
        z++;
      }
    }
  }

}