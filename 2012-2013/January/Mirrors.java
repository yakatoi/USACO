import java.util.*;
import java.io.*;

public class Mirrors {

  public static int maxx;
  public static int maxy;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("mirrors.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int biggestMin = 0;
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    if (a < 0) {
      biggestMin = -1*a;
    }
    if (b < 0) {
      biggestMin = -1*b;
    }
    String[][] inp = new String[n][3];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      inp[i][0] = st.nextToken();
      inp[i][1] = st.nextToken();
      inp[i][2] = st.nextToken();
      if (Integer.parseInt(inp[i][0]) < 0) {
        biggestMin = Math.max(biggestMin, -1*Integer.parseInt(inp[i][0]));
      }
      if (Integer.parseInt(inp[i][1]) < 0) {
        biggestMin = Math.max(biggestMin, -1*Integer.parseInt(inp[i][1]));
      }
      if (!inp[i][2].equals("/")) {
        inp[i][2] = "!";
      }
      maxx = Math.max(maxx, Integer.parseInt(inp[i][0]));
      maxy = Math.max(maxy, Integer.parseInt(inp[i][1]));
    }
    a+=biggestMin;
    b+=biggestMin;
    for (int i = 0; i < inp.length; i++) {
      inp[i][0] = (Integer.parseInt(inp[i][0]) + biggestMin) +"";
      inp[i][1] = (Integer.parseInt(inp[i][1]) + biggestMin) +"";
    }
    maxx+=biggestMin;
    maxy+=biggestMin;
    maxx = Math.max(maxx, a);

    maxy = Math.max(maxy, b);
    maxx++;
    maxy++;
    //System.out.println("\\");
    String[][] arr = new String[maxx][maxy];
    for (int i = 0; i < maxx; i++) {
      for (int j = 0; j < maxy; j++) {
        arr[i][j] = ".";
      }
    }
    for (int i = 0;i < n; i++) {
      arr[Integer.parseInt(inp[i][0])][Integer.parseInt(inp[i][1])] = inp[i][2];
    }
    arr[a][b] = "B";
    //arr[0][0] = "H";
    if (hit(arr, 1) || hit(arr, 0)) {
      System.out.println(0);
    }
    else {
      for (int i = inp.length-1; i>=0; i--) {
        if (arr[Integer.parseInt(inp[i][0])][Integer.parseInt(inp[i][1])].equals("/")) {
          arr[Integer.parseInt(inp[i][0])][Integer.parseInt(inp[i][1])] = "!";
        }
        else {
          arr[Integer.parseInt(inp[i][0])][Integer.parseInt(inp[i][1])] = "/";
        }
        if (hit(arr, 0) || hit(arr, 1)) {
          System.out.println(i+1);
          break;
        }
        if (arr[Integer.parseInt(inp[i][0])][Integer.parseInt(inp[i][1])].equals("/")) {
          arr[Integer.parseInt(inp[i][0])][Integer.parseInt(inp[i][1])] = "!";
        }
        else {
          arr[Integer.parseInt(inp[i][0])][Integer.parseInt(inp[i][1])] = "/";
        }

      }
    }
    pw.close();

  }

  public static boolean hit(String[][] arr, int m) {
    int x = 0;
    int y = 0;
    int motion = m;
    boolean first = true;
    while (true) {
      first = true;
      if (arr[x][y].equals("B")) {
        return true;
      }
      if (motion == 1) {
        while ((first) ||(x < maxx && arr[x][y].equals("."))) {
          x++;
          if (x ==maxx) {
            return false;
          }
          if (arr[x][y].equals("B")) {
            return true;
          }
          first = false;
        }

        if (arr[x][y].equals(".")) {
          return false;
        }
        if (arr[x][y].equals("/")) {
          motion = 0;
        }
        else {
          motion = 2;
        }
      }
      else if (motion == 3) {
        while ((first) || (x >= 0 && arr[x][y].equals("."))) {
          x--;
          if (x<0) {
            return false;
          }
          first = false;
          if (arr[x][y].equals("B")) {
            return true;
          }
        }
        if (arr[x][y].equals(".")) {
          return false;
        }
        if (arr[x][y].equals("/")) {
          motion = 2;
        }
        else {
          motion = 0;
        }
      }
      else if (motion == 2) {
        while ((first) ||(y >= 0 && arr[x][y].equals("."))) {
          y--;
          if (y < 0) {
            return false;
          }
          first = false;
          if (arr[x][y].equals("B")) {
            return true;
          }
        }
        if (arr[x][y].equals(".")) {
          return false;
        }
        if (arr[x][y].equals("/")) {
          motion = 1;
        }
        else {
          motion = 3;
        }
      }
      else if (motion == 0) {
        while ((first) ||(y < maxy && arr[x][y].equals("."))) {
          y++;
          if (maxy==y) {
            return false;
          }
          first = false;
          if (arr[x][y].equals("B")) {
            return true;
          }
        }
        if (arr[x][y].equals(".")) {
          return false;
        }
        if (arr[x][y].equals("/")) {
          motion = 3;
        }
        else {
          motion = 1;
        }
      }
    }
  }

}
