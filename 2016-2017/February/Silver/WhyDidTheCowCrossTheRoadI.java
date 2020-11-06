import java.util.*;
import java.io.*;

public class WhyDidTheCowCrossTheRoadI {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("helpcross.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int c = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    Range[] ranges = new Range[n];
    int[] arr = new int[c];
    for (int i = 0; i < c; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      ranges[i] = new Range(a, b);
    }
    Arrays.sort(ranges);
    Arrays.sort(arr);
    //System.out.println(Arrays.toString(ranges));
    int i = 0;
    int j = 0;
    int counter = 0;
    while (i < n && j < c) {
      if (ranges[j].within(arr[i])==0) {
        counter++;
        i++;
        j++;
      }
      else if (ranges[i].within(arr[j]) == 1) {
        j++;
      }
      else {
        i++;
      }
    }
    System.out.println(counter);
    pw.close();
  }
  public static class Range implements Comparable<Range> {
    public int a;
    public int b;

    public Range(int x, int y) {
      a=x;
      b=y;
    }
    public int within(int x) {
      if (x >= a && x <= b) return 0;
      if (x > b) return 1;
      return -1;
    }
    public String toString() {
      return "(" + a+ ", " + b+ ")";
    }
    public int compareTo(Range r) {
      if (b==r.b) return Integer.compare(a, r.a);
      return Integer.compare(b, r.b);
    }
  }
}
