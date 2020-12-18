import java.util.*;
import java.io.*;

public class SwapitySwapitySwap {
  static int n, m, k;
  static int[] arr;
  static int[] mark;
  static int counter = 1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("swap.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("swap.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new int[n];
    mark = new int[n];
    for (int i = 0; i < n; i++) arr[i] = i;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) -1;
      int b = Integer.parseInt(st.nextToken()) -1;
      flip(a, b);
    }
    System.out.println(Arrays.toString(arr));
    for (int i = 0; i < n; i++) {
      if (mark[i] == 0) {
        dfs(i);
        counter++;
      }
    }
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int ele: mark) {
      if (!map.keySet().contains(ele)) map.put(ele, 0);
      map.put(ele, map.get(ele)+ 1);
    }
    for (int i = 0; i < n; i++) {
      if (map.get(mark[i]) == 1) {
        System.out.println(i+1);
        pw.println(i+1);
        continue;
      }
      int rep = k % map.get(mark[i]);
      int bef = i;
      for (int j = 0; j < rep; j++) {
        bef = arr[bef];
      }
      System.out.println(bef+1);
      pw.println(bef+1);
    }
    pw.close();

  }
  static void dfs(int node) {
    mark[node] = counter;
    if (mark[arr[node]] == 0) dfs(arr[node]);
  }
  static void flip(int one, int two) {
    for (int i = one; i <= (one+two)/2; i++) {
      int temp = arr[i];
      arr[i] = arr[one+two-i];
      arr[one+two-i] = temp;
    }
  }
}
