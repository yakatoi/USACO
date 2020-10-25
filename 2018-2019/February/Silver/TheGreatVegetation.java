import java.util.*;
import java.io.*;

public class TheGreatVegetation {
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
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    initialize(n);
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      st.nextToken();
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      union(a, b);
    }
    //System.out.println(Arrays.toString(parent));
    HashSet<Integer> set = new HashSet<Integer>();
    for (int child : parent) {
      set.add(child);
    }
    int counter = set.size();
    pw.print(1);
    for (int i = 1; i<= counter; i++) {
      pw.print(0);
    }
    pw.println();
    pw.close();
  }

}
