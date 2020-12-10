import java.util.*;
import java.io.*;

public class MooTube {

  public static HashMap<Integer, ArrayList<Edge>> graph = new HashMap<Integer, ArrayList<Edge>>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<Edge>());
    }
    for (int i = 0; i < n-1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      int r = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Edge(b, r));
      graph.get(b).add(new Edge(a, r));
    }
    //System.out.println(graph);
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      int star = Integer.parseInt(st.nextToken())-1;
      pw.println(allAboveK(k, n, star));
    }
    pw.close();
  }

  public static int allAboveK(int k, int n, int start) {
    boolean[] visited = new boolean[n];
    int counter = 0;
    visited[start] = true;
    Queue<Integer> q  = new LinkedList<Integer>();
    q.add(start);
    while (!q.isEmpty()) {
      int v = q.poll();
      for (Edge e : graph.get(v)) {
        if (!visited[e.v] && e.w>=k) {
          counter++;
          q.add(e.v);
        }
        visited[e.v] = true;
      }
    }
    return counter;
  }

  public static class Edge {
    public int v;
    public int w;

    public Edge (int v, int w) {
      this.v = v;
      this.w = w;
    }
    public String toString() {
        return "(" + v + ", " + w + ")";
    }
  }
}
