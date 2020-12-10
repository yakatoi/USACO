import java.util.*;
import java.io.*;

public class DecoratingThePastures {
  static int[] visited;
  static int jcount, icount;
  static HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("decorate.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("decorate.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    visited = new int[n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      if (!graph.keySet().contains(a)) graph.put(a, new HashSet<Integer>());
      if (!graph.keySet().contains(b)) graph.put(b, new HashSet<Integer>());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    //System.out.println(graph);
    for (int j = 0; j < n; j++) {
      if (visited[j] == 0) {
        int[] old = visited.clone();
        int oldi = icount;
        int oldj = jcount;
        for (int i = 0; i < n; i++) {
          old[i] = visited[i];
        }
        dfs(j, 1);
        if ((icount-oldi)> (jcount-oldj)) {
          icount = oldi;
          jcount = oldj;
          for (int i = 0; i < n; i++) {
            visited[i] = old[i];
          }
          dfs(j, -1);
        }
      }
    }
    boolean screwup = false;
    for (int i = 0; i < n; i++) {
      if (!graph.keySet().contains(i)) continue;
      for (int node : graph.get(i)) {
        if (visited[node] == visited[i]) screwup = true;
      }
    }
    if (screwup) {
      pw.println(-1);
    }
    else {
      pw.println(jcount);
    }
    pw.close();
  }
  static void dfs(int node, int mark) {
    visited[node] = mark;
    if (mark==1) {
      jcount++;
    }
    else {
      icount++;
    }
    if (!graph.keySet().contains(node)) return;
    for (int edge : graph.get(node)) {
      if (visited[edge] == 0) {
        dfs(edge, mark*-1);
      }
    }
  }
}
