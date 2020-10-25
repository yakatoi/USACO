import java.util.*;
import java.io.*;

public class CowBaseball {
  public static int[] arr;
  public static int n;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("baseball.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("baseball.out"));
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    //System.out.println(Arrays.toString(arr));
    //int in = binSearch(0);
    //System.out.println(in);
    int counter = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int x = arr[j] - arr[i];
        int a = x + arr[j];
        int b = 2*x + arr[j];
        //System.out.println(arr[i] + " " + arr[j] + " " + a + " " + b);
        int one = binSearch(a);
        int two = binSearch(b+1);
        counter += two-one;
      }
    }
    pw.println(counter);
    pw.close();
  }
  public static int binSearch(int ele) {
    int lo = 1;
    int hi = n;
    int mid = 0;
    while (lo < hi) {
      mid = (lo + hi)/2;
      if (arr[mid] < ele) {
        lo = mid +1;
      }
      else {
        hi = mid;
      }
    }
    return lo;
  }
}
