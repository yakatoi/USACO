import java.util.*;
import java.io.*;

public class DSU {
  public static ArrayList<Integer> parent = new ArrayList<Integer>();

  public static void initialize(int n) {
    for (int i = 0; i < n; i++) {
      parent.add(i);
    }
  }

  public static int find(int x) {
    if (x==parent.get(x)) {
      return x;
    }
    else {
      parent.set(x, find(parent.get(x)));
      return parent.get(x);
    }
  }
  public static void union(int a, int b) {
    int c = find(a);
    int d = find(b);
    if (c < d) {
      parent.set(d, c);
    }
    if (d < c) {
      parent.set(c, d);
    }
  }

  public static void main(String[] args) throws IOException {
    initialize(5);
    union(0, 1);
    union(1, 2);
    union(1, 3);
    union(0, 4);
    System.out.println(parent);
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < 4; i++) {
        set.add(find(i));
    }
    System.out.println(set);

  }
}
