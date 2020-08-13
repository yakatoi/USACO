import java.util.*;
import java.io.*;

public class Lifeguards {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
    int[] arr = new int[1001];
    int n = Integer.parseInt(br.readLine());
    int[][] query = new int[n][2];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      query[i][0] = Integer.parseInt(st.nextToken());
      query[i][1] = Integer.parseInt(st.nextToken());
      for (int j = query[i][0]; j < query[i][1]; j++) {
        arr[j]++;
      }
    }
    int maxTime = 0;
    for (int i = 0; i < n; i++) {
      int[] change = arr.clone();
      for (int j = query[i][0]; j < query[i][1]; j++) {
        change[j]--;
      }
      int counter = 0;
      for (int x = 0; x < change.length; x++) {
        if (change[x]!=0) {
          counter++;
        }
      }
      maxTime = Math.max(maxTime, counter);
    }
    pw.println(maxTime);
    pw.close();
  }
}
