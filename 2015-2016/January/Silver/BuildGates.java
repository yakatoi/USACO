import java.util.*;
import java.io.*;

public class BuildGates {
  public static int n;
  public static boolean[][] visited;
  public static int[][] arr;
  public static void print() {
    for (int[] row : arr) {
      for (int ele : row) {
        System.out.print(ele + " ");
      }
      System.out.println();
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("gates.out"));
    n = Integer.parseInt(br.readLine());
    String[] inp = br.readLine().split("");
    int up, right, left, down, x, y;
    up = right = left = down = x = y = 0;
    for (String inst : inp) {
      if (inst.equals("N")) x+=2;
      if (inst.equals("S")) x-=2;
      if (inst.equals("E")) y+=2;
      if (inst.equals("W")) y-=2;
      up = Math.max(up, x);
      right = Math.max(right, y);
      down = Math.min(down, x);
      left = Math.min(left, y);
    }
    System.out.println(up + " " + down + " " + right + " " + left);
    arr = new int[up - down + 1][right - left + 1];
    visited = new boolean[up -down + 1][right-left + 1];
    down*=-1;
    left*=-1;
    x = up;
    y = left;
    System.out.println(x + " " + y);
    for (String inst : inp) {
      arr[x][y] = 1;
      if (inst.equals("N")) x++;
      if (inst.equals("S")) x--;
      if (inst.equals("E")) y++;
      if (inst.equals("W")) y--;
      arr[x][y] = 1;
      if (inst.equals("N")) x++;
      if (inst.equals("S")) x--;
      if (inst.equals("E")) y++;
      if (inst.equals("W")) y--;
    }
    print();


  }
}
