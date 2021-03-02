import java.util.*;
import java.io.*;

public class JustGreenEnough {
  public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    long[][] arr = new long[n+1][n+1];
    long[][] pre = new long[n+1][n+1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j<= n; j++) {
        int inp = Integer.parseInt(st.nextToken());
        if (inp > 100) arr[i][j] = 0;
        else if (inp < 100) arr[i][j] = 3;
        else arr[i][j] = 100000;
      }
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        pre[i][j] = arr[i][j] + pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
      }
    }
    // System.out.println("e");
    long counter =0;
    for (int x1 = 1; x1 <= n; x1++) {
      for (int y1 = 1; y1 <= n; y1++) {
        for (int x2 = x1; x2 <= n; x2++) {
          for (int y2 = y1; y2 <= n; y2++) {
            long sum = pre[x2][y2] - pre[x1-1][y2] - pre[x2][y1-1] + pre[x1-1][y1-1];
            if (sum % 100000 == 0 && sum!=0) counter++;
          }
        }
      }
    }
    System.out.println(counter);
  }
}
