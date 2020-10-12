import java.util.*;
import java.io.*;

public class Blink {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("blink.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("blink.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    //  System.out.print(arr[i] + " ");
    }
    //System.out.println();
    b = b%3072L;
    for (int j = 0; j < (int) b; j++) {
      int[] prev = new int[n];
      prev[0] = arr[n-1] == 1 ? 1 - arr[0] : arr[0];
      for (int i = 1; i < n; i++) {
        prev[i] = arr[i-1]==1 ? 1- arr[i] : arr[i];
      }
      for (int i = 0; i < n; i++) {
        //System.out.print(prev[i] + " ");
        arr[i] = prev[i];
      }
      //System.out.println();
    }
    for (int i = 0; i < arr.length; i++) {
      pw.println(arr[i]);
    }
    pw.close();
  }
}
