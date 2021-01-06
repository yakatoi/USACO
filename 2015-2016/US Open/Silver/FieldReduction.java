import java.util.*;
import java.io.*;

public class FieldReduction {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
    int n = Integer.parseInt(br.readLine());
    int[][] inp = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] inps = br.readLine().split(" ");
      inp[i][0] = Integer.parseInt(inps[0]);
      inp[i][1] = Integer.parseInt(inps[1]);
    }
    Arrays.sort(inp, (a, b) -> Integer.compare(a[0], b[0]));
    int[] minx = new int[4]; minx[0] = inp[0][0];minx[1] = inp[1][0];minx[2] = inp[2][0];minx[3] = inp[3][0];
    int[] maxx = new int[4]; maxx[0] = inp[n-4][0];maxx[1] = inp[n-3][0];maxx[2] = inp[n-2][0];maxx[3] = inp[n-1][0];
    int[] miny = new int[4];
    int[] maxy = new int[4];
    Arrays.sort(inp, (a, b) -> Integer.compare(a[1], b[1]));
    miny[0] = inp[0][1];miny[1] = inp[1][1];miny[2] = inp[2][1];miny[3] = inp[3][1];
    maxy[0] = inp[n-4][1];maxy[1] = inp[n-3][1];maxy[2] = inp[n-2][1];maxy[3] = inp[n-1][1];

    int minArea = Integer.MAX_VALUE;
    for (int a = 0; a < 4; a++) {
      for (int b = 0; b < 4; b++) {
        for (int c = 0; c < 4; c++) {
          for (int d = 0; d < 4; d++) {
            int counter = 0;
            for (int i = 0; i < n; i++) {
              if (!(inp[i][0] >= minx[a] && inp[i][0] <= maxx[b] && inp[i][1] >= miny[c] && inp[i][1] <= maxy[d])) {
                counter++;
              }
            }
            if (counter <= 3) {
              minArea = Math.min(minArea, (maxx[b] - minx[a])*(maxy[d] - miny[c]));
            }
          }
        }
      }
    }
    System.out.println(minArea);
    pw.println(minArea);
    pw.close();
  }
}
