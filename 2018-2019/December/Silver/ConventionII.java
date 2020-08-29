import java.util.*;
import java.io.*;

public class ConventionII {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention2")));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][3];
    for (int i = 0; i < n; i++) {
      int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
      arr[i][0] = i+1;
      arr[i][1] = inp[0];
      arr[i][2] = inp[1];
    }
    Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
    for (int i = 0; i < n; i++) {
      System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
    }

  }
}
