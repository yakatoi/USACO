import java.util.*;
import java.io.*;

public class CowRace {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("cowrace.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("cowrace.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] b = new int[n][2];
    int[][] e = new int[m][2];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      b[i][0] = Integer.parseInt(st.nextToken());
      b[i][1] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      e[i][0] = Integer.parseInt(st.nextToken());
      e[i][1] = Integer.parseInt(st.nextToken());
    }
    String winner = "N";
    int counter = -1;
    int i = 0;
    int j = 0;
    int t = 0;
    int ad = 0;
    int bd = 0;
    t = 0;
    while (i < n && j < m) {
      if (i < n) {
        ad+=b[i][0];
        b[i][1]--;
      }
      if (j < m) {
        bd+=e[j][0];
        e[j][1]--;
      }
      //if (winner.equals("B") && ad==bd) {winner="N";counter++;}
      if (winner.equals("B") && ad < bd) {winner = "E";counter++;}
      if (winner.equals("N") && ad < bd) {winner = "E";counter++;}
      if (winner.equals("N") && ad > bd) {winner = "B";counter++;}
      //if (winner.equals("E") && ad==bd) {winner="N";counter++;}
      if (winner.equals("E") && ad > bd) {winner = "B";counter++;}

      if (b[i][1]==0 && i < n) {
        i++;
      }
      if (e[j][1]==0 && j < m) {
        j++;
      }
      if (b[n-1][1]==0 && e[m-1][1]==0) {
        break;
      }
      t++;
    }
    pw.println(counter);
    pw.close();
  }
}
