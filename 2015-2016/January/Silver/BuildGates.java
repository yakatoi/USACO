  import java.util.*;
  import java.io.*;

  public class BuildGates {
    static int dim = 4050;
    static int minx = 2025;
    static int miny = 2025;
    static int maxx = 2025;
    static int maxy = 2025;
    static int[][] arr = new int[dim][dim];
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("gates.in"));
      PrintWriter pw = new PrintWriter(new FileWriter("gates.out"));
      int x = dim/2;
      int y = dim/2;
      arr[x][y] = 1;
      br.readLine();
      String[] inp = br.readLine().split("");
      for (String dir : inp) {
        if (dir.equals("N")) {
          x--;
          arr[x][y] = 1;
          x--;
          minx = Math.min(x, minx);
          arr[x][y] = 1;
        }
        if (dir.equals("S")) {
          x++;
          arr[x][y] = 1;
          x++;
          maxx = Math.max(x, maxx);
          arr[x][y] = 1;
        }
        if (dir.equals("E")) {
          y++;
          arr[x][y] = 1;
          y++;
          maxy = Math.max(y, maxy);
          arr[x][y] = 1;
        }
        if (dir.equals("W")) {
          y--;
          arr[x][y] = 1;
          y--;
          miny = Math.min(y, miny);
          arr[x][y] = 1;
        }
        }
      minx--;miny--;maxx++;maxy++;
      int counter = -1;
      for (int i = minx; i < maxx; i++) {
        for (int j = miny; j <= maxy; j++) {
          if (arr[i][j]==0) {
            floodfill(new Point(i, j));
            counter++;
          }
        }
      }
      pw.println(counter);
      pw.close();
    }
    public static void floodfill(Point p) {
      Stack<Point> stack = new Stack<Point>();
      stack.add(p);
      while (!stack.isEmpty()) {
        Point newp = stack.pop();
        if (newp.x < minx || newp.y < miny || newp.x > maxx || newp.y > maxy || arr[newp.x][newp.y]!=0) continue;
        arr[newp.x][newp.y] = 2;
        stack.add(new Point(newp.x+1, newp.y));
        stack.add(new Point(newp.x-1, newp.y));
        stack.add(new Point(newp.x, newp.y+1));
        stack.add(new Point(newp.x, newp.y-1));
      }
    }
    public static class Point {
      int x, y;
      public Point(int a, int b) {
        x=a;
        y=b;
      }
    }
  }
