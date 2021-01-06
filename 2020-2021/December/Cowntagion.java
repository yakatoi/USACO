import java.util.*;
import java.io.*;

public class Cowntagion {
  public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    Arrays.fill(arr, -1);
    arr[0]++;
    for (int i = 1; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      arr[a]++;
      arr[b]++;
    }
    // System.out.println(Arrays.toString(arr));
    int days = 0;
    for (int i = 0; i < n; i++) {
      days+=log2(arr[i]);
    }
    days+=n-1;
    System.out.println(days);

  }
  public static int log2(int x) {
    if (x==0) return 0;
    return (int) (Math.log(x)/Math.log(2) + 1);
  }
}
