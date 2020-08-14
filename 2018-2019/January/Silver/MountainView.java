import java.util.*;
import java.io.*;

public class MountainView {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
    int n = Integer.parseInt(br.readLine());
    Pair[] arr = new Pair[n];
    for (int i = 0; i < n; i++) {
      String[] inps = br.readLine().split(" ");
      int a = Integer.parseInt(inps[0]);
      int b = Integer.parseInt(inps[1]);
      arr[i] = new Pair(a-b, a+b);
    }
    Arrays.sort(arr);
    int large = arr[0].y;
    int counter = 0;
    for (int i = 1; i < n; i++) {
      if (large >= arr[i].y) {
        counter++;
      }
      large = Math.max(large, arr[i].y);
    }
    pw.println(n-counter);
    pw.close();
  }

  public static class Pair implements Comparable<Pair>{
    public int x;
    public int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int compareTo(Pair p) {
      if (p.x==x) {
        return -1*Integer.compare(y, p.y);
      }
      return Integer.compare(x, p.x);
    }

  }

}
