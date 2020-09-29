import java.util.*;
import java.io.*;

public class ConventionII {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("convention2.out"));
    int n = Integer.parseInt(br.readLine());
    Cow[] arr = new Cow[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      arr[i] = new Cow(i + 1, a, t);
    }
    Arrays.sort(arr, (a, b) -> (a.a - b.a));
    for (Cow c : arr) {
      //System.out.println(c);
    }
    PriorityQueue<Cow> pq = new PriorityQueue<Cow>();
    int maxWait = 0;
    int time = 0;
    int i = 0;
    int curt = 0;
    while (i < n) {
      if (pq.isEmpty()) {
        if (arr[i].a >= time) {
          time = arr[i].a + arr[i].t;
          curt = time;
        }
        else {
          pq.add(arr[i]);
        }
      }
      else {
        if (arr[i].a < time) {
          pq.add(arr[i]);
        }
        else if (arr[i].a ==time) {
            pq.add(arr[i]);
          while (!pq.isEmpty()) {
            Cow c = pq.poll();
            maxWait = Math.max(maxWait, time - c.a);
            time+=c.t;
          }
        }
        else {
          while (!pq.isEmpty()) {
            Cow c = pq.poll();
            maxWait = Math.max(maxWait, time - c.a);
            time+=c.t;
          }
          if (arr[i].a < time) {
            pq.add(arr[i]);
          }
          else {
            time = arr[i].a + arr[i].t;
          }
        }
      }
      i++;
    }
    pw.println(maxWait);
    pw.close();
  }
  public static class Cow implements Comparable<Cow> {
    public int p;
    public int a;
    public int t;

    public Cow(int p, int a, int t) {
      this.p = p;
      this.a = a;
      this.t = t;
    }

    public Cow(Cow cow) {
      p = cow.p;
      a = cow.a;
      t = cow.t;
    }

    public int compareTo(Cow cow) {
      return p - cow.p;
    }
    public String toString() {
      return "(" + p + ", " + a + ", " + t + ")";
    }
  }
}
