import java.util.*;
import java.io.*;

public class CowCrossings {
  public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("crossings.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crossings.out")));
        int n = Integer.parseInt((in.readLine()));
        int[][] P = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] arr = in.readLine().split(" ");
            P[i][0] = Integer.parseInt(arr[0]);
            P[i][1] = Integer.parseInt(arr[1]);
        }
        Arrays.sort(P, new Comparator<int[]>() {
            public int compare(int[] A, int[] B) {
                return A[0]-B[0];
            }
        });

        int[] maxl = new int[n];
        maxl[0] = P[0][1];
        for(int i=1; i<n; i++)
            maxl[i] = Math.max(maxl[i-1], P[i][1]);

        int[] minr = new int[n];
        minr[n-1] = P[n-1][1];
        for(int i=n-2; i>=0; i--)
            minr[i] = Math.min(minr[i+1], P[i][1]);

        int safe = 0;
        for(int i=0; i<n; i++) {
            boolean ok = true;
            if(i!=0 && maxl[i-1] > P[i][1]) ok = false;
            if(i!=n-1 && minr[i+1] < P[i][1]) ok = false;
            if(ok) safe++;
        }
        out.println(safe);
        out.close();
    }
  public static class Point implements Comparable<Point> {
    public String t;
    public int a;
    public int d;

    public Point(String t, int a, int d) {
      this.t = t;
      this.a = a;
      this.d = d;
    }

    public String toString() {
      return "(" + d + ": " + t + "-" + a  + ")";
    }

    public int compareTo(Point p) {
      if (p.d==d) {
        return Integer.compare(a, p.a);
      }
      return Integer.compare(d, p.d);
    }
  }
}
