`import java.util.*;
import java.io.*;

public class Tractor {
  static int n;
  static HashMap<Integer, Integer> keep = new HashMap<Integer, Integer>();
  static int[][] arr;
  static int[][] marks;
  static HashMap<Integer, Node> map = new HashMap<Integer, Node>();
  static int glob = 1;
  static boolean[][] visited;
  static HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
  static int lim = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("tractor.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("tractor.out"));
    n = Integer.parseInt(br.readLine());
    lim = (n*n+1)/2;
    arr= new int[n][n];
    marks= new int[n][n];
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
      for (int j = 0; j < n; j++) {
        if (!keep.keySet().contains(inp[j])) keep.put(inp[j], 1);
        arr[i][j] = inp[j];
      }
    }
    for (int[] row : arr) System.out.println(Arrays.toString(row));
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          Node node = new Node(arr[i][j], keep.get(arr[i][j]), 0);
          keep.put(arr[i][j], keep.get(arr[i][j]) + 1);
          node = dfs(i, j, node, arr[i][j]);
          map.put(glob, node);
          glob++;
        }
      }
    }
    for (int[] row : marks) System.out.println(Arrays.toString(row));
    for (int i = 1; i < glob; i++) {
      graph.put(i, new HashSet<Integer>());
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        HashSet<Integer> nei = getNeighbors(i, j);
        for (int ele : nei) graph.get(marks[i][j]).add(ele);
      }
    }
    System.out.println(graph);
    int a = 0, b = 1000000;
    while (a != b) {
      int mid = (a+b)/2;
      if (works(mid)) {
        b = mid;
      }
      else {
        a = mid+1;
      }
    }
    System.out.println(a);
    pw.println(a);
    pw.close();
  }
  public static int[] parent;
  public static void initialize(int n) {
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }
  public static int find(int x) {
    if (x==parent[x]) {
      return x;
    }
    else {
      parent[x] = find(parent[x]);
      return parent[x];
    }
  }
  public static void union(int a, int b) {
    int c = find(a);
    int d = find(b);
    if (c < d) {
      parent[d] = c;
    }
    if (d < c) {
      parent[c] = d;
    }
  }
  static boolean works(int x) {
    for (int i = 1; i < Math.max(2, glob/10); i++) {
      int count = map.get(i).s;
      boolean[] visited = new boolean[glob+1];
      visited[i] = true;
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(i);
      while (!q.isEmpty()) {
        int v = q.poll();
        for (int e : graph.get(v)) {
          if (!visited[e] && Math.abs(map.get(v).h - map.get(e).h) <= x) {
            visited[e] = true;
            count+=map.get(e).s;
            if (count >= lim) return true;
            q.add(e);
          }
        }
      }
      if (count >= lim) return true;
    }
    return false;
  }
  static boolean worksDSU(int x) {
    initialize(glob);
    for (int i = 1; i < glob; i++) {
      for (int j = i + 1; j< glob; j++) {
        if (graph.get(i).contains(j) && Math.abs(map.get(i).h - map.get(j).h) <= x) {
          union(i, j);
        }
      }
    }
    HashMap<Integer, Integer> multiset = new HashMap<Integer, Integer>();
    for (int i = 1; i < glob; i++) {
      int ch = find(i);
      if (multiset.keySet().contains(ch)) {
        multiset.put(ch, multiset.get(ch) + map.get(i).s);
      }
      else {
        multiset.put(ch, map.get(i).s);
      }
    }
    int max = Collections.max(multiset.values());
    return max >= lim;
  }
  static HashSet<Integer> getNeighbors(int x, int y) {
    HashSet<Integer> set = new HashSet<Integer>();
    set.add(marks[x][y]);
    if (checkBounds(x+1, y)) set.add(marks[x+1][y]);
    if (checkBounds(x-1, y)) set.add(marks[x-1][y]);
    if (checkBounds(x, y-1)) set.add(marks[x][y-1]);
    if (checkBounds(x, y+1)) set.add(marks[x][y+1]);
    set.remove(marks[x][y]);
    return set;
  }
  static boolean checkBounds(int x, int y) {
    return x >= 0 && y >= 0 && x < n && y < n;
  }
  static Node dfs(int x, int y, Node node, int color) {
    if (x <0 || y < 0 || x>= n|| y>= n|| visited[x][y] || arr[x][y] != color) return node;
    node.s++;
    marks[x][y] = glob;
    visited[x][y] = true;
    dfs(x+1, y, node, color);
    dfs(x-1, y, node, color);
    dfs(x, y+1, node, color);
    dfs(x, y-1, node, color);
    return node;
  }
  static class Node {
    int h, c, s;
    public Node(int hh, int cc, int ss) {h=hh; c=cc; s=ss;}
    public String toString() {return h + " " + c + " " + s;}
  }
}
