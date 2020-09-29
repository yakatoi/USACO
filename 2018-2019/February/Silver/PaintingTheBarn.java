import java.util.*;
import java.io.*;

public class PaintingTheBarn {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
      String[] inp = br.readLine().split(" ");
      int n = Integer.parseInt(inp[0]);
      int k = Integer.parseInt(inp[1]);
      int[][] dp = new int[1001][1001];
      for (int i = 0; i < n; i++) {
         int[] inp1 = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
         dp[inp1[0]][inp1[1]]++;
         dp[inp1[0]][inp1[3]]--;
         dp[inp1[2]][inp1[1]]--;
         dp[inp1[2]][inp1[3]]++;
         }
      int counter = 0;
      for (int i = 0; i < 1000; i++) {
         for (int j = 0; j < 1000; j++) {
            if (i>0) {
               dp[i][j] += dp[i-1][j];
               }
            if (j>0) {
               dp[i][j] += dp[i][j-1];
               }
            if(i>0 && j>0) {
               dp[i][j] -= dp[i-1][j-1];
               }
            if(dp[i][j] == k) {
               counter++;
               }
            }
         }
      pw.println(counter);
      pw.close();
      }
   }
