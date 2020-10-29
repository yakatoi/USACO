import java.util.*;
import java.io.*;

public class FencePlanning {
  public static int[] parent;
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
  public static void print() {
    System.out.println(Arrays.toString(parent));
  }
  public static HashSet<Integer> idents = new HashSet<Integer>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("fenceplan.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m= Integer.parseInt(st.nextToken());
    initialize(n);
    HashMap<Integer, Point> map = new HashMap<Integer, Point>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y= Integer.parseInt(st.nextToken());
      map.put(i, new Point(x, y));
    }
    //System.out.println(map);
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) -1;
      int b= Integer.parseInt(st.nextToken()) -1;
      union(a, b);
    }
    //print();
    HashMap<Integer, Rect> rects = new HashMap<Integer, Rect>();
    for (int i = 0; i < n; i++) {
      if (rects.keySet().contains(parent[i])) {
        rects.get(parent[i]).add(map.get(i));
      }
      else {
        rects.put(parent[i], new Rect(map.get(i)));
      }
    }
    int minPer = Integer.MAX_VALUE;
    for (int key : rects.keySet()) {
      minPer = Math.min(minPer, rects.get(key).getPerimeter());
    }
    pw.println(minPer);
    pw.close();


  }
  public static class Point {
    public int x;
    public int y;
    public Point(int a, int b) {
      x=a;
      y=b;
    }
    public String toString() {
      return "(" + x + ", " + y + ")";
    }
  }
  public static class Rect {
    public int minx;
    public int maxx;
    public int miny;
    public int maxy;
    public Rect(Point p) {
      minx = p.x;
      maxx = p.x;
      miny = p.y;
      maxy = p.y;
    }
    public void add(Point p) {
      minx = Math.min(p.x, minx);
      miny = Math.min(p.y, miny);
      maxx = Math.max(p.x, maxx);
      maxy = Math.max(p.y, maxy);
    }
    public int getPerimeter() {
      return ((maxx-minx) + (maxy-miny)) *2;
    }
  }
}
