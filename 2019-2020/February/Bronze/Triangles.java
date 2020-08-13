import java.util.*;
import java.io.*;

public class Triangles {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split(" ");
      arr[i][0] = Integer.parseInt(inp[0]);
      arr[i][1] = Integer.parseInt(inp[1]);
    }
    int max = -1;
    for (int a = 0; a < n; a++) {
      for (int b = a+1; b < n; b++) {
        for (int c = b+1; c < n; c++) {
          if (isAccepted(arr[a][0], arr[a][1], arr[b][0], arr[b][1], arr[c][0], arr[c][1])) {
            int y = arr[a][0]*arr[b][1] + arr[b][0]*arr[c][1] + arr[c][0]*arr[a][1];
            int z = arr[a][1] * arr[b][0] + arr[b][1]*arr[c][0] + arr[c][1]*arr[a][0];
            max = Math.max(Math.abs(y-z), max);
          }
        }
      }
    }
    pw.println(max);
    pw.close();

  }
  public static boolean isAccepted(int a1, int a2, int b1, int b2, int c1, int c2) {
    if ((a1==b1 && a1==c1) && (a2==b2 && a2==c2)) {
      return false;
    }
    return (a1==b1 || a1==c1 || b1==c1) && (a2==b2 || a2==c2 || b2==c2);
  }
}
