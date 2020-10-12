import java.util.*;
import java.io.*;

public class WhyDidTheCowCrossTheRoadI {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int c = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int[] chickens = new int[c];
    for (int i = 0; i < c; i++) {
      chickens[i] = Integer.parseInt(br.readLine());
    }
    Range[] cows = new Range[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      cows[i] = new Range(a, b);
    }
    Arrays.sort(chickens);
    Arrays.sort(cows);
    int counter = 0;
    int i = 0;
    int j = 0;
    while (i < c && j < n) {
      if (cows[j].contains(chickens[i])) {
        counter++;
        i++;
        j++;
      }
      else if (chickens[i] < cows[j].a) {
        i++;
      }
      else {
        j++;
      }
    }
    pw.println(counter);
    pw.close();

  }
  public static class Range implements Comparable<Range> {
    public int a;
    public int b;

    public Range(int a, int b) {
      this.a = a;
      this.b = b;
    }

    public int compareTo(Range r) {
      return b - r.b;
    }

    public boolean contains(int ch) {
      return ch >= a && ch <= b;
    }
  }
}
