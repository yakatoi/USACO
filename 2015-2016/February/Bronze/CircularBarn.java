import java.util.*;
import java.io.*;

public class CircularBarn {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] d = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      d[i] = Integer.parseInt(br.readLine());
      sum+=d[i];
    }
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      int num = 0;
      for (int i = j; i < j+n; i++) {
        num+=d[i%n]*(i-j);
      }
      if (num < min) {
        min = num;
      }
    }
    pw.println(min);
    pw.close();
    br.close();
  }
}
