import java.util.*;
import java.io.*;

public class ModernArt {
  public static int[][] arr;
  public static int n;
  public static void print2D() {for (int[] row : arr) {for (int ele : row) {System.out.print(ele);}System.out.println();}}
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("art.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("art.out"));
    HashSet<Integer> ans = new HashSet<Integer>();
    HashSet<Integer> set = new HashSet<Integer>();
    n = Integer.parseInt(br.readLine());
    int[][] dim = new int[10][4];
    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      String[] inp = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(inp[j]);
        if (!set.contains(arr[i][j])) {
          dim[arr[i][j]][0] = i;
          dim[arr[i][j]][1] = i;
          dim[arr[i][j]][2] = j;
          dim[arr[i][j]][3] = j;
          set.add(arr[i][j]);
          ans.add(arr[i][j]);
        }
        else {
          dim[arr[i][j]][0] = Math.min(dim[arr[i][j]][0], i);
          dim[arr[i][j]][1] = Math.max(dim[arr[i][j]][1], i);
          dim[arr[i][j]][2] = Math.min(dim[arr[i][j]][2], j);
          dim[arr[i][j]][3] = Math.max(dim[arr[i][j]][3], j);
        }
      }
    }
    set.remove(0);
    ans.remove(0);
    for (int i = 0; i < 10; i++) {
      if (set.contains(i)) {
        //System.out.println(i + " : " + dim[i][0] + ", " + dim[i][1] + ", " + dim[i][2] + ", " + dim[i][3]);
      }
    }
    for (int a = 0; a < 10; a++) {
      for (int b = a + 1; b < 10; b++) {
        if (set.contains(a) && set.contains(b)) {
          if (isBet(dim[a][0], dim[a][1], dim[b][0], dim[b][1]) && isBet(dim[a][2], dim[a][3], dim[b][2], dim[b][3])) {
            //System.out.println(a + " " + b);
            int res = (count(a, b, dim, n));
            ans.remove(res);
          }
        }
      }
    }
    pw.println(ans.size());
    pw.close();
  }
  public static boolean isBet(int a, int b, int c, int d) {
    if (b==c || a==d) return true;
    if (c < b && c >= a) return true;
    if (d > a && d <= b) return true;
    if (c <= a && c<= b && d>=a &&d >= b) return true;
    if (a <= c && a<= d && b>=c && b>= d) return true;
    return false;

  }
  public static boolean bet(int a, int b, int c) {return c >= a && c<= b;}
  public static int count(int a, int b, int[][] dim, int n) {
    for (int i = 0; i< n; i++) {
      for (int j = 0; j < n; j++) {
        if (bet(dim[a][0], dim[a][1], i) && bet(dim[a][2], dim[a][3], j) && bet(dim[b][0], dim[b][1], i) && bet(dim[b][2], dim[b][3], j)) {
          if (arr[i][j]== a) return a;
          else if (arr[i][j]== b) return b;
          else {
            return -1;
          }
        }
      }
    }
    return -1;
  }
}
