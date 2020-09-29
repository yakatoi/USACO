import java.util.*;
import java.io.*;

public class MilkFactory {

  //public static HashMap<Integer, ArrayList<Integer>> graph;
  public static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader("factory.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("factory.out"));

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<Integer>());
    }
    for (int inp = 1; inp < n; inp++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      graph.get(a).add(b);
    }
    //System.out.println(graph);
    boolean[][] visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      boolean[] row = dfs(i, new boolean[n]);
      visited[i] = row.clone();
    }
    //System.out.println(Arrays.deepToString(visited));
    int ans = -1;
    for (int i = 0; i < n; i++) {
      boolean bool = true;
      for (int j = 0; j < n; j++) {
        if (!visited[j][i]) {
          bool = false;
          break;
        }
      }
      if (bool) {
        ans = i;
        break;
      }
    }
    pw.println(ans+1);
    pw.close();

  }
  public static boolean[] dfs(int node, boolean[] visited) {
    visited[node] = true;
    for (int next : graph.get(node)) {
      if (!visited[next]) {
         boolean[] new2 = dfs(next, visited);
         for (int i = 0; i < new2.length; i++) {
          visited[i]  = visited[i] || new2[i];
         }
      }
    }
    return visited;
  }
}
