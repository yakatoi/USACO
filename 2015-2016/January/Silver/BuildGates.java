import java.util.*;
import java.io.*;

public class BuildGates {
  public static int dim = 56;
  public static int[][] arr = new int[2*dim][2*dim];
  public static int x = dim;
  public static int y = dim;
  public static boolean[][] visited = new boolean[2*dim][2*dim];
  public static void print() {for (int[] row : arr) {for (int ele : row) {System.out.print(ele + " ");}System.out.println();}}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("gates.out"));
    int n = Integer.parseInt(br.readLine());
    String[] inp = br.readLine().split("");
    arr[x][y] = 1;
    for (String inst : inp) {
      if (inst.equals("N")) x--;
      if (inst.equals("S")) x++;
      if (inst.equals("E")) y--;
      if (inst.equals("W")) y++;
      arr[x][y] = 1;
      visited[x][y] = true;
      if (inst.equals("N")) x--;
      if (inst.equals("S")) x++;
      if (inst.equals("E")) y--;
      if (inst.equals("W")) y++;
      arr[x][y] = 1;
      visited[x][y] = true;
    }
    floodfill(2, 0, 0);
    int paintnum = 3;
    for (int i = 0; i < 2*dim; i++) {
      for (int j = 0; j < 2*dim; j++) {
        if (arr[i][j]==0) {
          floodfill(paintnum, i, j);
          paintnum++;
        }
      }
    }
    pw.println(paintnum - 3);
    pw.close();
    //print();
  }
  public static void floodfill(int paint, int a, int b) {
    if (a < 0 || a >= 2*dim || b < 0 || b >= 2*dim) return;
    if (visited[a][b] || arr[a][b] == paint) return;
    visited[a][b] =true;
    arr[a][b] = paint;
    floodfill(paint, a+1, b);
    floodfill(paint, a-1, b);
    floodfill(paint, a, b+1);
    floodfill(paint, a, b-1);
  }
}
