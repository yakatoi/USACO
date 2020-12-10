import java.util.*;
import java.io.*;

public class BovineGenomics {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("cownomics.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] spotty = new int[n][m];
    int[][] plain = new int[n][m];
    for (int i = 0; i < n; i++) {
      String[] arr = br.readLine().split("");
      for (int j = 0; j < arr.length; j++) {
        if (arr[j].equals("A")) {
          spotty[i][j] = 0;
        }
        if (arr[j].equals("T")) {
          spotty[i][j] = 1;
        }
        if (arr[j].equals("C")) {
          spotty[i][j] = 2;
        }
        if (arr[j].equals("G")) {
          spotty[i][j] = 3;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      String[] arr = br.readLine().split("");
      for (int j = 0; j < arr.length; j++) {
        if (arr[j].equals("A")) {
          plain[i][j] = 0;
        }
        if (arr[j].equals("T")) {
          plain[i][j] = 1;
        }
        if (arr[j].equals("C")) {
          plain[i][j] = 2;
        }
        if (arr[j].equals("G")) {
          plain[i][j] = 3;
        }
      }
    }
    int counter = 0;
    for (int a = 0; a < m; a++) {
      for (int b = a+1; b < m; b++) {
        for (int c = b+1; c < m; c++) {
          HashSet<Integer> set = new HashSet<Integer>();
          for (int i = 0; i < n; i++) {
            set.add(16*spotty[i][a] + 4*spotty[i][b] + spotty[i][c]);
          }
          boolean match = true;
          for (int i = 0; i < n; i++) {
            if (set.contains(16*plain[i][a] + 4*plain[i][b] + plain[i][c])) {
              match = false;
            }
          }
          if (match) {
            counter++;
          }
        }
      }
    }
    pw.println(counter);
    pw.close();
  }
}
