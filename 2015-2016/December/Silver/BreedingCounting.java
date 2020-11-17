import java.util.*;
import java.io.*;

public class BreedingCounting {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    int[] a = new int[n+1];
    int[] b = new int[n+1];
    int[] c = new int[n+1];
    a[0] = b[0] = c[0] = 0;
    for (int i = 1; i <= n; i++) {
      int inp = Integer.parseInt(br.readLine());
      a[i] = a[i-1];
      b[i] = b[i-1];
      c[i] = c[i-1];
      if (inp==1) a[i]++;
      if (inp==2) b[i]++;
      if (inp==3) c[i]++;
    }
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      pw.println((a[y]-a[x-1]) + " " + (b[y]-b[x-1]) + " "  + (c[y]-c[x-1]));
    }
    pw.close();
  }
}
