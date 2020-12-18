import java.util.*;
import java.io.*;

public class FairPhotography {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("fairphoto.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("fairphoto.out"));
    int n = Integer.parseInt(br.readLine());
    Cow[] arr = new Cow[n+1];
    arr[0] = new Cow(-1, "");
    int[] g = new int[n+1];
    int[] h = new int[n+1];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int in = Integer.parseInt(st.nextToken());
      String str = st.nextToken();
      arr[i+1] = new Cow(in, str);
    }
    Arrays.sort(arr, (a, b) -> (Integer.compare(a.p, b.p)));
    for (int i = 1; i <= n; i++) {
      if (arr[i].b== 1) g[i]++;
      else h[i]++;
      g[i]+=g[i-1];
      h[i]+=h[i-1];
    }
    int[] gminush = new int[n+1];
    for (int i = 1; i <= n; i++) {
      gminush[i] = h[i] - g[i];
    }
    HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();
    for (int i = 1; i <= n; i++) {
      if (!map.keySet().contains(gminush[i])) map.put(gminush[i], new Pair(i, i));
      map.get(gminush[i]).update(i);
    }
    // System.out.println(map);
    int maxSize = 0;
    for (int key : map.keySet()) {
      Pair p = map.get(key);
      int photo = arr[p.end].p - arr[p.start+1].p;
      maxSize = Math.max(photo, maxSize);
    }
    System.out.println(maxSize);
    pw.println(maxSize);
    pw.close();
  }
  static class Pair {
    int start, end;
    public Pair(int st, int en) {
      start = st;
      end = en;
    }
    public void update(int x) {
      start = Math.min(start, x);
      end = Math.max(end, x);
    }
    public String toString() {
      return start + " " + end;
    }
  }
  static class Cow {
    int p, b;
    public Cow(int x, String y) {
      p=x;
      b=y.equals("G") ? 1 : 0;
      if (y.length()==0) b = -1;
    }
    public String toString() {
      return p + " " + b;
    }
  }
}
