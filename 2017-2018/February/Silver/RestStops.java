import java.util.*;
import java.io.*;

public class RestStops {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
    int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
    long l = inp[0] * 1L;
    long n = inp[1] * 1L;
    long rf = inp[2] * 1L;
    long rb = inp[3] * 1L;
    long[][] arr = new long[(int) n][2];
    for (int i = 0; i < n; i++) {
      String[] inp1 = br.readLine().split(" ");
      arr[i][0] = Long.parseLong(inp1[0]);
      arr[i][1] = Long.parseLong(inp1[1]);
    }
    boolean[] bool = new boolean[(int) n];
    long maxTaste = 0;
    for (int i = (int) n-1; i >= 0; i--) {
      if (arr[i][1] > maxTaste) {
        bool[i] = true;
        maxTaste = arr[i][1];
      }
    }
    long ans = 0;
    long tf = 0;
    long tb = 0;
    long prev = 0;
    for (int i = 0; i < n; i++) {
      if (bool[i]) {
        tf+=(arr[i][0] - prev) * rf;
        tb+=(arr[i][0] - prev) * rb;
        ans += (tf-tb)*arr[i][1];
        tb = tf;
        prev = arr[i][0];
      }
    }
    pw.println(ans);

    pw.close();
  }

}
