import java.util.*;
import java.io.*;

public class Convention {
  public static int n, m, c;
  public static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("convention.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("convention.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
    Arrays.sort(arr);
    int lo = 0;
    int hi = arr[n-1] - arr[0];
    while (lo != hi) {
      int mid =(lo+hi)/2;
      if (works(mid)) {
        hi = mid;
      }
      else {
        lo = mid+1;
      }
    }
    pw.println(lo);
    pw.close();
  }
  public static boolean works(int x) {
    int counter = 1;
    int slider = arr[0] + x;
    int bus = 1;
    for (int i = 1; i < n; i++) {
      if (counter > m) return false;
      if (arr[i] <= slider && bus < c) {
        bus++;
      }
      else {
        bus = 1;
        slider = arr[i] + x;
        counter++;
      }
    }
    return counter <= m;
  }
}
