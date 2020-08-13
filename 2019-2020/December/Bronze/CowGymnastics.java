import java.util.*;
import java.io.*;

public class CowGymnastics {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int[][] arr = new int[k][n];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int counter = 0;
    for (int a = 1; a <= n; a++) {
      for (int b = 1; b<=n; b++) {
        boolean check = true;
        for (int i = 0; i < k; i++) {
          if (check) {
            check = a!=b && checkArr(arr[i], a, b);
          }
        }
        if (check) {
          counter++;
        }
      }
    }
    pw.println(counter);
    pw.close();
  }
  public static boolean checkArr(int[] arr, int a, int b) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i]==a) {
        return true;
      }
      if (arr[i]==b) {
        return false;
      }
    }
    return false;
  }
}
