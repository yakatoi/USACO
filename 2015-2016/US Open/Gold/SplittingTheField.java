import java.util.*;
import java.io.*;

public class SplittingTheField {
  public static void print(int[][] arr) {
    for (int[] row : arr) {
      for (int ele : row) {
        System.out.print(ele + " ");
      }
      System.out.println();
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("split.out"));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][2];
    StringTokenizer st;
    int minx, miny, maxx, maxy;
    minx = miny = Integer.MAX_VALUE;
    maxx = maxy = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
      minx = Math.min(minx, arr[i][0]);
      maxx = Math.max(maxx, arr[i][0]);
      miny = Math.min(miny, arr[i][1]);
      maxy = Math.max(maxy, arr[i][1]);
    }
    // System.out.println(minx + " " + maxx);
    // System.out.println(miny + " " + maxy);
    // System.out.println();
    //print(arr);
    int oneRectArea = (maxx - minx) * (maxy - miny);
    Arrays.sort(arr, (x, y) -> (Integer.compare(x[0], y[0])));
    print(arr);
    Pair p1 = new Pair(arr[n-2][0]-arr[0][0],0);
    for (int i = 0; i < n-1; i++) {
      p1.minimize(arr[i][0] - arr[0][0], arr[n-1][0] - arr[i+1][0]);
    }
    System.out.println(p1);
  }
  public static class Pair {
    public int x;
    public int y;
    public Pair(int a, int b) {
      x=a;
      y=b;
    }
    public void minimize(int a, int b) {
      if (a+b < x + y) {
        x = a;
        y = b;
      }
    }
    public String toString() {
      return "(" + x + ", " + y +")";
    }
  }
}
