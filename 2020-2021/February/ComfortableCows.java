import java.util.*;
import java.io.*;

public class ComfortableCows {
  static int n, b;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int[][] arr;
  static int[][] count;
  static int threes = 0;

  public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    arr = new int[4000][4000];
    count = new int[4000][4000];
    for (int j = 0; j < n; j++) {
      st=  new StringTokenizer(br.readLine());
      int x=  Integer.parseInt(st.nextToken())+1000;
      int y=  Integer.parseInt(st.nextToken())+1000;
      floodfill(x, y);
      System.out.println(threes);
    }
  }
  public static void floodfill(int x, int y) {
    if (arr[x][y] ==1) {
      threes--;
      return;
    }
    arr[x][y] = 1;
    for (int i = 0; i < 4; i++) {
      count[x+dx[i]][y+dy[i]]++;
    }
    for (int i = 0; i < 4; i++) {
      if (arr[x+dx[i]][y+dy[i]] ==1 ) {
        if (count[x+dx[i]][y+dy[i]] == 3) {
          threes++;
          int ind = -1;
          for (int k = 0; k < 4; k++) {
            if (arr[x+dx[i]+dx[k]][y+dy[i]+dy[k]] == 0) {
              ind = k;
            }
          }
          floodfill(x+dx[i]+dx[ind], y+dy[i]+dy[ind]);
        }
      }
    }
    if (arr[x][y] ==1 && count[x][y] ==3) {
      threes++;
      int ind = -1;
      for (int k = 0; k < 4; k++) {
        if (arr[x+dx[k]][y+dy[k]] == 0) {
          ind = k;
        }
      }
      floodfill(x+dx[ind], y+dy[ind]);
    }

  }
}
