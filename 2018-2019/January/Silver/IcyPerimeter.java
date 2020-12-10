import java.util.*;
import java.io.*;

public class IcyPerimeter {
  public static int n;
  public static int[][] arr;
  public static boolean[][] visited;
  public static void print() {
    for (int[] row : arr) {
      for (int ele : row) {
        System.out.print(ele);
      }
      System.out.println();
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("perimeter.out"));
    TreeSet<Pair> set = new TreeSet<Pair>();
    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        arr[i][j] = inp[j].equals(".") ? 0 : 1;
      }
    }
    //print();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && arr[i][j]==1) {
          set.add(new Pair(floodfill(i, j, new Pair(0, 0))));
        }
      }
    }
    //System.out.println(set);
    pw.println(set.last());
    pw.close();
  }
  public static class Pair implements Comparable<Pair> {
    public int a;
    public int b;
    public Pair(int a, int b) {
      this.a=a;
      this.b=b;
    }
    public Pair(Pair p) {
      a = p.a;
      b= p.b;
    }
    public String toString() {
      return a+ " " + b;
    }
    public int compareTo(Pair p) {
      if (a==p.a) return Integer.compare(p.b, b);
      return Integer.compare(a, p.a);
    }
  }
  public static Pair floodfill(int x, int y, Pair p) {
    if (x < 0 || y < 0 || x >= n || y >= n) return p;
    if (visited[x][y] || arr[x][y]==0) return p;

    visited[x][y] = true;

    p.a++;
    p.b+=perimeter(x, y);

    floodfill(x+1, y, p);
    floodfill(x, y+1, p);
    floodfill(x-1, y, p);
    floodfill(x, y-1, p);
    return p;
  }
  public static int perimeter(int x, int y) {
    return  4- count(x-1, y) + count(x+1, y) + count(x, y+1) + count(x, y-1);
  }
  public static int count(int x, int y) {
    if (x < 0 || y < 0 || x >= n || y >= n) return 0;
    return arr[x][y];
  }
}
