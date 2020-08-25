import java.util.*;
import java.io.*;

public class ContaminatedMilk {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new FileReader("badmilk.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
    String[] inp = br.readLine().split(" ");

    int n = Integer.parseInt(inp[0]);
    int m = Integer.parseInt(inp[1]);
    int d = Integer.parseInt(inp[2]);
    int s = Integer.parseInt(inp[3]);
    int[][][] arr = new int[n+1][101][m+1];

    for (int co = 0; co < d; co++) {
      String[] inp1 = br.readLine().split(" ");
      int a = Integer.parseInt(inp1[0]);
      int b = Integer.parseInt(inp1[1]);
      int c = Integer.parseInt(inp1[2]);
      for (int i = c; i < 101; i++) {
        arr[a][i][b] = 1;
      }
    }

    Set<Integer> set = new HashSet<Integer>();
    Set<Integer> aff = new HashSet<Integer>();
    Set<Integer> whatwewanttoremovefromset = new HashSet<Integer>();

    for (int co = 0; co < s; co++) {
      String[] inp2 = br.readLine().split(" ");
      int a = Integer.parseInt(inp2[0]);
      int b = Integer.parseInt(inp2[1]);
      aff.add(a);

      for (int i = b; i >= 1; i--) {
        for (int j = 1; j <= m; j++) {
          if (arr[a][i][j]!=0) {
            set.add(j);
          }
        }
      }
      
    }
    for (int pos : set) {
      for (int per : aff) {
        boolean check = true;
        for (int i = 1; i <= 100; i++) {
          if (arr[per][i][pos]!=0) {
            check = false;
          }
        }
        if (check) {
          whatwewanttoremovefromset.add(pos);
        }
      }
    }
    for (int what : whatwewanttoremovefromset) {
      set.remove(what);
    }
    int maxDose = 0;
    for (int milk : set) {
      HashSet<Integer> count = new HashSet<Integer>();
      for (int t = 1; t <= 100; t++) {
        for (int per = 1; per <= n; per++) {
          if (arr[per][t][milk]!=0) {
            count.add(per);
          }
        }
      }
      maxDose = Math.max(maxDose, count.size());
    }
    /*
    for (int a  = 0; a < n+1; a++) {
      for (int b = 0; b < 101; b++) {
        System.out.println(a + " " + b +  ": " + Arrays.toString(arr[a][b]));
      }
    }
    */
    pw.println(maxDose);
    pw.close();
  }
}
