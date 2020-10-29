import java.util.*;
import java.io.*;

public class MooyoMooyo {
  public static int[][] arr;
  public static boolean[][] visited;
  public static int n;
  public static void print() {
    for (int[] row : arr) {
      for (int ele : row) {
        System.out.print(ele);
      }
      System.out.println();
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("mooyomooyo.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    arr = new int[n][10];
    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(inp[j]);
      }
    }
    //print();
    boolean isChange = true;
    while (isChange) {
      isChange = false;
      visited = new boolean[n][10];
      for (int i = n-1; i >= 0; i--) {
        for (int j = 0; j < 10; j++) {
          if (!visited[i][j] && arr[i][j]!=0) {
            int orig = arr[i][j];
            floodfill(arr[i][j], i, j);
            if (arr[i][j] != arr[j][i]) {
              floodfill(i , j , 0)
            }
            if (count() >= k) {
              replace(0);
              isChange = true;
            }
            else {
              replace(orig);
            }
          }
        }
      }
      gravity();
    }
    print();
    for (int[] row : arr) {
      if (row[0]!= 1) {}
        for (int ele : row) {
          pw.print(ele);
        }
        pw.println();
      }
    }
    pw.close();
  }
  public static int count() {
    int counter = 0;
    for (int[] row : arr) {
      for (int ele : row) {
        if (ele==-1) counter++;
          }
    }
    return counter;
  }
  public static void replace(int x) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 10; j++) {
        if (arr[i][j]==-1) {
          arr[i][j] = x;
        }
      }
    }
  }
  public static void floodfill(int orig, int x, int y) {
    if (x < 0 || x >= n || y < 0 || y >= 10 || visited[x][y] || arr[x][y]!= orig) return;
    visited[x][y] = true;
    arr[x][y] = -1;
    floodfill(orig, x+1, y  );
    floodfill(orig, x  , y+1);
    floodfill(orig, x-1, y  );
    floodfill(orig, x  , y-1);
  }
  public static void gravity() {
    boolean changed = true;
    while (changed) {
      changed = false;
      for (int j = 0; j < 10; j++) {
        for (int i = n-1; i > 0; i--) {
          if (arr[i][j]==0 && arr[i-1][j]!=0) {
            arr[i][j] = arr[i-1][j];
            arr[i-1][j] = 0;
            changed = true;
          }
        }
      }
    }
  }
}
