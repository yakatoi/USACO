import java.util.*;
import java.io.*;

public class TheLazyCow {
  public static void main(String[] args) throws IOException {
    BufferedReader br =new BufferedReader(new FileReader("lazy.in"));
    PrintWriter pw= new PrintWriter(new FileWriter("lazy.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n+1][2];
    int[] elements = new int[n+1];

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      int g = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      arr[i][0] = g;
      arr[i][1] = x;
      elements[i] = x;
    }

    Arrays.sort(elements);
    Arrays.sort(arr, (a, b) -> (Integer.compare(a[1], b[1])));
    for (int i = 1; i <= n; i++) {
      arr[i][0] += arr[i-1][0];
    }

    int max = -1;
    for (int i = 1; i <= n; i++) {
      int b = Arrays.binarySearch(elements, elements[i]+2*k);
      if (b<0) b = b*-1-2;
      max = Math.max(arr[b][0] - arr[i-1][0], max);
    }
    pw.println(max);
    pw.close();



  }
}
