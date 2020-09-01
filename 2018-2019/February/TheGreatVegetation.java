import java.util.*;
import java.io.*;

public class TheGreatVegetation {

  public static HashMap<Integer, ArrayList<Pair>> graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
    String[] inp = br.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    int m = Integer.parseInt(inp[1]);
    graph = new HashMap();
    for (int i = 1; i <= n; i++) {
      graph.put(i, new ArrayList<Pair>(Collections.singleton(new Pair(-1, "-1"))));
    }
    for (int i = 0; i < m; i++) {
      String[] inp1 = br.readLine().split(" ");
      graph.get(Integer.parseInt(inp1[1])).add(new Pair(Integer.parseInt(inp1[2]), inp1[0]));
    }
  }
  public static class Pair {
    int n;
    String s;

    public Pair(int n, String s) {
      this.n = n;
      this.s = s;
    }

    public Pair(Pair p) {
      n = p.n;
      s = p.s;
    }

    public String toString() {
      return "(" + n + ", " + s + ")";
    }


  }
}
