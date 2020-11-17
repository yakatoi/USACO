import java.util.*;
import java.io.*;

public class SkiCourseDesign {
  public static int n;
  public static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("skidesign.out"));
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    int min = Integer.MAX_VALUE;
    for (int i = arr[0]; i <= arr[n-1]-17; i++) {
      min = Math.min(min, count(i, i+17));
    }
    pw.println(min);
    pw.close();
  }
  public static int count(int a, int b) {
    int cost = 0;
    for (int element : arr) {
      if (element < a) {
        cost+= (a-element)*(a-element);
      }
      if (element > b) {
        cost+= (element-b)*(element-b);
      }
    }
    return cost;
  }
}
