import java.util.*;
import java.io.*;

public class MooTube {

  public static HashMap<Integer, ArrayList<Pair>> graph;

  public static void main(String[] args) throws IOException {
    //System.out.println("_____________________________________________________");
    BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
    String[] inp = br.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    int q = Integer.parseInt(inp[1]);
    graph = new HashMap();
    for (int i = 1; i <= n; i++) {
      ArrayList<Pair> al = new ArrayList<Pair>();
      al.add(new Pair(-1, -1));
      graph.put(i, new ArrayList<Pair>(al));
    }
    boolean[] bool = new boolean[n+1];
    for (int i = 0; i < n-1; i++) {
      int[] inp1 = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
      Pair p1 = new Pair(inp1[1], inp1[2]);
      Pair p2 = new Pair(inp1[0], inp1[2]);
      if (graph.get(inp1[0]).size()==1 && !bool[inp1[0]]) {
        graph.get(inp1[0]).get(0).n = p1.n;
        graph.get(inp1[0]).get(0).w = p1.w;
        bool[inp1[0]] = true;
      }
      else {
        graph.get(inp1[0]).add(p1);
      }
      if (graph.get(inp1[1]).size()==1 && !bool[inp1[1]]) {
        graph.get(inp1[1]).get(0).n = p2.n;
        graph.get(inp1[1]).get(0).w = p2.w;
        bool[inp1[1]] = true;
      }
      else {
        graph.get(inp1[1]).add(p2);
      }
    }
    for (int i = 1; i <= n; i++) {
      graph.get(i).remove(new Pair(-1, -1));
    }
    //System.out.println(graph);
    for (int i = 1; i <=n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i!=j) {
          boolean cond = false;
          for (Pair p: graph.get(i)) {
            if (p.n==j) {
              cond = true;
            }
          }
          if (!cond) {
            //System.out.println( i + ", " + j);
            ArrayList<Integer> l = new ArrayList<Integer>(dfs(i, j, new boolean[n+1], new ArrayList<Integer>()));
            Collections.reverse(l);
            l.add(0, i);
            //System.out.println("The path from " + i + " to " + j + " is: " + l);
            int min = Integer.MAX_VALUE;
            int we = 0;
            for (int csc = 0; csc < l.size()-1; csc++) {
              for (Pair p: graph.get(l.get(csc))) {
                if (p.n==l.get(csc+1)) {
                  we = p.w;
                }
                min = Math.min(we, min);
              }
            }
            min = Math.min(min, we);
            //System.out.println(i + ", " + j + "   :   " + min);
            graph.get(i).add(new Pair(j, min));
          }
        }
      }
    }
    //System.out.println(graph);
    for (int i = 0; i < q; i++) {
      String[] input = br.readLine().split(" ");
      int ki = Integer.parseInt(input[0]);
      int vi = Integer.parseInt(input[1]);
      int counter = 0;
      for (Pair p : graph.get(vi)) {
        if (p.w >= ki) {
          counter++;
        }
      }
      pw.println(counter);
    }
    pw.close();
  }

  public static ArrayList<Integer> dfs(int node, int dest, boolean hasVisited[], ArrayList<Integer> path) {
    hasVisited[node] = true;
    for (Pair p: graph.get(node)) {
      if (!hasVisited[p.n]) {
        hasVisited[p.n] = true;
        ArrayList<Integer> al = dfs(p.n, dest, hasVisited, path);
        if (al.contains(dest) || p.n==dest) {
          path.add(p.n);
          break;
        }
      }
    }
    return path;
  }

  public static class Pair {
    public int n;
    public int w;

    public Pair (int nod1, int weigh1) {
      n = nod1;
      w = weigh1;
    }
    public String toString() {
        return "(" + n + ", " + w + ")";
    }
  }
}
