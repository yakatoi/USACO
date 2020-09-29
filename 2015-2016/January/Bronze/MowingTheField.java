import java.util.*;
import java.io.*;

public class MowingTheField {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("mowing.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("mowing.out"));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[2001][2001];
    int x = 1000;
    int y = 1000;
    int min = Integer.MAX_VALUE;
    int t = 0;
    for (int ins = 0; ins < n; ins++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String dir = st.nextToken();
      int len = Integer.parseInt(st.nextToken());
      for (int i = 0; i < len; i++) {
        t++;
        if (dir.equals("N")) {
          y++;
          if (arr[x][y]!=0) {
            min = Math.min(min, t - arr[x][y]);
          }
          arr[x][y] = t;
        }
        if (dir.equals("S")) {
          y--;
          if (arr[x][y]!=0) {
            min = Math.min(min, t - arr[x][y]);
          }
          arr[x][y] = t;
        }
        if (dir.equals("W")) {
          x--;
          if (arr[x][y]!=0) {
            min = Math.min(min, t - arr[x][y]);

          }
          arr[x][y] = t;
        }
        if (dir.equals("E")) {
          x++;
          if (arr[x][y]!=0) {
            min = Math.min(min, t - arr[x][y]);

          }
          arr[x][y] = t;
        }
      }
    }
    pw.println(min==Integer.MAX_VALUE ? -1 : min);
    pw.close();
  }
}
