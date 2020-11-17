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

  }
}
