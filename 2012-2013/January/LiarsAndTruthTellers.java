import java.util.*;
import java.io.*;

public class LiarsAndTruthTellers {
  public static boolean bool = true;
  public static ArrayList<Integer> a = new ArrayList<Integer>();
  public static ArrayList<Integer> b = new ArrayList<Integer>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("truth.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("truth.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] inp = new int[m][3];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      String c = st.nextToken();
      inp[i][0] = a-1;
      inp[i][1] = b-1;
      inp[i][2] = c.equals("L") ? -1 : 1;
    }
    int lo = 1;
    int hi = m;
    //System.out.println(simulate(5, inp, n, m));
    int ans = -1;

    while (lo <= hi) {
      int mid = (lo + hi)/2;
      if (simulate(mid, inp, n, m)) {
        lo = mid + 1;
        ans = mid;
      }
      else {
        hi = mid - 1;
      }
    }

    pw.println(ans);
    pw.close();

  }
  public static boolean simulate(int lines, int[][] inp, int n, int m) {
    bool = true;
    a.clear();
    b.clear();
    HashMap<Integer, ArrayList<Edge>> graph = new HashMap<Integer, ArrayList<Edge>>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<Edge>());
    }
    for (int i = 0; i < lines; i++) {
      graph.get(inp[i][0]).add(new Edge(inp[i][1], inp[i][2]));
      graph.get(inp[i][1]).add(new Edge(inp[i][0], inp[i][2]));
    }
    //System.out.println(graph);
    for (int in : graph.keySet()) {
      HashSet<Integer> set = new HashSet<Integer>();
      for (Edge e : graph.get(in)) {
        if (set.contains(e.node)) {
          return false;
        }
        set.add(e.node);
      }
    }

    boolean[] visited = new boolean[n];
    String[] arr = new String[n];
    Arrays.fill(arr, "");
    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < n; i++) {
      visited[i] = true;
      arr[i] = "A";
      q.add(i);
      while (!q.isEmpty()) {
        int v = q.poll();
        for (Edge e : graph.get(v)) {
          if (!visited[e.node]) {
            visited[e.node] = true;
            String prev = arr[e.node];
            arr[e.node] = e.str.equals("d") ? reverse(arr[v]) : arr[v];
            arr[e.node] = e.str.equals("s") ? (arr[v]) : reverse(arr[v]);
            if (prev.equals("A") || prev.equals("B")) {
              if (!prev.equals(arr[e.node])) {
                return false;
              }
            }
            q.add(e.node);
          }
          else {
            if (e.str.equals("d")) {
                if (arr[e.node].equals(arr[v])) {
                    return false;
                }
            }
            else {
                if (!arr[e.node].equals(arr[v])) {
                    return false;
                }
            }
          }
        }
      }

      while (visited[i]) {
        i++;
        if (i==n) {
            return true;
        }
      }
      i--;

  }
    return true;
  }


  public static String reverse(String str) {
    return str.equals("A") ? "B" : "A";
  }

  public static class Edge {
    public int node;
    public String str;

    public Edge(int node, int s) {
      this.node = node;
      str = s==-1 ? "d" : "s";
    }
    public String toString() {
      return "(" + node + ", " + str + ")";
    }
  }
}
