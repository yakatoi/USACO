import java.util.*;
import java.io.*;

public class OutOfPlace {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    int[] sorted = arr.clone();
    Arrays.sort(sorted);
    int counter = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i]!=sorted[i]) {
        counter++;
      }
    }
    if (counter!=0) {
      counter--;
    }
    pw.println(counter);
    pw.close();
  }
}
