import java.util.*;
import java.io.*;

public class PaintingTheBarn {
  static int[][] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("paintbarn.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    arr = new int[14][14];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      addPaint(x1, y1, x2, y2);
    }
    for (int i = 1; i <= 13; i++) {
      for (int j = 1; j <= 13; j++) {
        arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
      }
    }
    int counter = 0;
    for (int[] row : arr) {
      for (int ele : row) {
        if (ele==k) counter++;
      }
    }
    System.out.println(counter);
  }

  static void addPaint(int x1, int y1, int x2, int y2) {
    arr[x1][y1]++;
    arr[x1][y2+1]--;
    arr[x2+1][y1]--;
    arr[x2+1][y2+1]++;
  }
}
