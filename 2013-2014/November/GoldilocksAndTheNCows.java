import java.util.*;
import java.io.*;

public class GoldilocksAndTheNCows {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("milktemp.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("milktemp.out"));
    int n, x, y, z;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    z = Integer.parseInt(st.nextToken());
    ArrayList<Number> al = new ArrayList<Number>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      al.add(new Number(Integer.parseInt(st.nextToken()), "A"));
      al.add(new Number(Integer.parseInt(st.nextToken()), "B"));
    }
    Collections.sort(al);
    //System.out.println(al);
    int cur = n*x;
    int ans = cur;
    for (Number num : al) {
      if (num.t.equals("A")) {
        cur+=y-x;
      }
      else {
        cur+=z-y;
      }
      ans = Math.max(cur, ans);
    }
    pw.println(ans);
    pw.close();

  }
  public static class Number implements Comparable<Number> {
    public int q;
    public String t;

    public Number(int q, String t) {
      this.q = q;
      this.t = t;
    }
    public int compareTo(Number num) {
      if (q==num.q) return num.t.equals("A") ? 1: -1;
      return Integer.compare(q, num.q);
    }
    public String toString() {
      return "(" + q + ", " + t + ")";
    }

  }
}
