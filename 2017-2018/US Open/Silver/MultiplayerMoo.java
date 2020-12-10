import java.util.*;
import java.io.*;

public class MultiplayerMoo {
  static int n;
  static int[][] arr;
  static boolean[][] visited;
  static HashMap<Node, HashSet<Node>> graph = new HashMap<Node, HashSet<Node>>();
  static HashSet<Node> nei = new HashSet<Node>();
  static int size;
  static void print() {for (int[] row: arr) {for (int ele: row) {System.out.print(ele + " ");}System.out.println();}}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("multimoo.out"));
    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(inp[j]);
      }
    }
    print();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          floodfill(i, j, arr[i][j]);
          Node node = new Node(arr[i][j], i*251+j, count);
          size = 0;
          map.put(node, new HashSet<Node>());
          for (Node n : nei) {
            map.get(node).add(n.id);
          }
        }
      }
      pw.println(Collections.max(graph.keySet()));
      pw.close();
    }
  }
  static void floodfill(int x, int y, int start) {
    if (isOut(x, y) || visited[x][y] || arr[x][y] != start) return;
    visited[x][y] = true;
    size++;
    if (!isOut(x+1, y)) {
      nei.add(new Node(arr[x+1][y], i*251+j));
      floodfill(x+1, y);
    }
    if (!isOut(x-1, y)) {
      nei.add(new Node(arr[x-1][y], i*251+j));
      floodfill(x-1, y);
    }
    if (!isOut(x, y+1)) {
      nei.add(new Node(arr[x][y+1], i*251+j));
      floodfill(x, y+1);
    }
    if (!isOut(x, y-1)) {
      nei.add(new Node(arr[x][y-1], i*251+j));
      floodfill(x, y-1);
    }

  }
  static boolean isOut(int x, int y) {
    return x < 0 || y < 0 || x>=n || y>=n;
  }
  static class Node {
    int id, count, size;
    public Node(int i, int c, int s) {
      id=i;
      count=c;
      size=s;
    }
    public Node(int i, int s) {
      count = -1;
      id = i;
      size = s;
    }
    public boolean equals(Node n) {
      return this.hashCode()==n.hashCode();
    }
    public int hashCode() {
      return Objects.hash(id, count);
    }
  }
}
