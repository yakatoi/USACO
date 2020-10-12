import java.util.*;
import java.io.*;

public class Horseshoes {

  public static int ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("hshoe.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("hshoe.out"));
    int n = Integer.parseInt(br.readLine());
    String[][] arr = new String[n][n];
    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        arr[i][j] = inp[j].equals(")") ? "1" : "0";
      }
    }
    if (arr[0][0].equals("1")) {
      pw.println(0);
    }
    else {
      floodfill(arr,new boolean[n][n], n, 0, 0, "");
      pw.println(ans);
    }
    pw.close();
  }
  public static void floodfill(String[][] arr, boolean[][] visited, int n, int x, int y, String str) {
    if (!(x >= 0 && y >= 0 && x < n && y < n)) {
      return;
    }
    if (visited[x][y]) {
      return;
    }
    visited[x][y] = true;
    str = str + arr[x][y];
    check(str);
    boolean[][] bool = duplicate(visited);
    floodfill(arr, bool, n, x+1, y, str);
    bool = duplicate(visited);
    floodfill(arr, bool, n, x, y+1, str);
    bool = duplicate(visited);
    floodfill(arr, bool, n, x-1, y, str);
    bool = duplicate(visited);
    floodfill(arr, bool, n, x, y-1, str);
  }

  public static void check(String str) {
    if (str.length()%2==1) {
        return;
    }
    if (str.substring(0, str.length()/2).equals(repeat("0", str.length()/2)) && str.substring(str.length()/2, str.length()).equals(repeat("1", str.length()/2))) {
        ans = Math.max(str.length(), ans);
    }
  }
  public static boolean[][] duplicate(boolean[][] visited) {
    int n = visited.length;
    boolean[][] bool = new boolean[n][n];
    for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        bool[i][j] = visited[i][j];
    }}
    return bool;
  }
  public static String repeat(String str, int n) {
    String answ = "";
    for (int i = 0; i<n; i++) {
      answ = answ + str;
    }
    return answ;
  }

}
