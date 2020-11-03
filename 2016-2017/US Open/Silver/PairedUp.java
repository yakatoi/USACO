import java.util.*;
import java.io.*;

public class PairedUp {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
    int n = Integer.parseInt(br.readLine());
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      map.put(b, a);
    }
    int max = 0;
    //System.out.println(map);
    while (map.size() > 1) {
      int first = map.firstKey();
      int last = map.lastKey();
      int firstval = map.get(first);
      int lastval = map.get(last);
      max = Math.max(max, last + first);
      if (firstval == lastval) {
        map.remove(first);
        map.remove(last);
      }
      else if (firstval > lastval) {
        map.put(first, firstval - lastval);
        map.remove(last);
      }
      else {
        map.put(last, lastval - firstval);
        map.remove(first);
      }
    }
    if (map.size()==1) max = Math.max(max, 2*map.firstKey());
    pw.println(max);
    pw.close();
  }
}
