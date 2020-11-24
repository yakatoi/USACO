import java.util.*;
public class StringTester
{
  public static int[][] arr = new int[7][7];
  public static int n = 7;
  public static void main(String[] args) {
    arr[3][4] = 1;
    Random r = new Random();
    for (int i = 0; i < 50; i++) {
      int ran = r.nextInt(n);
      int rand = r.nextInt(n);
      if (rand%2==0) {
        row(ran);
      }
      else {
        col(ran);
      }
    }
    print();
  }
  public static void print() {
    for (int[] row : arr) {
      for (int ele: row) {
        System.out.print(ele);
      }
      System.out.println();
    }
    System.out.println();
  }
  public static void row(int row) {
    for (int i = 0; i < n; i++) {
      arr[row][i] = 1-arr[row][i];
    }
  }
  public static void col(int col) {
    for (int i = 0; i < n; i++) {
      arr[i][col] = 1-arr[i][col];
    }
  }
}
