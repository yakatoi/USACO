import java.util.*;
import java.io.*;

public class DiamondCollector {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
    String[] inp = br.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    int k = Integer.parseInt(inp[1]);
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    int max = 0;
    for (int i = 0; i < n; i++) {
      int counter = 1;
      for (int j = i+1; j < n; j++) {
        if (arr[j]-arr[i]<=k) {
          counter++;
        }
      }
      max = Math.max(max, counter);
    }
    pw.println(max);
    pw.close();
  }
}
