import java.util.*;
import java.io.*;

public class MilkVisits {
  static HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
  static int n, m;
  static int[] group;
  static String[] milk;
  static int num = 1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("milkvisits.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    group = new int[n];
    milk = br.readLine().split("");
    for (int i = 0; i < n; i++) graph.put(i, new HashSet<Integer>());
    for (int i = 0; i < n-1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    // System.out.println(graph);
    for (int i = 0; i < n; i++) {
      if (group[i]==0) {
        dfs(i, milk[i]);
        num++;
      }
    }
    // System.out.println(Arrays.toString(group));
    String ans = "";
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      String type =st.nextToken();
      if (group[a]!=group[b] || milk[a].equals(type)) ans+="1";
      else ans+="0";
    }
    pw.println(ans);
    pw.close();
  }
  public static void dfs(int index, String type) {
    if (group[index]!=0 || !milk[index].equals(type)) return;
    group[index] = num;
    for (int node : graph.get(index)) {
      dfs(node, type);
    }
  }
}
