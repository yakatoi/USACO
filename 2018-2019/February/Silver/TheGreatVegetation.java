import java.util.*;
import java.io.*;

public class TheGreatVegetation {
  public static HashMap<Integer, HashSet<Edge>> graph = new HashMap<Integer, HashSet<Edge>>();
  public static int[] type;
  public static boolean screwup;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("revegetate.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    type = new int[n];
    for (int i = 0; i < n; i++) graph.put(i, new HashSet<Edge>());
    for (int i = 0; i< m; i++) {
      st = new StringTokenizer(br.readLine());
      String id = st.nextToken();
      int a = Integer.parseInt(st.nextToken()) -1;
      int b = Integer.parseInt(st.nextToken()) -1;
      graph.get(a).add(new Edge(id, b));
      graph.get(b).add(new Edge(id, a));
    }
    //System.out.println(graph);
    int num = 0;
    for (int i = 0; i < n; i++) {
      if (screwup) break;
      if (type[i]==0) {
        dfs(1, i);
        num++;
      }
    }
    if (screwup) {
      throw new IOException();
    }
    else {
      pw.println("1" + repeat(num, "0"));
    }
    pw.close();
  }
  public static String repeat(int x, String str) {
    String fin = "";
    for (int i = 0; i < x; i++) {
      fin+=str;
    }
    return fin;
  }
  public static void dfs(int mark, int in) {
    if (type[in]!=0) return;
    type[in] = mark;
    for (Edge edge: graph.get(in)) {
      if (type[in]!= 0 && edge.s.equals("S")) {
        dfs(mark, edge.i);
      }
      else if (type[in]!= 0 && edge.s.equals("D")) {
        dfs(mark * -1, edge.i);
      }
      else if (edge.s.equals("S")) {
        if (type[edge.i]!=type[in]) screwup = true;
      }
      else {
        if (type[edge.i]==type[in]) screwup = true;
      }
    }

  }

  public static class Edge {
    public String s;
    public int i;

    public Edge (String s, int i) {
      this.s = s;
      this.i = i;
    }
    public String toString() {
      return "(" + s + ", " + i + ")";
    }
  }

}
