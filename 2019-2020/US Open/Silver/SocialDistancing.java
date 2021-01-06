import java.util.*;
import java.io.*;

public class SocialDistancing {
  public static int n;
  public static int m;
  public static int[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("soc.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("socdist.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[m][2];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr, (a, b) -> (Integer.compare(a[0], b[0])));
    int lo = 1;
    int hi = arr[m-1][1] - arr[0][0];
    int mid = (lo+hi)/2;
    int ans = 0;
    while (lo <= hi) {
      mid = (lo+mid)/2;
      if (check(mid)) {
        ans = mid;
        lo = mid +1;
      }
      else {
        hi = mid-1;
      }
    }
    System.out.println(ans);
    pw.close();
    if (!check(x)) {
      else {
        System.out.println()
      }
    }
  }
  public static boolean check(int d) {
    int prev = Integer.MIN_VALUE;
    int counter = 0;
    outer: for (int i = 0; i < m; i++) {
      while (Math.max(prev + d, arr[i][0]) <= arr[i][1]) {
        if (counter >= n) break outer;
        prev = Math.max(prev + d, arr[i][0]);
        counter++;
      }
    }
    return (counter >= n);
  }
}
