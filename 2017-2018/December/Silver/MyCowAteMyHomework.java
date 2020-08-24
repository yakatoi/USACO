import java.util.*;
import java.io.*;

public class MyCowAteMyHomework {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("homework.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] inp = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(inp[i]);
    }
    int[] pre = new int[n];
    pre[0] = arr[0];
    for (int i = 1; i < n; i++) {
      pre[i] = pre[i-1] + arr[i];
    }
    int sum = pre[n-1];
    int[] min = new int[n];
    min[n-1] = arr[n-1];
    for (int i = n-2; i >= 0; i--) {
      min[i] = Math.min(min[i+1], arr[i]);
    }
    /*
    System.out.println("Array: " + Arrays.toString(arr));
    System.out.println("Prefix: " + Arrays.toString(pre));
    System.out.println("Minimum: " + Arrays.toString(min));
    */
    double max = 0;
    for (int i = 0; i < n-2; i++) {
      int comp = sum - pre[i];
      comp-=min[i+1];
      //System.out.println(i + " " + ((double) comp)/(n-i-2));
      max = Math.max(max, ((double) comp)/(n-i-2));
    }
    Set<Integer> set = new HashSet<Integer>();
    //System.out.println(max);
    for (int i = 0; i < n-2; i++) {
      int comp = sum - pre[i];
      comp-=min[i+1];
      if (((double) comp)/(n-i-2)==max) {
        set.add(i+1);
      }
    }
    for (int it: set) {
      pw.println(it);
    }
    pw.close();
  }
}
