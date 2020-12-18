import java.util.*;
import java.io.*;

public class CrossCountrySkiing {
  static int m, n;
  static int[][] heights;
  static boolean[][] visited;
  static HashSet<Integer> points = new HashSet<Integer>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("ccski.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("ccski.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    heights = new int[m][n];
    int b = 0;
    for (int i = 0; i < m; i++) {
      int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
      for (int j = 0; j < n; j++) {
        heights[i][j] = inp[j];
        b = Math.max(b, inp[j]);
      }
    }
    for (int i = 0; i < m; i++) {
      int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
      for (int j = 0; j < n; j++) {
        if (inp[j] == 1) {
          points.add(501* i + j);
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (heights[i][j] > b) b = heights[i][j];
      }
    }
    int a = 0;
    while (a != b) {
      int mid = (a+b)/2;
      if (works(mid)) {
        b = mid;
      }
      else {
        a = mid+1;
      }
    }
    System.out.println(a);
    pw.println(a);
    pw.close();
  }
  static boolean works(int d) {
    visited = new boolean[m][n];
    HashSet<Integer> set = new HashSet<Integer>();
    int xx = -1; int yy = -1;
    for (int ele : points) {
      int x = ele/501;
      int y = ele%501;
      dfs(x, y, heights[x][y], d);
    }
    for (int ele : points) {
      int x = ele/501;
      int y = ele%501;
      boolean nextTo = false;
      if (!outOfBounds(x+1, y) && Math.abs(heights[x][y] - heights[x+1][y]) <= d) nextTo = true;
      if (!outOfBounds(x-1, y) && Math.abs(heights[x][y] - heights[x-1][y]) <= d) nextTo = true;
      if (!outOfBounds(x, y-1) && Math.abs(heights[x][y] - heights[x][y-1]) <= d) nextTo = true;
      if (!outOfBounds(x, y+1) && Math.abs(heights[x][y] - heights[x][y+1]) <= d) nextTo = true;
      if (!nextTo) return false;
    }
    return true;
  }
  static void dfs(int x, int y, int bef, int d) {
    if (outOfBounds(x, y) || visited[x][y] || Math.abs(bef - heights[x][y]) > d) return;
    visited[x][y] = true;
    dfs(x+1, y, heights[x][y], d);
    dfs(x-1, y, heights[x][y], d);
    dfs(x, y+1, heights[x][y], d);
    dfs(x, y-1, heights[x][y], d);
  }
  static boolean outOfBounds(int x, int y) {
    return !(x >= 0 && y >= 0 && x < m && y < n);
  }
}
