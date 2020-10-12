import java.util.*;
import java.io.*;

public class Photo {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("photo.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("photo.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    Pair[] arr = new Pair[k];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[i] = new Pair(a, b);
    }
    int x = 1;
    int y = n;
    int counter = 0;
    while (x <= n) {
      counter++;
      for (Pair p : arr) {
        if (p.a > x && p.b < y) {
          y = p.b-1;
        }
      }
      x = y+1;
      y = n;
    }
    pw.println(counter);
    pw.close();

  }
  public static class Pair {
    public int a;
    public int b;

    public Pair(int c, int d) {
      if (c < d) {
        a = c;
        b = d;
      }
      else {
        a = d;
        b = c;
      }
    }
  }
}
