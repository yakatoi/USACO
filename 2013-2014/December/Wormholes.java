import java.util.*;
import java.io.*;

public class Wormholes {
  static int n;
  static int counter = 0;
  static int count;
  static int[] arr;
  static int num = 1;
  static boolean[] looped;
  static int[][] map;
  static TreeMap<Integer, ArrayList<Integer>> points = new TreeMap<Integer, ArrayList<Integer>>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("wormhole.out"));
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    map = new int[n][2];
    looped = new boolean[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      map[i][0] = a;
      map[i][1] = b;
      if (!points.keySet().contains(b)) points.put(b, new ArrayList<Integer>());
      points.get(b).add(a);
    }
    for (int key: points.keySet()) Collections.sort(points.get(key));
    recurse();
    // System.out.println(counter);
    // System.out.println(points);
    System.out.println(count);
    pw.println(count);
    pw.close();
  }
  static void process() {
    int[] pairs = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
        if (i != j && arr[i] == arr[j]) {
          pairs[i] = j;
          pairs[j] = i;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      if (loop(i, pairs, new boolean[n])) {
        count++;
        return;
      }
    }

  }
  static boolean loop(int ind, int[] pairs, boolean[] visited) {
    if (visited[ind]) return looped[ind] = true;
    visited[ind] = true;
    int xx = map[ind][0];
    int yy = map[ind][1];
    ArrayList<Integer> al = points.get(yy);
    if (xx == al.get(al.size() - 1)) {
      return false;
    }
    int nextX = 0;
    for (int i = 0; i < al.size(); i++) {
      if (al.get(i) == xx) {
        nextX = al.get(i+1);
        break;
      }
    }
    int newI = 0;
    for (int i = 0; i < n; i++) {
      if (map[i][0] == nextX && map[i][1] == yy) {
        newI = i;
        break;
      }
    }
    return loop(pairs[newI], pairs, visited);
  }
  static void recurse() {
    if (check()) {
      counter++;
      process();
      return;
    }
    ArrayList<Integer> zeroes = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        zeroes.add(i);
      }
    }
    int first = zeroes.remove(0);
    arr[first] = num;
    for (int ele : zeroes) {
      arr[ele] = num;
      num++;
      int[] old = arr.clone();
      recurse();
      arr = old.clone();
      num--;
      arr[ele] = 0;
    }
  }
  static boolean check() {
    for (int ele : arr) {
      if (ele ==0 ) return false;
    }
    return true;
  }
}
