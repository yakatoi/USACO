import java.util.*;
import java.io.*;

public class Convention {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
    int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
    int n = inp[0];
    int m = inp[1];
    int c = inp[2];
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
    Arrays.sort(arr);
    Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
    int lo = 0;
    int hi = arr[n-1] - arr[0];

    int ans = 0;

    while(lo <= hi) {
      int mid = (lo + hi)/2 ;
      if(!check(arr, n, m, c, mid)){
        ans = mid;
        lo = mid+1;
      }
      else {
        hi = mid-1;
      }
    }
    System.out.println(ans+1);
    pw.close();
  }
  public static boolean check(int[] arr, int n, int m, int c, int wait) {
    boolean ans = true;
    for (int i = 0; i < n; i+=c) {
      if (i+c-1 < n) {
        if (arr[i+c-1] - arr[i] > wait) {
          ans = false;
        }
      }
      else {
        if (arr[n-1] - arr[i] > wait) {
          ans = false;
        }
      }
    }
    return ans;
  }
}
