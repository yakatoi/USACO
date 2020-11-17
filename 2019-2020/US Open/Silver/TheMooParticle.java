import java.util.*;
import java.io.*;

public class TheMooParticle {
  public static int[] parent;
  public static void print() {
    System.out.println(Arrays.toString(parent));
  }
  public static void initialize(int n) {
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }
  public static int find(int x) {
    if (x==parent[x]) {
      return x;
    }
    else {
      parent[x] = find(parent[x]);
      return parent[x];
    }
  }
  public static void union(int a, int b) {
    int c = find(a);
    int d = find(b);
    if (c < d) {
      parent[d] = c;
    }
    if (d < c) {
      parent[c] = d;
    }
  }

  public static int number = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("moop.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("moop.out"));
    int n = Integer.parseInt(br.readLine());
    initialize(n);
    Point[] arr = new Point[n];
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      arr[i] = new Point(x, y);
    }
    //System.out.println(Arrays.toString(arr));
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i!=j) {
          if (arr[i].interact(arr[j])) {
            union(arr[i].identity, arr[j].identity);
          }
        }
      }
    }
    HashSet<Integer> ans = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      ans.add(find(i));
    }
    pw.println(ans.size());
    pw.close();
  }
  public static class Point {
    public int x;
    public int y;
    public int identity;
    public Point(int a, int b) {
      x=a;
      y=b;
      identity = number;
      number++;
    }
    public boolean interact(Point p) {
      return p.x >= x && p.y >= y;
    }
    public String toString() {
      return "(" + identity + ": " + x + ", " + y+ ")";
    }
  }
}
