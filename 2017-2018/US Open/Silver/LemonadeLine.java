import java.util.*;
import java.io.*;

public class LemonadeLine {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = -1 * Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    for (int i = 0; i < n; i++) {
      arr[i]*=-1;
    }
    int counter = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] >= counter) {
        counter++;
      }
      else {
        break;
      }
    }
    pw.println(counter);
    pw.close();
  }
}
