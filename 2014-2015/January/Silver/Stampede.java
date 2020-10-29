import java.util.*;
import java.io.*;

public class Stampede {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("stampede.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("stampede.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n  = Integer.parseInt(st.nextToken());
    ArrayList<Event> al = new ArrayList<Event>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int x = (-1 - a) * c;
      int y = x + c;
      al.add(new Event(x, true, b));
      al.add(new Event(y, false, b));
    }
    Collections.sort(al);
    //System.out.println(al);
    HashSet<Integer> ans = new HashSet<Integer>();
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for (Event e : al) {
      if (pq.contains(e.pow)) {
        pq.remove(e.pow);
      }
      else {
        pq.add(e.pow);
      }
      if (!pq.isEmpty()) ans.add(pq.peek());
    }
    pw.println(ans.size());
    pw.close();

  }

  public static class Event implements Comparable<Event> {
    public int x;
    public boolean s;
    public int pow;

    public Event(int x, boolean s, int pow) {
      this.x = x;
      this.s = s;
      this.pow = pow;
    }
    public int compareTo(Event e) {
      if (x!=e.x) return Integer.compare(x, e.x);
      return pow > e.pow ? 1 : -1;
    }
    public String toString() {
      return "(" + x + ", " + s + ", " + pow + ")";
    }

  }
}
