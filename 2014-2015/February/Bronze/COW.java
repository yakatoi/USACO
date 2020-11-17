import java.util.*;
import java.io.*;

public class COW {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("cow.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("cow.out"));
    int n = Integer.parseInt(br.readLine());
    String[] arr = br.readLine().split("");
    long[] c = new long[n+1];
    long[] co = new long[n+1];
    long[] cow = new long[n+1];
    for (int i = 1; i <= n; i++) {
      c[i] = c[i-1];
      if (arr[i-1].equals("C")) c[i]++;
    }
    for (int i = 2; i <= n; i++) {
      co[i] = co[i-1];
      if (arr[i-1].equals("O")) {
        co[i]+=c[i-1];
      }
    }
    for (int i = 3; i <= n; i++) {
      cow[i] = cow[i-1];
      if (arr[i-1].equals("W")) {
        cow[i]+=co[i-1];
      }
    }
    pw.println(cow[n]);
    pw.close();
  }
}
