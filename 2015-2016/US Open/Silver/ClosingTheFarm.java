import java.util.*;
import java.io.*;

public class ClosingTheFarm {

  public static HashMap<Integer, ArrayList<Integer>> graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("closing.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
    String[] inp = br.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    int m = Integer.parseInt(inp[1]);
    graph = new HashMap();
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<Integer>());
    }
    for (int i = 0; i < m; i++) {
      int[] inp1 = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
      graph.get(inp1[0] - 1).add(inp1[1] -1);
      graph.get(inp1[1] - 1).add(inp1[0] -1);
    }
    for (int i = 0; i < n; i++) {
      //pw.println(i + ":" + graph.get(i));
    }
    TreeSet<Integer> vert = new TreeSet<Integer>();
    for (int i = 0; i < n; i++) {
      vert.add(i);
    }
    pw.println(numOfNodes(0, new boolean[n])==n?"YES":"NO");
    for (int i = n-1; i > 1; i--) {
      int rem = Integer.parseInt(br.readLine())-1;
      graph.remove(rem);
      vert.remove(rem);
      for (int it: graph.keySet()) {
        ArrayList<Integer> al = new ArrayList<Integer>(graph.get(it));
        al.removeAll(Collections.singleton(rem));
        graph.replace(it, al);
      }
      pw.println(numOfNodes(vert.first(), new boolean[n])==i?"YES":"NO");
    }
    pw.println("YES");
    pw.close();

  }

  public static int numOfNodes(int node, boolean[] visited) {
    visited[node] = true;
    for (int it: graph.get(node)) {
      if (!visited[it]) {
        int useless = numOfNodes(it, visited);
      }
    }
    int count = 0;
    for (boolean bool : visited) {
      count = bool ? count + 1 : count;
    }
    return count;
  }
}
