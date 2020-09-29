import java.util.*;
import java.io.*;

public class TheGreatVegetation {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<Integer>(Collections.singleton(-1)));
    }
    while (m > 0) {
      m--;
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    for (int i = 0; i < n; i++) {
      graph.get(i).remove(Integer.valueOf(-1));
      Collections.sort(graph.get(i));
    }
    int[] grass = new int[n];
    grass[0] = 1;
    for (int i = 1; i  < n; i++) {
      TreeSet<Integer> set = new TreeSet<Integer>();
      set.add(1); set.add(2); set.add(3); set.add(4);
      for (int node : graph.get(i)) {
        set.remove(grass[node]);
      }
      grass[i] = set.first();
    }
    //System.out.println(graph);
    //System.out.println(Arrays.toString(grass));
    for (int g : grass) {
      pw.print(g);
    }
    pw.println();
    pw.close();
  }

}
