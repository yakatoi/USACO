import java.util.*;
import java.io.*;

public class OutOfSorts {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("sort.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] sorted = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      sorted[i] =arr[i];
    }
    Arrays.sort(sorted);
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(sorted));
    int max = 0;
    for (int i = 0; i < n; i++) {
      int place = Arrays.binarySearch(sorted, arr[i]);
      max = Math.max(max, i-place);
    }
    System.out.println(max+1);
    pw.println(max+1);
    pw.close();
  }
}
