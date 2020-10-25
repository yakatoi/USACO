import java.util.*;
import java.io.*;

public class DSU {
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
    initialize(5);
    union(0, 1);
    union(1, 2);
    union(3, 4);
    System.out.println(Arrays.toString(parent));
  }
}
