import java.util.*;
import java.io.*;

public class WhyDidTheCowCrossTheRoadII {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("maxcross.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] arr = new int[n+1];
    Arrays.fill(arr, 1);
    arr[0] = 0;
    for (int i = 0; i < k; i++) {
      int inp = Integer.parseInt(br.readLine());
      arr[inp] = 0;
    }
    for (int i = 1; i <= n; i++) {
      arr[i]+=arr[i-1];
    }
    //System.out.println(Arrays.toString(arr));
    int i = 1;
    int j = b;
    int max = -1;
    while (j <= n) {
      if (j-i!=b-1) {
        i++;
      }
      else {
        int dif = arr[j]-arr[i-1];
        max = Math.max(max, dif);
        j++;
      }
    }
    pw.println(b-max);
    pw.close();
  }
}
