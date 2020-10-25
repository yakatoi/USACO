import java.util.*;
import java.io.*;

public class SocialDistancingII {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("socdist2.out"));
    int n = Integer.parseInt(br.readLine());
    Cow[] arr = new Cow[n];
    for (int i = 0; i< n; i++) {
      arr[i] = new Cow(br.readLine().split(" "));
    }
    System.out.println(Arrays.toString(arr));
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    int min = Integer.MAX_VALUE;
    if (!is(arr[0]) && is(arr[1])) {
      min = arr[1].x - arr[0].x;
    }

    if (is(arr[n-1]) && is(arr[n-2])) {
      min = Math.min(arr[n-1].x - arr[n-2].x, min);
    }
    for (int i = 1; i < n-1; i++) {
      if (middle(arr[i-1], arr[i], arr[i+1])) {
        min = Math.min(min, arr[i].x - arr[i-1].x);
        min = Math.min(min, arr[i+1].x - arr[i].x);
      }
    }
    min--;
    System.out.println(min);
    int counter = 1;



  }
  public static boolean is(Cow c) {return c.y==1;}
  public static boolean middle(Cow a, Cow b, Cow c) {
    return (is(a)) && (!is(b)) && (is(c));
  }
  public static class Cow implements Comparable<Cow> {
    public int x;
    public int y;
    public Cow(String[] str) {
      x = Integer.parseInt(str[0]);
      y = Integer.parseInt(str[1]);
    }
    public int compareTo(Cow c) {
      return Integer.compare(x, c.x);
    }
    public String toString() {
      return "(" + x + ", " + y + ")";
    }
  }
}
