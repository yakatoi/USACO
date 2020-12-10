import java.util.*;
import java.io.*;

public class Odometer {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("odometer.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("odometer.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long x = Long.parseLong(st.nextToken());
    long y = Long.parseLong(st.nextToken());
    x--;
    long xlen = (x+"").length();
    long ylen = (y+"").length();
    long ans = simulate(y, ylen) - simulate(x, xlen);
    pw.println(ans);
    pw.close();
  }
  static long simulate(long x, long len) {
    long counter = 0;
    for (long i = 3; i <= len-1; i++) {
      counter+=81L * i;
    }
    for (long i = 0; i < 10; i++) {
      for (long j = 0; j < 10; j++) {
        if (i != j) {
          counter = add(counter, x, i, j, len);
        }
      }
    }
    return counter;

  }
  static long add(long counter, long k, long a, long b, long n) {
    long count = 0;
    for (long i = 0; i < n; i++) {
      if (i ==0 && b==0) continue;
      if (i != 0 && a==0) continue;
      long newlong = generateInt(a, b, i, (n-1) - i);
      if (newlong <= k) count++;
    }
    return count + counter;

  }
  static long generateInt(long a, long b, long one, long two) {
    String str = "";
    for (long i = 1; i <= one; i++) {
      str+=a + "";
    }
    str+=b + "";
    for (long i = 1; i <= two; i++) {
      str+=a+ "";
    }
    return Long.parseLong(str);
  }
}
