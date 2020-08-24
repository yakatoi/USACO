import java.util.*;
import java.io.*;

public class BreedingCounting {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    int[] h = new int[n]; int[] hp = new int[n];
    int[] g = new int[n]; int[] gp = new int[n];
    int[] j = new int[n]; int[] jp = new int[n];

    for (int i = 0; i < n; i++) {
      int inp = Integer.parseInt(br.readLine());
      if (inp==1)
        h[i]++;
      if (inp==2)
        g[i]++;
      if (inp==3)
        j[i]++;
    }

    hp[0] = h[0];
    gp[0] = g[0];
    jp[0] = j[0];

    for (int i = 1; i < n; i++) {
      hp[i] = hp[i-1] + h[i];
      gp[i] = gp[i-1] + g[i];
      jp[i] = jp[i-1] + j[i];
    }

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;

      if (a==0)
        pw.println(hp[b] + " " + gp[b] + " " + jp[b]);
      else
        pw.println((hp[b]-hp[a-1]) + " " + (gp[b]-gp[a-1]) + " " + (jp[b]-jp[a-1]));
    }
    pw.close();
  }
}
