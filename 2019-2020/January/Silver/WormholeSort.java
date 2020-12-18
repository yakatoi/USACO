import java.util.*;
import java.io.*;

public class WormholeSort {
  public static int[] parent;
  public static void print() {
    System.out.println(Arrays.toString(parent));
  }
  public static void initialize(int n) {
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }
  public static int find(int x) {
    if (x==parent[x]) {
      return x;
    }
    else {
      parent[x] = find(parent[x]);
      return parent[x];
    }
  }
  public static void union(int a, int b) {
    int c = find(a);
    int d = find(b);
    if (c < d) {
      parent[d] = c;
    }
    if (d < c) {
      parent[c] = d;
    }
  }
  public static int n;
  public static int m;
  public static int[] arr;
  public static Wormhole[] holes;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("wormsort.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("wormsort.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)-1).toArray();
    holes = new Wormhole[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      holes[i] = new Wormhole(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
    }
    //System.out.println(Arrays.toString(holes));
    //for (int i = 0; i < 20; i++) System.out.println(i+ " " + binarySearch(i));
    int lo = 0;
    int hi = (int) Math.pow(10, 9);
    int ans = -1;
    while (lo <= hi) {
      int mid = (hi+lo)/2;84040
      if (binarySearch(mid)) {
        ans = mid;
        lo = mid+1;
      }
      else {
        hi = mid-1;
      }
    }
    if (isSorted()) ans = -1;
    pw.println(ans);
    pw.close();
  }
  public static boolean binarySearch(int x) {
    initialize(n);
    for (Wormhole worm : holes) {
      if (worm.w >= x) {
        union(worm.a, worm.b);
      }
    }
    for (int i = 0; i < n; i++) {
      if (find(i) != find(arr[i])) {
        return false;
      }
    }
    return true;
  }
  public static boolean isSorted() {
    for (int i = 1; i < n; i++) {
      if (arr[i] <= arr[i-1]) {
        return false;
      }
    }
    return true;
  }
  public static class Wormhole {
    public int a;
    public int b;
    public int w;
    public Wormhole(int x, int y, int z) {
      a=x;
      b=y;
      w=z;
    }
    public String toString() {
      return "(" + a + " to " + b + ", width = " + w + ")";
    }
  }
}
