import java.util.*;
import java.io.*;

public class GoldilocksAndTheNCows {
  static int n, x, y, z;
  static TreeMap<Integer, Integer> map   = new TreeMap<Integer, Integer>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("milktemp.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("milktemp.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    z = Integer.parseInt(st.nextToken());
    ArrayList<Event> al = new ArrayList<Event>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      al.add(new Event(a, -1));
      al.add(new Event(b, 1));
    }
    Collections.sort(al);
    //System.out.println(al);
    int sum = n*x;
    int maxSum = n*x;
    for (Event e : al) {
      if (e.dir==-1) {
        sum+=y-x;
      }
      else {
        sum+= z-y;
      }
      maxSum = Math.max(sum, maxSum);
    }
    pw.println(maxSum);
    pw.close();
  }
  static class Event implements Comparable<Event> {
    int x, dir;
    public Event(int xx, int dirr) {
      x = xx;
      dir = dirr;
    }
    public int compareTo(Event e) {
      if (e.x==x) return Integer.compare(dir, e.dir);
      return Integer.compare(x, e.x);
    }
    public String toString() {
      return x + " " + dir;
    }
  }
}
