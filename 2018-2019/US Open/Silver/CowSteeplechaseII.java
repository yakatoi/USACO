import java.util.*;
import java.io.*;
import java.awt.geom.Line2D.*;

public class CowSteeplechaseII {
  public static boolean isBet(int x, int y, int z) {
    if (y > z) {
      int temp = y;
      y = z;
      z = temp;
    }
    return x >= y && x <= z;
  }
  public static boolean isBet(double x, int y, int z) {
    if (y > z) {
      int temp = y;
      y = z;
      z = temp;
    }
    return x >= y*1.0 && x <= z*1.0;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("cowjump.out"));
    HashMap<Integer, Line> map = new HashMap<Integer, Line>();
    int n = Integer.parseInt(br.readLine());
    n = n == n ? n : n;
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      map.put(i+1, new Line(a, b, c, d));
    }
    System.out.println(map);
    for (int i = 1; i <= n; i++) {
      for (int j = 2; j <= n; j++) {
        if (map.get(i).intersect(map.get(j))) {
          System.out.println(i + " " + j);
        }
      }
    }

  }
  public static class Line implements Comparable<Line> {
    public Point one;
    public Point two;

    public Line(int a, int b, int c, int d) {
      if (a < c) {
        one = new Point(a, b);
        two = new Point(c, d);
      }
      else {
        one = new Point(c, d);
        two = new Point(a, b);
      }
    }
    public String toString() {
      return "(" + one + ", " + two + ")";
    }
    public int compareTo(Line l) {
      if (l.one.x == one.x) return Integer.compare(one.y, l.one.y);
      return Integer.compare(one.x, l.one.x);
    }
    public boolean intersect(Line l) {
      return Line2D.linesIntersect(one.x*1.0, one.y*1.0, two.x*1.0, two.y*1.0, l.one.x*1.0, l.one.y*1.0, l.two.x*1.0, l.two.y*1.0);
    }
  }
  public static class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
      this.x=x;
      this.y=y;
    }
    public String toString() {
      return "(" + x+ ", " + y + ")";
    }
  }
}
