import java.util.*;
import java.io.*;

public class WhyDidTheCowCrossTheRoadI {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
    String[] inp = br.readLine().split(" ");
    int c = Integer.parseInt(inp[0]);
    int n = Integer.parseInt(inp[1]);
    int[] chi = new int[c];
    for (int i = 0; i < c; i++) {
      chi[i] = Integer.parseInt(br.readLine());
    }
    int[][] moo = new int[n][2];
    for (int i = 0; i < n; i++) {
      int[] inp1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      moo[i][0] = inp1[0];
      moo[i][1] = inp1[1];
    }
    Arrays.sort(moo, (a, b) -> Integer.compare(a[0], b[0]));
    Arrays.sort(chi);
    int counter = 0;
    int a = 0;
    int b = 0;
    while (a < c && b < n) {
      if (isBetween(moo[b][0], moo[b][1], chi[a])) {
        counter++;
        a++;
        b++;
      }
      else if (chi[a] < moo[b][0]) {
        a++;
      }
      else {
        b++;
      }
    }
    pw.println(counter);
    pw.close();
  }
  public static boolean isBetween(int a, int b, int c) {
    return (c >= a && c <= b);
  }
}
