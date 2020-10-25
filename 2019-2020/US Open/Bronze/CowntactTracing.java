import java.util.*;
import java.io.*;

public class CowntactTracing {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("tracing.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("tracing.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int T = Integer.parseInt(st.nextToken());
    int[] infected = Arrays.stream(br.readLine().split("")).mapToInt(x -> Integer.parseInt(x)).toArray();
    Handshake[] arr = new Handshake[T];
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      arr[i] = new Handshake(t, a, b);
    }
    int counter = 0;
    int max = -1;
    int min = Integer.MAX_VALUE;
    boolean[] possibleCows = new boolean[n];
    Arrays.sort(arr);
    //System.out.println(Arrays.deepToString(arr));
    for (int pos = 0; pos < n; pos++) {
      if (infected[pos]==1) {
        for (int k = 0; k <= T; k++) {
          int[] num = new int[n];
          int[] inf = new int[n];
          inf[pos] = 1;
          boolean yes = false;
          for (Handshake h : arr) {
            boolean aChange = false;
            boolean bChange = false;
            if (num[h.a] < k) {
              if (inf[h.a]==1 && inf[h.b]==0) {
                inf[h.b]=1;
                bChange = true;
              }
            }
            if (num[h.b] < k) {
              if (inf[h.b]==1 && inf[h.a]==0) {
                inf[h.a]=1;
                aChange = true;
              }
            }
            if (!aChange && inf[h.a]==1) {
                num[h.a]++;
            }
            if (!bChange && inf[h.b]==1) {
                num[h.b]++;
            }
          }
          if (Arrays.equals(inf, infected)) {
            possibleCows[pos] = true;
            max = Math.max(k, max);
            min = Math.min(k, min);
          }
        }
      }
    }
    for (boolean bool : possibleCows) {
        if (bool) {
          counter++;
        }
    }
    if (max>=T) {
      pw.println(counter + " " + min + " Infinity");
    }
    else {
      pw.println(counter + " " + min + " " + max);
    }
    pw.close();
  }

  public static class Handshake implements Comparable<Handshake> {
    public int t;
    public int a;
    public int b;

    public Handshake(int t, int a, int b) {
      this.t=t;
      this.a=a;
      this.b=b;
    }
    public int compareTo(Handshake h) {
      return t - h.t;
    }

    public String toString() {
      return "(" + t + " " + a + " " + b + ")";
    }
  }

}
