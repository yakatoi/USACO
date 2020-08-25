import java.util.*;
import java.io.*;

public class SleepyCowHerding {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("herding.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
    int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(inp);
    int a = inp[0];
    int b = inp[1];
    int c = inp[2];
    int min = 0;
    int max = Math.max(b-a, c-b)-1;
    if (!(a+1==b && b+1==c)) {
      if (a+1==b || b+1==c || b+2==c || a+2==b || a+2==c) {
        min = 1;
      }
      else {
        min = 2;
      }
    }
    pw.println(min);
    pw.println(max);
    pw.close();
  }
}
