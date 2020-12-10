import java.util.*;
import java.io.*;

public class MountainView {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("mountains.out"));
    int n  = Integer.parseInt(br.readLine());
    Mountain[] arr = new Mountain[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[i] = new Mountain(a, b);
    }
    Arrays.sort(arr);
    //System.out.println(Arrays.toString(arr));
    int largest = Integer.MIN_VALUE;
    int counter = 0;
    for (Mountain m : arr) {
      if (m.b > largest) counter++;
      largest = Math.max(largest, m.b);
    }
    pw.println(counter);
    pw.close();
  }
  static class Mountain implements Comparable<Mountain> {
    int a, b, x, y;
    public Mountain(int xx, int yy) {
      x = xx;
      y = yy;
      a = x - y;
      b = x+y;
    }
    public int compareTo(Mountain m) {
      if (a==m.a) return Integer.compare(y, m.y);
      return Integer.compare(a, m.a);
    }
  }
}
