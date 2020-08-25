import java.util.*;
import java.io.*;

public class TamingTheHerd {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("taming.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    boolean[] breakout = new boolean[n];
    breakout[0] = true;
    for (int i = 0; i < n; i++) {
      if (arr[i]!=-1) {
        breakout[i-arr[i]] = true;
      }
    }
    //System.out.println(Arrays.toString(arr));
    //System.out.println(Arrays.toString(breakout));
    int min = 0;
    for (int i = 0; i < n; i++) {
      min = breakout[i] ? min + 1 : min;
    }
    int max = min;
    for (int i = 0; i < n; i++) {
      max = (!breakout[i] && arr[i]==-1) ? max+1 : max;
    }
    pw.println(min + " " + max);
    pw.close();
  }
}
