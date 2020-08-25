import java.util.*;
import java.io.*;

public class LoadBalancing {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
    String[] inp = br.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    int b= Integer.parseInt(inp[1]);
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] inp1 = br.readLine().split(" ");
      arr[i][0] = Integer.parseInt(inp1[0]);
      arr[i][1] = Integer.parseInt(inp1[1]);
    }
    Set<Integer> x = new HashSet<Integer>();
    Set<Integer> y = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      x.add(arr[i][0]-1);
      x.add(arr[i][0]+1);
      y.add(arr[i][1]-1);
      y.add(arr[i][1]+1);
    }

    int min = Integer.MAX_VALUE;
    for (int xx: x) {
      for (int yy: y) {
        int max = 0;
        int q1 = 0;
        int q2 = 0;
        int q3 = 0;
        int q4 = 0;
        for (int i = 0; i < n; i++) {
          if (arr[i][0] > xx && arr[i][1] > yy) {
            q1++;
          }
          if (arr[i][0] < xx && arr[i][1] > yy) {
            q2++;
          }
          if (arr[i][0] < xx && arr[i][1] < yy) {
            q3++;
          }
          if (arr[i][0] > xx && arr[i][1] < yy) {
            q4++;
          }
        }
        max = Math.max(Math.max(q1, q2), Math.max(q3, q4));
        //System.out.println(max);
        min = Math.min(min, max);
      }
    }
    pw.println(min);
    pw.close();
  }
}
