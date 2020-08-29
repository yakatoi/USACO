import java.util.*;
import java.io.*;

public class WhyDidTheCowCrossTheRoadII {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
    int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int n = inp[0];
    int k = inp[1];
    int b = inp[2];
    int[] arr = Arrays.stream(new int[n]).map(x -> 1).toArray().clone();
    for (int i = 0; i < b; i++) {
      int rem = Integer.parseInt(br.readLine())-1;
      arr[rem] = 0;
    }
    int[] pre = new int[n];
    pre[0] = arr[0];
    for (int i = 1; i < n; i++) {
      pre[i] = pre[i-1] + arr[i];
    }
    int largestSum = 0;
    for (int i = 0; i <= n-k; i++) {
      int sum = i==0 ? pre[k-1] : pre[k-1+i] - pre[i-1];
      largestSum = Math.max(largestSum, sum);
    }
    pw.println(k-largestSum);
    pw.close();
  }
}
