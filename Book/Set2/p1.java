import java.util.*;
import java.io.*;

public class p1 {
  static int n, m;
  static int[][] arr;
  static int large;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    StringTokenizer st =new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        if (inp[j].equals("*")) {
          arr[i][j] = 1;
        }
      }
    }
    for (int[] row : arr) System.out.println(Arrays.toString(row));
    System.out.println(test(2, 2));
  }
  public static boolean test(int a, int b) {
    int u = 0; int d = 0; int l = 0; int r = 0;
    for (int i = a+1; i < n; i++) {
      if (arr[i][b] == 1) r++;
      else break;
    }
    for (int i = a-1; i >= 0; i--) {
      if (arr[i][b] == 1) l++;
      else break;
    }
    for (int j = b+1; j < m; j++) {
      if (arr[a][j] == 1) u++;
      else break;
    }
    for (int j = b-1; j >= 0; j--) {
      if (arr[a][j] == 1) d++;
      else break;
    }
    if (u*d*l*r == 0) return false;
    return u+d+l+r == large-1;
  }
}
