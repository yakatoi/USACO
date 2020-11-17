import java.util.*;
import java.io.*;

public class BessieGetsEven {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("geteven.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("geteven.out"));
    int n = Integer.parseInt(br.readLine());
    HashMap<String, Pair> map = new HashMap<String, Pair>();
    map.put("B", new Pair(0L, 0L));map.put("E", new Pair(0L, 0L));map.put("S", new Pair(0L, 0L));map.put("I", new Pair(0L, 0L));map.put("G", new Pair(0L, 0L));map.put("O", new Pair(0L, 0L));map.put("M", new Pair(0L, 0L));
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String type = st.nextToken();
      int inp = Integer.parseInt(st.nextToken());
      if (inp%2==0) {
        map.get(type).even++;
      }
      else {
        map.get(type).odd++;
      }
    }
    //System.out.println(map);
    long one = map.get("M").odd;
    long two = map.get("B").even*map.get("I").odd + map.get("B").odd*map.get("I").even;
    long three = map.get("G").odd*map.get("O").odd*map.get("E").odd*map.get("S").even+
                map.get("G").odd*map.get("O").odd*map.get("E").even*map.get("S").odd+
                map.get("G").odd*map.get("O").even*map.get("E").odd*map.get("S").odd+
                map.get("G").even*map.get("O").odd*map.get("E").odd*map.get("S").odd+
                map.get("G").even*map.get("O").even*map.get("E").even*map.get("S").odd+
                map.get("G").even*map.get("O").even*map.get("E").odd*map.get("S").even+
                map.get("G").even*map.get("O").odd*map.get("E").even*map.get("S").even+
                map.get("G").odd*map.get("O").even*map.get("E").even*map.get("S").even;
    long ans = one*two*three;
    long whole = 1;
    for (Pair p : map.values()) {
      whole*= (p.odd + p.even);
    }
    pw.println(whole - ans);
    pw.close();
  }
  public static class Pair {
    public long even, odd;

    public Pair(long x, long y) {
      even = x;
      odd = y;
    }
    public String toString() {
      return "(" + even + ", " + odd + ")";
    }
  }
}
