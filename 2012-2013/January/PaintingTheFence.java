import java.util.*;
import java.io.*;

public class PaintingTheFence {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("paint.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("paint.out"));
    int n = Integer.parseInt(br.readLine());
    HashSet<Integer> nec = new HashSet<Integer>();
    int p = 0;
    nec.add(p);
    int[] a = new int[n];
    String[] b = new String[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int move = Integer.parseInt(st.nextToken());
      String dir = st.nextToken();
      a[i] = move;
      b[i] = dir;
      if (dir.equals("R")) {
        p+=move;
      }
      else {
        p-=move;
      }
      nec.add(p);
    }
    //System.out.println(nec);
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int po : nec) {
      map.put(po, 0);
    }
    //System.out.println(map);
    int cur = 0;
    for (int i = 0; i < n; i++) {
      int prev = cur;
      if (b[i].equals("R")) {
        cur+=a[i];
      }
      else {
        cur-=a[i];
      }
      if (prev < cur) {
        map.put(prev, map.get(prev) - 1);
        map.put(cur, map.get(cur) + 1);
      }
      else {
        map.put(cur, map.get(cur) - 1);
        map.put(prev, map.get(prev) + 1);
      }
    }
    ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
    Collections.sort(keys, Collections.reverseOrder());
    int ans = 0;
    int sum = 0;
    for (int i = 0; i < keys.size()-1; i++) {
      sum+=map.get(keys.get(i));
      if (sum >= 2) {
        ans+=keys.get(i) - keys.get(i+1);
      }
    }
    pw.println(ans);
    pw.close();
  }
  public static class Entry implements Comparable<Entry> {
    public int pos;
    public int tim;

    public Entry(int p, int t) {
      pos = p;
      tim = t;
    }
    public Entry(int p) {
      pos = p;
      tim = 0;
    }
    public int compareTo(Entry e) {
      return Integer.compare(pos, e.pos);
    }
    public String toString() {
      return "(" + pos + ", " + tim + ")";
    }
  }
}
