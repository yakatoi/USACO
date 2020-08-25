import java.util.*;
import java.io.*;

public class TheBucketList {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("blist.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[1001];
    for (int i = 0; i < n; i++) {
      int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      arr[inp[0]]-=inp[2];
      arr[inp[1]]+=inp[2];
    }
    int max = 0;
    int[] pre = new int[1001];
    pre[1] = arr[1];
    for (int i = 2; i <= 1000; i++) {
      pre[i] = pre[i-1] + arr[i];
    }
    for (int i = 1; i <= 1000; i++) {
      max = Math.max(Math.abs(pre[i]), max);
    }
    pw.println(max);
    pw.close();
  }
}
