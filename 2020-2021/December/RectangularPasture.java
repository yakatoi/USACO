import java.util.*;
import java.io.*;

public class RectangularPasture {
  public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    System.out.println(3*n+1);
  }
}
import java.util.*;
import java.io.*;

public class RectangularPasture {
  static int n;
  static int[] x, y;
  static int[][] arr;
  static Point[] po;
  static long counter;
  static HashSet<String> set = new HashSet<String>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    x = new int[n];
    y = new int[n];
    arr = new int[n][n];
    po = new Point[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      x[i] = a;
      y[i] = b;
      po[i] = new Point(a, b);
    }
    Arrays.sort(x);
    Arrays.sort(y);
    // System.out.println(Arrays.toString(po));
    for (int i = 0; i < n; i++) {
      int one = Arrays.binarySearch(x, po[i].x);
      int two = Arrays.binarySearch(y, po[i].y);
      arr[one][two]++;
      po[i] = new Point(one, two);
    }
    for (int i = 0; i < n; i++) {
      x[i] = po[i].x;
      y[i] = po[i].y;
    }
    System.out.println(Arrays.toString(x));
    System.out.println(Arrays.toString(y));
    System.out.println();
    for (int[] row : arr) System.out.println(Arrays.toString(row));
    System.out.println(Arrays.toString(po));
    floodfill(0, n-1, 0, n-1);
    Arrays.sort(po, (a, b) -> (Integer.compare(a.x, b.x)));
    System.out.println(set.size());
  }
  static void floodfill(int l, int r, int u, int d) {
    if (r<l || d<u) return;
    count(l, r, u, d);
    floodfill(l+1, r, u, d);
    floodfill(l, r-1, u, d);
    floodfill(l, r, u+1, d);
    floodfill(l, r, u, d-1);
  }
  static void count(int l, int r, int u, int d) {
    long cou = 0;
    String str = "";
    for (Point p: po) {
      if (p.x >= l && p.x <= r && p.y >= u && p.y <= d) {
        str+= "1";
      }
      else {
        str+="0";
      }
    }
    set.add(str);
  }
  static class Point {
    int x, y;
    public Point(int a, int b) {
      x =a;
      y =b;
    }
    public String toString() {
      return x + " " + y;
    }
  }
}
