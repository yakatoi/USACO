import java.util.*;
import java.io.*;

public class SleepyCowSorting {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int counter = 1;
    for (int i = n-2; i >= 0; i--) {
      int bef = counter;
      counter = arr[i+1] > arr[i] ? counter + 1: counter;
      if (bef==counter) {
        break;
      }
    }
    pw.println(n-counter);
    pw.close();
  }
}
