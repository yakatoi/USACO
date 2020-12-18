import java.util.*;
import java.io.*;

public class LoanRepayment {
  static long n, m, k;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("loan.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("loan.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Long.parseLong(st.nextToken());
    m = Long.parseLong(st.nextToken());
    k = Long.parseLong(st.nextToken());
    long a = 1;
    long b = Integer.MAX_VALUE;
    while (a != b) {
      long mid = (a+b + 1)/2;
      if (works(mid)) {
        a = mid;
      }
      else {
        b = mid-1;
      }
    }
    System.out.println(a);
    pw.println(a);
    pw.close();
  }
  static boolean works(long x) {
    long g = 0;
    long lim = k;
    while(g < n && lim > 0) {
      long y = (n-g)/x;
      if (y < m) {
        return (n-g+m-1) / m <= lim;
      }
      long i = (n-(g+x*y))/y + 1;
      i = Math.max(i, lim);
      g += y * i;
      lim -= i;
    }
    return g >= n;
  }
}
