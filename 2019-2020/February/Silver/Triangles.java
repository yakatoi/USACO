import java.util.*;
import java.io.*;

public class Triangles {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("triangles.out"));
    int n = Integer.parseInt(br.readLine());
    ArrayList<Pair> inp = new ArrayList<Pair>();
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      inp.add(new Pair(x, y));
    }
    Collections.sort(inp);
    //System.out.println(inp);
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    HashMap<Integer, ArrayList<Integer>> ys = new HashMap<Integer, ArrayList<Integer>>();
    for (Pair p : inp) {
      if (!map.keySet().contains(p.y)) map.put(p.y, new ArrayList<Integer>());
      map.get(p.y).add(p.x);
      if (!ys.keySet().contains(p.x)) ys.put(p.x, new ArrayList<Integer>());
      ys.get(p.x).add(p.y);
    }
    for (int key : map.keySet()) Collections.sort(map.get(key));
    for (int key : ys.keySet()) Collections.sort(ys.get(key));
    // System.out.println(map);
    // System.out.println(ys);
    long areaSum = 0;
    for (int key : map.keySet()) {
      for (int i = 0; i < map.get(key).size(); i++) {
        for (int j = i+1; j < map.get(key).size(); j++) {
          int min = map.get(key).get(i);
          int max = map.get(key).get(j);
          int width = max - min;
          int height = 0;
          if (ys.get(min).get(0) < key) height +=ys.get(min).get(0);
          if (ys.get(min).get(ys.get(min).size()-1) > key) height +=ys.get(min).get(ys.get(min).size()-1);
          if (ys.get(max).get(0) < key) height += ys.get(max).get(0);
          if (ys.get(max).get(ys.get(max).size()-1) > key) height += ys.get(max).get(ys.get(max).size()-1);
          areaSum+=(width * height)*1L;
          areaSum%=10L*10*10*10*10*10*10*10*10+7;
        }
      }
    }
    pw.println(areaSum);
    pw.close();

  }
  public static int max(int a, int b, int c, int d) {
    return Math.max(Math.max(a, b), Math.max(c, d));
  }
  public static class Pair implements Comparable<Pair> {
    public int x;
    public int y;
    public Pair(int a, int b) {
      x= a;
      y=b;
    }
    public int compareTo(Pair p) {
      if (y==p.y) {
        return Integer.compare(x, p.x);
      }
      return Integer.compare(y, p.y);
    }

    public String toString() {
      return "(" + x + ", " + y +")";
    }
  }
}
