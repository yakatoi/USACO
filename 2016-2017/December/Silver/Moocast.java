import java.util.*;
import java.io.*;
import java.lang.*;

public class Moocast {

  public static HashMap<Integer, ArrayList<Integer>> graph;

  public static void main(String[] args) throws IOException {
    //System.out.println("-----------------------------------------------------------------");
    BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("moocast.out"));
    int n = Integer.parseInt(br.readLine());
    graph = new HashMap();
    for (int i = 1; i <= n; i++) {
      graph.put(i, new ArrayList<Integer>(Collections.singleton(-1)));
    }
    double[][] arr = new double[n][3];
    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split(" ");
      arr[i][0] = Double.parseDouble(inp[0]);
      arr[i][1] = Double.parseDouble(inp[1]);
      arr[i][2] = Double.parseDouble(inp[2]);
      //System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i!=j) {
          if (dist(arr[i][0], arr[i][1], arr[j][0], arr[j][1], arr[i][2])) {
            graph.get(i+1).add(j+1);
          }
        }
      }
    }
    for (int i = 1; i <= n; i++) {
      graph.get(i).remove(Integer.valueOf(-1));
    }
    //System.out.println(graph);
    int maxNodes = 0;
    for (int i = 1; i <= n; i++) {
      int vi = dfs(i, new boolean[n+1]);
      maxNodes = Math.max(vi, maxNodes);
    }
    pw.println(maxNodes);
    pw.close();
  }
  public static int dfs(int node, boolean[] visited) {
    visited[node] = true;
    for (int it: graph.get(node)) {
      if (!visited[it]) {
        int useless = dfs(it, visited);
      }
    }
    int count = 0;
    for (boolean bool : visited) {
      count = bool ? count + 1 : count;
    }
    return count;
  }
  public static boolean dist(double x1, double y1, double x2, double y2, double pow) {
    double d = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    return pow >= d;
  }
}
