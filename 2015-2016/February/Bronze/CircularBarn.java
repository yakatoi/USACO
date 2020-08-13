import java.util.*;
import java.io.*;

public class CircularBarn {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      sum+=arr[i];
    }
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      int footsteps = 0;
      for (int i = j; i < j+n; i++) {
        footsteps+=arr[i%n]*(i-j);
      }
      if (footsteps < min) {
        min = footsteps;
      }
    }
    pw.println(min);
    pw.close();
    br.close();
  }
}
