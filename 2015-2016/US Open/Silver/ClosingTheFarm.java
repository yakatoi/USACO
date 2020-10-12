import java.util.*;
import java.io.*;

public class ClosingTheFarm {

  public static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("closing.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("closing.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    for (int i = 1; i <= n; i++) {
      graph.put(i, new ArrayList<Integer>());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    //System.out.println(graph);
    HashSet<Integer> una = new HashSet<Integer>();
    if (countBool(dfs(1, new boolean[n+1], una))==n) {
      pw.println("YES");
    }
    else {
      pw.println("NO");
    }
    for (int i = 0; i < n-1; i++) {
      int inp = Integer.parseInt(br.readLine());
      una.add(inp);
      if (countBool(dfs(1, new boolean[n+1], una))==n- i -1) {
        pw.println("YES");
      }
      else {
        pw.println("NO");
      }

    }
    pw.close();


  }

  public static int countBool(boolean[] arr) {
    int counter = 0;
    for (boolean bool : arr) {
      if (bool) {
        counter++;
      }
    }
    return counter;
  }

  public static boolean[] dfs(int node, boolean[] visited, HashSet<Integer> una) {
    if (una.contains(node)) {
      return dfs(node+1, visited, una);
    }
    visited[node] = true;
    for (int end : graph.get(node)) {
      if (!una.contains(end) && !visited[end]) {
        boolean[] mid = dfs(end, visited, una);
        for (int i = 0; i < mid.length; i++) {
          visited[i] = visited[i] || mid[i];
        }
      }
    }
    return visited;

  }

}
