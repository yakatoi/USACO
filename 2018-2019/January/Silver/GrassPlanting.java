import java.util.*;
import java.io.*;

public class GrassPlanting {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("planting.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("planting.out"));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int max = 0;
    for (int i = 0; i < n-1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      max = Math.max(max, ++arr[a]);
      max = Math.max(max, ++arr[b]);
    }
    pw.println(max+1);
    pw.close();
  }
}
