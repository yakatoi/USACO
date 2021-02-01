import java.util.*;
import java.io.*;

public class Moocast {
  static int n;
  static HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
  static HashMap<Integer, Cow> points = new HashMap<Integer, Cow>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("moocast.out"));
    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      points.put(i, new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
      graph.put(i, new HashSet<Integer>());
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i!=j) {
          if (points.get(i).works(points.get(j))) {
            graph.get(i).add(j);
          }
        }
      }
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, countCow(i));
    }
    pw.println(max);
    pw.close();
  }
  public static int countCow(int i) {
    boolean[] visited = new boolean[n];
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(i);
    while (!q.isEmpty()) {
      int node= q.poll();
      visited[node] = true;
      for (int e : graph.get(node)) {
        if (!visited[e]) q.add(e);
      }
    }
    int counter = 0;
    for (boolean bool : visited) {
      if (bool) counter++;
    }
    return counter;
  }
  public static class Cow {
    int x, y, pow;
    public Cow(int a,int b, int c) {
      x=a;
      y=b;
      pow=c;
    }
    public String toString() {
      return "(" + x + ", " + y +  ", " + pow + ")";
    }
    public boolean works(Cow c) {
      return pow*pow >= (y-c.y)*(y-c.y) + (x-c.x)*(x-c.x);
    }
  }
}
