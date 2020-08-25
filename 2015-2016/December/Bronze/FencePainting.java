import java.util.*;
import java.io.*;

public class FencePainting {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("paint.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
    String[] inp1 = br.readLine().split(" ");
    String[] inp2 = br.readLine().split(" ");
    int a = Integer.parseInt(inp1[0]);
    int b = Integer.parseInt(inp1[1]);
    int c = Integer.parseInt(inp2[0]);
    int d = Integer.parseInt(inp2[1]);
    int[] arr = new int[101];
    int ans = a >= d || c >= b ? b-a+d-c: Math.max(b-c, d-a);
    if ((c >= a && b >= d) || (a >= c &&  d>= b)) {
      ans = Math.max(b-a, d-c);
    }
    pw.println(ans);
    pw.close();
  }
}
