import java.util.*;
import java.io.*;

public class SleepyCowHerding {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("herding.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int ind = Arrays.binarySearch(arr, arr[i] + n);
      if (ind<0) ind=ind*-1-2;
      int curSum = n -(ind-i);
      min = Math.min(curSum, min);
    }
    int max = n - min;
    pw.println(min);
    pw.println(max);
    pw.close();
  }
}
