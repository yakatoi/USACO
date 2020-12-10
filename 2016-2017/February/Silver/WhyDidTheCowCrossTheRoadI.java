import java.util.*;
import java.io.*;

public class WhyDidTheCowCrossTheRoadI {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("helpcross.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int c = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int[] chickens = new int[c];
    for (int i = 0; i < c; i++) {
      chickens[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(chickens);
    Cow[] arr = new Cow[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[i] = new Cow(a, b);
    }
    Arrays.sort(arr);
    int i =0;
    int j=0;
    int counter = 0;
    while (i < c && j < n) {
      if (arr[j].x <= chickens[i] && chickens[i] <= arr[j].y) {
        counter++;
        i++;
        j++;
      }
      else if (arr[j].x > chickens[i]) {
        i++;
      }
      else {
        j++;
      }
    }
    pw.println(counter);
    pw.close();
  }
  public static class Cow implements Comparable<Cow> {
    int x, y;
    public Cow(int a, int b) {
      x=a;
      y=b;
    }
    public int compareTo(Cow c) {
      if (x==c.x) return Integer.compare(y, c.y);
      return Integer.compare(x, c.x);
    }
  }
}
