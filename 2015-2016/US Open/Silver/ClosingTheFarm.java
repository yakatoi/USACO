import java.util.*;
import java.io.*;

public class ClosingTheFarm {
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
    if (c < d) parent[d] = c;
    if (d < c) parent[c] = d;
  }
  public static HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("closing.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("closing.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) graph.put(i, new HashSet<Integer>());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) -1;
      int b = Integer.parseInt(st.nextToken())-1;
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    //System.out.println(graph);
    ArrayList<Integer> inp = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) inp.add(Integer.parseInt(br.readLine())-1);
    Collections.reverse(inp);
    HashSet<Integer> set = new HashSet<Integer>();
    ArrayList<String> ans = new ArrayList<String>();
    initialize(n);
    for (int ele : inp) {
      set.add(ele);
      for (int element : graph.get(ele)) {
        if (set.contains(element)) {
          union(ele, element);
        }
      }
      boolean bool = true;
      
      int prev = find(ele);
      for (int element : set) {
        if (find(element)!=prev) { bool = false; }
      }
      if (bool) {
        ans.add("YES");
      }
      else {
        ans.add("NO");
      }
    }
    Collections.reverse(ans);
    for (String str : ans) {
      pw.println(str);
    }
    pw.close();
  }
}
