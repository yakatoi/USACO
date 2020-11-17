import java.util.*;
import java.io.*;

public class AngryCows {
  public static int n, k;
  public static long[] bales;
  public static void main(String[] args) throws IOException {
    BufferedReader br= new BufferedReader(new FileReader("angry.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("angry.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    bales = new long[n];
    for (int i = 0; i < n; i++) {
      bales[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(bales);
    long lo = 1;
    long hi = bales[n-1] - bales[0];
    while (lo!=hi) {
      long mid = (lo+hi)/2;
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
  public static boolean works(long x) {
    int counter = 1;
    long b = bales[0] + 2*x;
    for (int i = 0; i < n; i++) {
      if (bales[i] > b) {
        counter++;
        b = bales[i] + 2*x;
      }
      if (counter > k) break;
    }
    return counter <= k;
  }
}
