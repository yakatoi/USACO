import java.util.*;
import java.io.*;

public class MilkVisits {
  public static int n, m;
  public static String[] inp;
  public static HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
  public static int[] comp;
  public static int counter = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("milkvisits.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    inp = br.readLine().split("");
    comp = new int[n];
    Arrays.fill(comp, -1);
    for (int i = 0; i < n; i++) graph.put(i, new HashSet<Integer>());
    for (int i = 0; i < n-1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) -1;
      int b = Integer.parseInt(st.nextToken()) -1;
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    //System.out.println(graph);
    String ans="";
    for (int i = 0; i < n; i++) {
      if (comp[i]==-1) {
        dfs(i);
        counter++;
      }
    }
    //System.out.println(Arrays.toString(comp));
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) -1;
      int b = Integer.parseInt(st.nextToken()) -1;
      String type = st.nextToken();
      if (comp[a]!=comp[b]) {
        ans+=1;
      }
      else {
        ans += inp[a].equals(type) ? 1 : 0;
      }
    }
    
    pw.println(ans);
    pw.close();
  }
  public static void dfs(int vert) {
    if (comp[vert]!=-1) return;
    comp[vert] = counter;
    for (int edge : graph.get(vert)) {
      if (inp[vert].equals(inp[edge])) {
        dfs(edge);
      }
    }
  }
}
