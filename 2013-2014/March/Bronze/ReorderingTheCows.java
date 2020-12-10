import java.util.*;
import java.io.*;

public class ReorderingTheCows {
  static int n;
  static HashMap<Integer, Integer> graph = new HashMap<Integer, Integer>();
  static int[] group;
  static int counter =1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("reorder.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("reorder.out"));
    int n = Integer.parseInt(br.readLine());
    group = new int[n+1];
    HashMap<Integer, Integer> amap = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> bmap = new HashMap<Integer, Integer>();
    for (int i = 1; i <= n; i++) {
      int inp = Integer.parseInt(br.readLine());
      amap.put(inp, i);
    }
    for (int i = 1; i <= n; i++) {
      int inp = Integer.parseInt(br.readLine());
      bmap.put(inp, i);
    }
    for (int i = 1; i <= n; i++) {
      graph.put(amap.get(i), bmap.get(i));
    }
    System.out.println(graph);
    for (int i = 1; i <= n; i++) {
      if (group[i]==0 && graph.get(i)!=i) {
        bfs(i, counter);
        counter++;
      }
    }
    int[] arr = new int[n+1];
    for (int ele : group) {
      arr[ele]++;
    }
    int max = 0;
    for (int ele : arr) {
      max=Math.max(ele, max);
    }
    counter--;
    pw.println(counter + " " + max);
    pw.close();

  }
  public static void bfs(int i, int color) {
    while (group[i]==0) {
      group[i] = color;
      i = graph.get(i);
    }
  }
}
