import java.util.*;
import java.io.*;

public class CowArt {
  static int n;
  static String[][] arr;
  static boolean[][] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("cowart.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("cowart.out"));
    n = Integer.parseInt(br.readLine());
    arr = new String[n][n];
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        arr[i][j] = inp[j];
      }
    }
    int c1 = 0;
    int c2 = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          floodfill(i, j, arr[i][j]);
          c1++;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j].equals("G")) arr[i][j] = "R";
        visited[i][j] = false;
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          floodfill(i, j, arr[i][j]);
          c2++;
        }
      }
    }
    pw.println(c1 + " " + c2);
    pw.close();
  }
  public static void floodfill(int x, int y, String color) {
    if (x <0 || x >= n || y < 0 || y >= n || !arr[x][y].equals(color) || visited[x][y]) return;
    visited[x][y] = true;
    floodfill(x+1, y, color);
    floodfill(x-1, y, color);
    floodfill(x, y+1, color);
    floodfill(x, y-1, color);
  }
}
