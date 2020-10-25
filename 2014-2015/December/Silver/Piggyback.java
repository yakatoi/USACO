import java.util.*;
import java.io.*;

public class Piggyback {
  public static HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
  public static int n;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("piggyback.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int b = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    int p = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) graph.put(i, new HashSet<Integer>());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken()) - 1;
      int two= Integer.parseInt(st.nextToken()) - 1;
      graph.get(one).add(two);
      graph.get(two).add(one);
    }
    System.out.println(graph);
    int[] zero = bfs(0);
    int[] one = bfs(1);
    System.out.println(Arrays.toString(zero));
    System.out.println(Arrays.toString(one));
    int minCost = Integer.MAX_VALUE;
    HashSet<Integer> indicies = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      minCost = Math.min(minCost, b * zero[i] + e * one[i]);
    }
    System.out.println(minCost);
    for (int i = 0; i < n; i++) {
      if (b * zero[i] + e * one[i] == minCost) {
        indicies.add(i);
      }
    }
    int smallestAns = Integer.MAX_VALUE;
    for (int i : indicies) {
      int cur = minCost;
      int[] temp = bfs(i);
      cur+= temp[n-1] * p;
      smallestAns = Math.min(smallestAns, cur);
    }
    int answithout = zero[n-1] * b + one[n-1] * e;
    smallestAns = Math.min(answithout, smallestAns);
    System.out.println(smallestAns);
    pw.close();
  }
  public static int[] bfs(int k) {
    int[] dist = new int[n];
    Arrays.fill(dist, -1);
    Queue<Integer> q = new LinkedList<Integer>();
    dist[k] = 0;
    q.add(k);
    while(!q.isEmpty()) {
      int v = q.poll();
      for(int e : graph.get(v)){
        if(dist[e] == -1){
          dist[e] = dist[v] + 1;
          q.add(e);
        }
      }
    }
    return dist;
  }
}
