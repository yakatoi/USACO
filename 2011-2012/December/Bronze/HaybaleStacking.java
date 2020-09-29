import java.util.*;
import java.io.*;

public class HaybaleStacking {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("stacking.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] beg = new int[n+1];
    int[] arr = new int[n+1];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      beg[a-1]--;
      beg[b]++;
    }
    arr[n] = beg[n];
    for (int i = n-1; i >= 0; i--) {
      arr[i] = arr[i+1] + beg[i];
    }
    Arrays.sort(arr);
    System.out.println(arr[(n+1)/2]);
  }
}
