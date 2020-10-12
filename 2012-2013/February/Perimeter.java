import java.util.*;
import java.io.*;

public class Perimeter {

  //public static HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
  //public static HashSet<Integer> set = new HashSet<Integer>();
  public static boolean[][] visited = new boolean[100][100];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("perimeter.out"));
    int n  = Integer.parseInt(br.readLine());
    int[][] arr = new int[100][100];
    for (int i = 0; i <= 9999; i++) {
    //  set.add(i);
    }   
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        arr[i][j] = -1;
      }
    }
    //map.put(1, new HashSet<Integer>());
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken())-1;
      int y = Integer.parseInt(st.nextToken())-1;
      //map.get(1).add(100*x+y);
      arr[x][y] = 1;
      visited[x][y] = true;

    }
    int rx = -1;
    int ry =-1;
    for (int i = 0; i < 100; i++) {
      if (!visited[0][i]) {
        rx = 0;
        ry = i;
        break;
      }
    }
    if (rx+ry==-2) {
      for (int i = 0; i < 100; i++) {
        if (!visited[i][0]) {
          rx = i;
          ry = 0;
          break;
        }
      }
    }
    if (rx+ry==-2) {
      for (int i = 0; i < 100; i++) {
        if (!visited[99][i]) {
          ry = i;
          rx = 99;
          break;
        }
      }
    }
    if (rx+ry==-2) {
      for (int i = 0; i < 100; i++) {
        if (!visited[i][99]) {
          ry = 99;
          rx = i;
          break;
        }
      }

    }

    floodfill(rx, ry, 0, arr);
    int sum = 0;
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (arr[i][j]==1) {
          sum+=4;
          if (i+1 < 100 && arr[i+1][j]==1) sum--;
          if (j+1 < 100 && arr[i][j+1]==1) sum--;
          if (i-1 >= 0 && arr[i-1][j]==1) sum--;
          if (j-1 >= 0 && arr[i][j-1]==1) sum--;
        }
      }
    }
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (arr[i][j]==-1) {
          sum-=4;
          if (i+1 < 100 && arr[i+1][j]==-1) sum++;
          if (j+1 < 100 && arr[i][j+1]==-1) sum++;
          if (i-1 >= 0 && arr[i-1][j]==-1) sum++;
          if (j-1 >= 0 && arr[i][j-1]==-1) sum++;
        }
      }
    }
    pw.println(sum);
    pw.close();
  }
  public static void floodfill(int x, int y, int turnto, int[][] arr) {
    if (x < 0 || x >= 100 || y < 0 || y >=100 || visited[x][y]) {
      return;
    }
    visited[x][y] = true;
    //System.out.println(map.get(turnto).size());
    //map.get(turnto).add(100*x+y);
    arr[x][y] = turnto;

    floodfill(x+1, y, turnto, arr);
    floodfill(x-1, y, turnto, arr);
    floodfill(x, y+1, turnto, arr);
    floodfill(x, y-1, turnto, arr);
  }
}
