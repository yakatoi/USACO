import java.util.*;
import java.io.*;

public class MultiplayerMoo {
  public static int n;
  public static int[][] arr;
  public static boolean[][] visited;
  public static HashMap<Integer, Color> map = new HashMap<Integer, Color>();
  public static int count;
  public static void main(String[] args) throws IOException {
    BufferedReader br= new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("multimoo.out"));
    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(inp[j]);
        add(arr[i][j]);
      }
    }
    ArrayList<Color> al = new ArrayList<Color>(new TreeSet<Color>(map.values()));
    System.out.println(al);
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          count = 0;
          floodfill(i, j, arr[i][j]);
          max = Math.max(max, count);
        }
      }
    }
    System.out.println(max);
  }
  public static void add(int key) {
    if (map.keySet().contains(key)) {
      map.get(key).size++;
    }
    else {
      map.put(key, new Color(key, 1));
    }
  }
  public static void floodfill(int x, int y, int col) {
    if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || arr[x][y]!=col) return;
    count++;
    visited[x][y] =true;
    floodfill(x+1, y, col);
    floodfill(x-1, y, col);
    floodfill(x, y+1, col);
    floodfill(x, y-1, col);
  }
  public static void floodfill(int x, int y, int col1, int col2) {
    if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || (arr[x][y]!=col1 && arr[x][y]!=col2)) return;
    count++;
    visited[x][y] =true;
    floodfill(x+1, y, col1, col2);
    floodfill(x-1, y, col1, col2);
    floodfill(x, y+1, col1, col2);
    floodfill(x, y-1, col1, col2);
  }
  public static class Color implements Comparable<Color> {
    public int color;
    public int size;
    public Color(int a, int b) {
      color = a;
      size = b;
    }
    public String toString() {
      return "(" + color + ": " + size + ")";
    }
    public int compareTo(Color c) {
      if (size==c.size) {
        return -1*Integer.compare(color, c.color);
      }
      return -1*Integer.compare(size, c.size);
    }
  }
}
