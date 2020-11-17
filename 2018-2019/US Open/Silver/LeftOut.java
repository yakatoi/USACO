import java.util.*;
import java.io.*;

public class LeftOut {
  public static int n;
  public static int arr[][];
  public static Pair ans = new Pair(-1, -1);
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
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("leftout.out"));
    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      int[] inp = Arrays.stream(br.readLine().replace("R", "0").replace("L", "1").split("")).mapToInt(x -> Integer.parseInt(x)).toArray();
      for (int j = 0; j < n; j++) {
        arr[i][j] = inp[j];
      }
    }

    print();
    if (arr[0][0]==1) row(0);
    for (int i = 0; i < n; i++) {
      if (arr[0][i] == 1) {
        col(i);
      }
    }
    for (int i = 1; i < n; i++) {
      if (arr[i][0] ==1 ) {
        row(i);
      }
    }
    print();  

  }
  public static class Pair {
    public static int x, y;
    public Pair(int a, int b) {
      x=a;
      y=b;
    }
  }
}
