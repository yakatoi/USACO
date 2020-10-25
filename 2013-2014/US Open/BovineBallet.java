import java.util.*;
import java.io.*;

public class BovineBallet {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("ballet.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("ballet.out"));
    int n = Integer.parseInt(br.readLine());
    Point fr = new Point(1, 1);
    Point fl = new Point(0, 1);
    Point rl = new Point(0, 0);
    Point rr = new Point(1, 0);
    int ang = 0;
    boolean neg1 = false;
    int minx = 0;
    int miny = 0;
    int maxx = 1;
    int maxy = 1;
    for (int i = 0; i < n; i++) {
      String inp = br.readLine();
      if (inp.substring(2, 3).equals("P")) {
        String id = inp.substring(0, 2);
        if (id.equals("FR")) {
          int x = fr.x;
          int y = fr.y;
          fl.c(x-y+fl.y,x+y-fl.x);
          rl.c(x-y+rl.y,x+y-rl.x);
          rr.c(x-y+rr.y,x+y-rr.x);
        }
        if (id.equals("FL")) {
          int x = fl.x;
          int y = fl.y;
          fr.c(x-y+fr.y,x+y-fr.x);
          rl.c(x-y+rl.y,x+y-rl.x);
          rr.c(x-y+rr.y,x+y-rr.x);
        }
        if (id.equals("RL")) {
          int x = rl.x;
          int y = rl.y;
          fl.c(x-y+fl.y,x+y-fl.x);
          fr.c(x-y+fr.y,x+y-fr.x);
          rr.c(x-y+rr.y,x+y-rr.x);
        }
        if (id.equals("RR")) {
          int x = rr.x;
          int y = rr.y;
          fl.c(x-y+fl.y,x+y-fl.x);
          rl.c(x-y+rl.y,x+y-rl.x);
          fr.c(x-y+fr.y,x+y-fr.x);
        }
        ang++;
        if (ang==4) ang-=4;
      }
      else {
        String id = inp.substring(0, 2);
        String dir = inp.substring(2, 3);
        if (id.equals("FR")) fr.move(dir, ang);
        if (id.equals("FL")) fl.move(dir, ang);
        if (id.equals("RL")) rl.move(dir, ang);
        if (id.equals("RR")) rr.move(dir, ang);
        if (isSame(fr, fl, rl, rr)) {
          neg1 = true;
          break;
        }
      }
      minx = minX(fr, fl, rl, rr, minx);
      maxx = maxX(fr, fl, rl, rr, maxx);
      miny = minY(fr, fl, rl, rr, miny);
      maxy = maxY(fr, fl, rl, rr, maxy);
    }
    if (neg1) {
      pw.println(-1);
    }
    else {
      pw.println((maxx - minx + 1)*(maxy - miny + 1));
    }
    pw.close();
  }
  public static boolean isSame(Point a, Point b, Point c, Point d) {
    return a.equal(b) || a.equal(c) || a.equal(d) || b.equal(c) || b.equal(d) || c.equal(d);
  }
  public static int minX(Point a, Point b, Point c, Point d, int minx) {
    int ans = a.x;
    ans = Math.min(ans, b.x);
    ans = Math.min(ans, c.x);
    ans = Math.min(ans, d.x);
    ans = Math.min(ans, minx);
    return ans;
  }
  public static int minY(Point a, Point b, Point c, Point d, int miny) {
    int ans = a.y;
    ans = Math.min(ans, b.y);
    ans = Math.min(ans, c.y);
    ans = Math.min(ans, d.y);
    ans = Math.min(ans, miny);
    return ans;
  }
  public static int maxX(Point a, Point b, Point c, Point d, int maxx) {
    int ans = a.x;
    ans = Math.max(ans, b.x);
    ans = Math.max(ans, c.x);
    ans = Math.max(ans, d.x);
    ans = Math.max(ans, maxx);
    return ans;
  }
  public static int maxY(Point a, Point b, Point c, Point d, int maxy) {
    int ans = a.y;
    ans = Math.max(ans, b.y);
    ans = Math.max(ans, c.y);
    ans = Math.max(ans, d.y);
    ans = Math.max(ans, maxy);
    return ans;
  }

  public static class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
    public void cx(int x) {
      this.x = x;
    }
    public void cy(int y) {
      this.y = y;
    }
    public void c(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean equal(Point p) {
      return p.x==x && p.y==y;
    }
    public void move(String dir, int ang) {
      if (dir.equals("F") && ang == 0) y++;
      if (dir.equals("B") && ang == 0) y--;
      if (dir.equals("R") && ang == 0) x++;
      if (dir.equals("L") && ang == 0) x--;

      if (dir.equals("F") && ang == 1) x++;
      if (dir.equals("B") && ang == 1) x--;
      if (dir.equals("R") && ang == 1) y--;
      if (dir.equals("L") && ang == 1) y++;

      if (dir.equals("F") && ang == 2) y--;
      if (dir.equals("B") && ang == 2) y++;
      if (dir.equals("R") && ang == 2) x--;
      if (dir.equals("L") && ang == 2) x++;

      if (dir.equals("F") && ang == 3) x--;
      if (dir.equals("B") && ang == 3) x++;
      if (dir.equals("R") && ang == 3) y++;
      if (dir.equals("L") && ang == 3) y--;
    }
  }
}
