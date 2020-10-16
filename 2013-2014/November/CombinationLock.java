import java.util.*;
import java.io.*;

public class CombinationLock {
  public static int i(String str) {return Integer.parseInt(str);}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("combo.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("combo.out"));

    int n = i(br.readLine());
    int[] john = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> i(x)).toArray();
    int[] master = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> i(x)).toArray();
    int counter = 0;
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b <= n; b++) {
        for (int c = 1; c <= n; c++) {
          if (isTwo(a, b, c, john, n) || isTwo(a, b, c, master, n)) {
            counter++;
          }
        }
      }
    }
    pw.println(counter);
    pw.close();
  }
  public static boolean isTwo(int a, int b, int c, int[] arr, int n) {
    return abs(a, arr[0], n) && abs(b, arr[1], n) && abs(c, arr[2], n);
  }
  public static boolean abs(int a, int b, int n) {
    if (a > b) {
      int temp = a;
      a = b;
      b = temp;
    }
    if (b==n && (a==1 || a==2)) {
      return true;
    }
    if (b==n-1 && a==1) {
      return true;
    }
    return Math.abs(b-a) <= 2;
  }
}
