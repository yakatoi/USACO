import java.util.*;
import java.io.*;

public class MilkPails {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("pails.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int xlim = m/x;
    int ylim = m/y;
    int max = 0;
    for (int i = 0; i <= xlim; i++) {
      for (int j = 0; j <= ylim; j++) {
        if (i*x+j*y <= m) {
          max = Math.max(max, i*x+j*y);
        }
      }
    }
    pw.println(max);
    pw.close();
  }
}
