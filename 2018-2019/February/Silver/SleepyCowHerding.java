import java.util.*;
import java.io.*;

public class SleepyCowHerding {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
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
      if (ind > i) {
        curSum = cursum%2==0 ? ind : i;
      }
      System.out.println(ind);
      int curSum = n -(ind-i);
      min = Math.min(curSum, min);
    }
    System.out.println(min);


  }
}
