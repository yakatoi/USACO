import java.util.*;
import java.io.*;

public class MirrorField {
  static int n, m;
  static String[][] arr;
  static boolean cycle;
  public static void main(String[] args) throws IOException {
    BufferedReader br=  new BufferedReader(new FileReader("mirror.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("mirror.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new String[n][m];
    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split("");
      for(int j = 0; j < m; j++) {
        arr[i][j] = inp[j];
      }
    }
    int max = 0;
    for (int i = 0; i < m; i++) {
      max = Math.max(max, recurse(0, i, 0, 0));
    }
    for (int i = 0; i < m; i++) {
      max = Math.max(max, recurse(n-1, i, 2, 0));
    }
    for (int i = 0; i < n; i++) {
      max = Math.max(max, recurse(i, 0, 1, 0));
    }
    for (int i = 0; i < n; i++) {
      max = Math.max(max, recurse(i, m-1, 3, 0));
    }
    pw.println(max);
    pw.close();

  }
  public static int recurse(int i, int j, int dir, int counter) {
    if (!isBounds(i, j)) return counter;
    counter++;
    if (arr[i][j].equals("/")) {
      if (dir==0) {
        counter = recurse(i, j-1, 3, counter);
      }
      if (dir==1) {
        counter = recurse(i-1, j, 2, counter);
      }
      if (dir==2) {
        counter = recurse(i, j+1, 1, counter);
      }
      if (dir==3) {
        counter = recurse(i+1, j, 0, counter);
      }
    }
    else {
      if (dir==0) {
        counter = recurse(i, j+1, 1, counter);
      }
      if (dir==1) {
        counter = recurse(i+1, j, 0, counter);
      }
      if (dir==2) {
        counter = recurse(i, j-1, 3, counter);
      }
      if (dir==3) {
        counter = recurse(i-1, j, 2, counter);
      }
    }
    return counter;
  }
  public static boolean isBounds(int x, int y) {
    return x >= 0 && y >= 0 && x<n && y <m;
  }
}
