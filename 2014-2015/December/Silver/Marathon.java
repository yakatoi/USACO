import java.util.*;
import java.io.*;

public class Marathon {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("marathon.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("marathon.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    ArrayList<Point> al = new ArrayList<Point>();
    for (int i = 0; i < n; i++) al.add(new Point(br.readLine()));
    //System.out.println(al);
    for (int i = 0; i < k; i++) {
      int index = getIndex(al);
      al.remove(index);
    }
    //System.out.println(al);
    int dist = 0;
    for (int i = 0; i < al.size() - 1; i++) {
      dist += al.get(i).dif(al.get(i+1));
    }
    pw.println(dist);
    pw.close();
  }
  public static class Point {
    public int x;
    public int y;

    public Point(String str) {
      StringTokenizer s = new StringTokenizer(str);
      x = Integer.parseInt(s.nextToken());
      y = Integer.parseInt(s.nextToken());
    }
    public int dif(Point p) {
      return Math.abs(x - p.x) + Math.abs(y - p.y);
    }
    public String toString() {
      return "(" + x + ", " + y + ")";
    }
  }
  public static int getIndex(ArrayList<Point> al) {
    int[] arr = new int[al.size()];
    for (int i = 1; i < arr.length - 1; i++) {
      arr[i] = al.get(i).dif(al.get(i-1)) + al.get(i).dif(al.get(i+1));
    }
    int index = 0;
    int max = 0;
    for (int i = 1; i < arr.length -1; i++) {
      if (arr[i] > max) {
        index = i;
        max = arr[i];
      }
      i
    }
    return index;
  }

}
